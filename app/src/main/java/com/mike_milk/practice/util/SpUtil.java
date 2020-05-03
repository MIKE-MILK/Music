package com.mike_milk.practice.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.preference.PreferenceManager;

/**
 * 时间：2020/4/28
 * 创建者：MIKE-MILK
 * 描述：SharedPreferences工具类
 */
public class SpUtil {
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;
    private static final String TAG="SharedPreference";
    //放入数据
    public static void put(Context context,String key,Object object){
        preferences=PreferenceManager.getDefaultSharedPreferences(context);
        editor=preferences.edit();
        if (editor!=null){
            if (object instanceof String){
                editor.putString(key,(String)object);
            }else if (object instanceof Integer){
                editor.putInt(key,(Integer)object);
            }else if (object instanceof Boolean){
                editor.putBoolean(key,(boolean)object);
            }else if (object instanceof Float){
                editor.putFloat(key,(float)object);
            }else if (object instanceof Long){
                editor.putLong(key,(long)object);
            }else {
                editor.putString(key, object.toString());
            }
            editor.commit();
        }else {
           LogUtil.e(TAG, "请重试");
        }
    }
    //获取数据
    public static Object get(Context context, String key, Object object){
        preferences=PreferenceManager.getDefaultSharedPreferences(context);
        editor=preferences.edit();
        if (preferences!=null){
            if (object instanceof String) {
                return preferences.getString(key, (String) object);
            } else if (object instanceof Integer) {
                return preferences.getInt(key, (Integer) object);
            } else if (object instanceof Boolean) {
                return preferences.getBoolean(key, (Boolean) object);
            } else if (object instanceof Float) {
                return preferences.getFloat(key, (Float) object);
            } else if (object instanceof Long) {
                return preferences.getLong(key, (Long) object);
            } else {
                return preferences.getString(key, null);
            }
        }else {
            LogUtil.e(TAG, "请重试");
            return null;
        }
    }
    //删去key
    public static void remove(Context context,String key){
        preferences=PreferenceManager.getDefaultSharedPreferences(context);
        editor=preferences.edit();
        if (editor!=null){
            editor.remove(key);
            editor.commit();
        }else {
            LogUtil.e(TAG,"请重试");
        }
    }
    //清除数据
    public static void clear(Context context){
        preferences=PreferenceManager.getDefaultSharedPreferences(context);
        editor=preferences.edit();
        if (editor!=null){
            editor.clear();
            editor.commit();
        }else {
            LogUtil.e(TAG,"请重试");
        }
    }
    //查询某一数据是否存在
    public static boolean check(Context context,String key){
        preferences=PreferenceManager.getDefaultSharedPreferences(context);
        editor=preferences.edit();
        if (preferences!=null){
            return preferences.contains(key);
        }else {
            LogUtil.e(TAG,"请重试");
            return false;
        }
    }
}
