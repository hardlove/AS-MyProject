package com.future.map.baidu.utils;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by CL on 2016/8/27.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface  ViewInject{
  int value();
}

/**
 * @Target的意思是我们注解作用的目标，这里是ElementType.FIELD，也就是作用于字段的

　ElementType的类型有以下几种：

1.CONSTRUCTOR:用于描述构造器
　2.FIELD:用于描述字段
　3.LOCAL_VARIABLE:用于描述局部变量
　4.METHOD:用于描述方法
　5.PACKAGE:用于描述包
　6.PARAMETER:用于描述参数
　7.TYPE:用于描述类、接口(包括注解类型) 或enum声明

 @Retention的意思是注解的运行级别

 RetentionPolicy的类型有以下几种

 1.SOURCE:在源文件中有效（即源文件保留）
 　2.CLASS:在class文件中有效（即class保留）
 　3.RUNTIME:在运行时有效（即运行时保留）

 @interface则是表明这个类是一个注解，@号不能漏掉，否则变成了接口了

 如果想对注解了解得更多，可以参考：http://www.cnblogs.com/gmq-sh/p/4798194.html 这篇博文，很详细，对于我们想要的功能，以上的内容就足够了
 */
