package com.fqxyi.iconchange;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;

public class Util {

    /**
     * 判断activity是否可用
     */
    public static boolean activityEnabled(Context context, String activityPath) {
        if (context == null) {
            return false;
        }
        PackageManager pm = context.getPackageManager();
        ComponentName cn = new ComponentName(context, context.getPackageName() + activityPath);
        ActivityInfo info = null;
        try {
            info = pm.getActivityInfo(cn, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return (info != null && info.enabled);
    }

    public static void enableMain(Context context, boolean force) {
        if (context == null || activityEnabled(context, ".MainActivity")) {
            return;
        }
        int enableFlag = force ? 0 : PackageManager.DONT_KILL_APP;

        PackageManager packageManager = context.getPackageManager();
        packageManager.setComponentEnabledSetting(
                new ComponentName(context, context.getPackageName() + ".AliasActivity"),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        packageManager.setComponentEnabledSetting(
                new ComponentName(context, context.getPackageName() + ".MainActivity"),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, enableFlag);
    }

    public static void enableAlias(Context context, boolean force) {
        if (context == null || activityEnabled(context, ".AliasActivity")) {
            return;
        }
        int enableFlag = force ? 0 : PackageManager.DONT_KILL_APP;

        PackageManager packageManager = context.getPackageManager();
        packageManager.setComponentEnabledSetting(
                new ComponentName(context, context.getPackageName() + ".MainActivity"),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        packageManager.setComponentEnabledSetting(
                new ComponentName(context, context.getPackageName() + ".AliasActivity"),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, enableFlag);
    }

    public static void openMain(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        ComponentName cn = new ComponentName(
                context, context.getPackageName() + ".MainActivity");
        intent.setComponent(cn);
        context.startActivity(intent);
    }

    public static void openAlias(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        ComponentName cn = new ComponentName(
                context, context.getPackageName() + ".AliasActivity");
        intent.setComponent(cn);
        context.startActivity(intent);
    }

}
