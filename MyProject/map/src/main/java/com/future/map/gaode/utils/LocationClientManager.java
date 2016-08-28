package com.future.map.gaode.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Chenlu on 2016/8/23 0023.
 */
public class LocationClientManager implements AMapLocationListener{

    private static final String TAG = "LocationClientManager";
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;
    private Context mContext;
    private List<OnLocationChangeCallBack> mCallBacks;
    private static LocationClientManager instance;
    private boolean isStart;


    public static LocationClientManager getInstance(Context context) {
        synchronized (TAG) {
            if (instance == null) {
                synchronized (TAG) {
                    if (instance == null) {
                        instance = new LocationClientManager(context);
                        return instance;
                    }
                }
            }
        }
        return instance;
    }


    private LocationClientManager(Context context) {
        mContext = context.getApplicationContext();
        mCallBacks = new ArrayList<>();
        String sha1 = getSHA1(context);
        Log.i(TAG, "sha11~~  :" + sha1);
        init();
    }

    public interface OnLocationChangeCallBack{
        void succeed(AMapLocation aMapLocation);

        void failed(int errorCode, String errorInfo);

    }

    public void registerOnLocationChangeCallBack(OnLocationChangeCallBack onLocationChangeCallBack) {
        if (onLocationChangeCallBack != null && !mCallBacks.contains(onLocationChangeCallBack)) {
            mCallBacks.add(onLocationChangeCallBack);
            synchronized (this) {
                if (!isStart) {
                    //启动定位
                    mlocationClient.startLocation();
                    isStart = true;
                }
            }
        }
    }

    public void unRegisterOnLocationChangeCallBack(OnLocationChangeCallBack onLocationChangeCallBack) {
        if (mCallBacks.contains(onLocationChangeCallBack)) {
            mCallBacks.remove(onLocationChangeCallBack);
            synchronized (this) {
                if (mCallBacks.size() == 0) {
                    //停止定位
                    mlocationClient.stopLocation();
                    isStart = false;
                }
            }
        }
    }
    private void init() {
        mlocationClient = new AMapLocationClient(mContext);
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //设置返回地址信息，默认为true
        mLocationOption.setNeedAddress(true);
        //设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
        mlocationClient.setLocationListener(this);


    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
                //定位成功回调信息，设置相关消息
                aMapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
                aMapLocation.getLatitude();//获取纬度
                aMapLocation.getLongitude();//获取经度
                aMapLocation.getAccuracy();//获取精度信息
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date(aMapLocation.getTime());
                df.format(date);//定位时间
                aMapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                aMapLocation.getCountry();//国家信息
                aMapLocation.getProvince();//省信息
                aMapLocation.getCity();//城市信息
                aMapLocation.getDistrict();//城区信息
                aMapLocation.getStreet();//街道信息
                aMapLocation.getStreetNum();//街道门牌号信息
                aMapLocation.getCityCode();//城市编码
                aMapLocation.getAdCode();//地区编码
                aMapLocation.getAoiName();//获取当前定位点的AOI信息
                for (int i = 0; i < mCallBacks.size(); i++) {
                    mCallBacks.get(i).succeed(aMapLocation);
                }
            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                int errorCode = aMapLocation.getErrorCode();
                String errorInfo = aMapLocation.getErrorInfo();

                Log.e("AmapError","location Error, ErrCode:" + errorCode + ", errInfo:" + errorInfo);
                for (int i = 0; i < mCallBacks.size(); i++) {
                    mCallBacks.get(i).failed(errorCode, errorInfo);
                }
            }
        }

    }

    public static String getSHA1(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), PackageManager.GET_SIGNATURES);
            byte[] cert = info.signatures[0].toByteArray();
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] publicKey = md.digest(cert);
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < publicKey.length; i++) {
                String appendString = Integer.toHexString(0xFF & publicKey[i])
                        .toUpperCase(Locale.US);
                if (appendString.length() == 1)
                    hexString.append("0");
                hexString.append(appendString);
                hexString.append(":");
            }
            String result = hexString.toString();
            return result.substring(0, result.length()-1);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
