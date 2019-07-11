package com.fqxyi.iconchange;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

/**
 * 多应用ICON切换
 */
public class IconChangeManager {

    private static final String[] ICON_ARR = {
            ".MainActivity",
            ".activity618",
            ".activity1225",
    };

    /**
     * 更换应用icon
     */
    public static void changeIcon(Context context, int iconType) {
        if (context == null) {
            return;
        }
        /**
         * 业务逻辑：根据接口返回数据，决定需要更换为哪个icon
         */
        enable(context, true, iconType);
    }

    /**
     * 判断 component 是否可用
     */
    private static boolean activityEnabled(Context context, String activityPath) {
        if (context == null) {
            return false;
        }
        PackageManager pm = context.getPackageManager();
        ComponentName cn = new ComponentName(context, context.getPackageName() + activityPath);
        return pm.getComponentEnabledSetting(cn) == PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
    }

    /**
     * 启用组件
     * @param force 设置为false，可能会导致应用在一段时间后退出
     * @param iconType 需要和数组索引保持一致
     */
    public static void enable(Context context, boolean force, int iconType) {
        if (context == null || iconType > ICON_ARR.length - 1) {
            return;
        }
        String activityPath = ICON_ARR[iconType];
        if (activityEnabled(context, activityPath)) {
            return;
        }
        int enableFlag = force ? 0 : PackageManager.DONT_KILL_APP;

        try {
            PackageManager packageManager = context.getPackageManager();
            // 先禁用所有组件
            for (String item : ICON_ARR) {
                if (item.equals(activityPath)) {
                    continue;
                }
                packageManager.setComponentEnabledSetting(
                        new ComponentName(context, context.getPackageName() + item),
                        PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
            }
            // 再启用需要启用的组件
            packageManager.setComponentEnabledSetting(
                    new ComponentName(context, context.getPackageName() + activityPath),
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED, enableFlag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 打开应用
     */
    public static void openApp(Context context) {
        if (context == null) {
            return;
        }
        for (String item : ICON_ARR) {
            if (!activityEnabled(context, item)) {
                continue;
            }
            Intent intent = new Intent();
            ComponentName cn = new ComponentName(
                    context, context.getPackageName() + item);
            intent.setComponent(cn);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

}
