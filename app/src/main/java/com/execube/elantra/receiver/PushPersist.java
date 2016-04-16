package com.execube.elantra.receiver;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Prateek Phoenix on 4/16/2016.
 */
public class PushPersist {



    public static boolean addAlertItem(Context context, String alert){

        String alertList= getStringFromPreferences(context);

        if(alertList!=null)
        {
            alertList=alertList+","+alert;
        }

        else
            alertList=alert;
        return putStringInPreference(context,alertList,"alerts");

    }



    private static String getStringFromPreferences(Context context) {

        SharedPreferences sharedPreferences= context.getSharedPreferences("PantheonPreferences", Context.MODE_PRIVATE);
        String temp=sharedPreferences.getString("alerts",null);
        return temp;
    }

    private static boolean putStringInPreference(Context context, String value, String key) {

        SharedPreferences sharedPreferences=context.getSharedPreferences("PantheonPreferences",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.putString(key,value);
        editor.commit();
        return true;

    }

}
