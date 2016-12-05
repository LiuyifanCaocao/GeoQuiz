package com.android.liuyifan.geoquiz;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by DELL on 2016/12/5.
 */
public class util {
    static Toast toast;
    public static void show_toast(Context context, int s){
        if (toast == null){
            toast = Toast.makeText(context,s,Toast.LENGTH_SHORT);
        }else {
            toast.setText(s);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}
