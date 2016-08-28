package com.future.myproject.utils;

/**
 * 管理常量的接口
 * Created by Chenlu on 2016/6/30 0030.
 */
public interface Constants {

    //腾讯bugly的AppKeyID
    static String buglyAppKeyId = "900036343";

    static String baseUrl = "";


    static String CHAT_FLAG = "chat_flag_key";
    static String CHAT_TYPE_KEY = "chat_type_key";
    static String GROUPKD_KEY = "groupkd_key";
    static String PHONE_NUMBER_KEY = "phone_number_key";
    static String DATA_KEY = "data_key";

    static int SELECT_PHOTO_REQUEST_CODE = 0x10;//Gallery请求码

    //发送文件的最大限制（单位：字节）
    static long MAX_FILE_SEND_LIMITED_SIZE = 20971520;

}
