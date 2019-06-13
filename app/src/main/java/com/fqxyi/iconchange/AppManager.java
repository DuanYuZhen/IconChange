package com.fqxyi.iconchange;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class AppManager {

    public static Stack<Activity> activityStack;
    private volatile static AppManager instance;

    /***
     * 这个 是用于记录页面路径的 进出站管理，仅保留10条页面路径记录
     */
    private List<String> activityPathStack;

    private AppManager() {
    }

    /**
     * 单一实例
     */
    public static AppManager getInstance() {
        if (instance == null) {
            synchronized (AppManager.class) {
                if (instance == null) {
                    instance = new AppManager();
                }
            }
        }
        return instance;
    }

    /**
     * 添加Activity到堆
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);

        if (activityPathStack == null) {
            activityPathStack = new ArrayList<>();
        }
        if (activityPathStack.size() > 10) {
            activityPathStack.remove(0);
        }
        activityPathStack.add(String.valueOf("add: " + activity.toString()));
    }

    public void remove(Activity activity) {
        if (activityStack == null) {
            return;
        }
        if (activityStack.size() == 0) {
            return;
        }

        if (null != activityStack && activityStack.contains(activity)) {
            activityStack.remove(activity);
        }

        if (activityPathStack == null) {
            activityPathStack = new ArrayList<>();
        }
        if (activityPathStack.size() > 10) {
            activityPathStack.remove(0);
        }
        activityPathStack.add(String.valueOf("remove: " + activity.toString()));
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        if (activityStack == null) {
            return;
        }
        if (activityStack.size() == 0) {
            return;
        }
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }
}