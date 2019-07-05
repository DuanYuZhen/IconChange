package com.fqxyi.iconchange;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppManager.getInstance().addActivity(this);
    }

    /**
     * 设置MainActivity为启动入口
     */
    public void setMain(View view) {
        IconChangeManager.enableMain(this, false);
    }

    /**
     * 设置AliasActivity为启动入口
     */
    public void setAlias(View view) {
        IconChangeManager.enableAlias(this, false);
    }

    /**
     * 退出应用时更换icon
     */
    public void setFinish(View view) {
        AppManager.getInstance().finishAllActivity();
        if (IconChangeManager.activityEnabled(this, ".MainActivity")) {
            IconChangeManager.enableAlias(this, true);
        } else {
            IconChangeManager.enableMain(this, true);
        }
    }

    public void openSecond(View view) {
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent);
    }

}
