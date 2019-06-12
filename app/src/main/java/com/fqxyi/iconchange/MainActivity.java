package com.fqxyi.iconchange;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 设置MainActivity为启动入口
     * @param view
     */
    public void setMain(View view) {
        PackageManager packageManager = getPackageManager();
        packageManager.setComponentEnabledSetting(new ComponentName(this, getPackageName() +
                ".NewActivity"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager
                .DONT_KILL_APP);
        packageManager.setComponentEnabledSetting(new ComponentName(this, getPackageName() +
                ".MainActivity"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager
                .DONT_KILL_APP);
    }

    /**
     * 设置NewActivity为启动入口
     * @param view
     */
    public void setNew(View view) {
        PackageManager packageManager = getPackageManager();
        packageManager.setComponentEnabledSetting(new ComponentName(this, getPackageName() +
                        ".NewActivity"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
        packageManager.setComponentEnabledSetting(new ComponentName(this, getPackageName() +
                ".MainActivity"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager
                .DONT_KILL_APP);
    }

    public void setFinish(View view) {
        PackageManager packageManager = getPackageManager();
        packageManager.setComponentEnabledSetting(new ComponentName(this, getPackageName() +
                        ".NewActivity"), PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                0);
        packageManager.setComponentEnabledSetting(new ComponentName(this, getPackageName() +
                ".MainActivity"), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager
                .DONT_KILL_APP);
    }

}
