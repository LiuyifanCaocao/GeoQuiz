package com.android.liuyifan.geoquiz;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by DELL on 2016/12/6.
 */
public class ActivityManager {
    private static volatile ActivityManager inStance ;
    private Stack<Activity> mActivities = new Stack<Activity>();
    private ActivityManager(){

    }
    public static ActivityManager getInStance(){
        if (inStance == null){
            synchronized (ActivityManager.class){
                if(inStance == null){
                    inStance = new ActivityManager();
                }
            }
        }
        return inStance;
    }
    public void addActivity(Activity activity){
        mActivities.push(activity);
    }
    public void removeActivity(Activity activity){
        mActivities.remove(activity);
    }
    public void killProcess(){
        int nCount = mActivities.size();
    }
}
