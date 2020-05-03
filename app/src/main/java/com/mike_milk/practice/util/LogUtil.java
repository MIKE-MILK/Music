package com.mike_milk.practice.util;

import android.util.Log;

/**
 * 时间：2020/4/28
 * 创建者：MIKE-MILK
 * 描述：Log工具类
 * 日志级别从高到低为ERROR, WARN, INFO, DEBUG, VERBOSE
 *   1、Log.v的输出颜色为黑色的，输出大于或等于VERBOSE日志级别的信息
 * 　2、Log.d的输出颜色是蓝色的，输出大于或等于DEBUG日志级别的信息
 * 　3、Log.i的输出为绿色，输出大于或等于INFO日志级别的信息
 * 　4、Log.w的输出为橙色,输出大于或等于WARN日志级别的信息
 * 　5、Log.e的输出为红色，仅输出ERROR日志级别的信息.
 */
public class LogUtil {
    //设置一个开关，为true时执行
    private static boolean Switch=true;
    //设置Log的标签
    private static final String TAG="LogUtil";
    //打印Verbose级别
    public static void v(String tag,String msg){
        if (Switch){
            Log.v(tag,msg);
        }
    }
    //打印Debug级别
    public static void d(String tag,String msg){
        if (Switch){
            Log.d(tag,msg);
        }
    }
    //打印Info级别
    public static void i(String tag,String msg){
        if (Switch){
            Log.i(tag,msg);
        }
    }
    //打印Warn级别
    public static void w(String tag,String msg){
        if (Switch){
            Log.w(tag,msg);
        }
    }
    //打印Error级别
    public static void e(String tag,String msg){
        if (Switch){
            Log.e(tag,msg);
        }
    }

}
