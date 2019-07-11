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
     * 设置 activityDefault 为启动入口
     */
    public void setActivityDefault(View view) {
        IconChangeManager.enableComponent(this, false, 0);
    }

    /**
     * 设置 activity618 为启动入口
     */
    public void setActivity618(View view) {
        IconChangeManager.enableComponent(this, false, 1);
    }

    /**
     * 设置 activity1225 为启动入口
     */
    public void setActivity1225(View view) {
        IconChangeManager.enableComponent(this, false, 2);
    }

    /**
     * 退出应用时更换icon
     */
    public void setFinish(View view) {
        AppManager.getInstance().finishAllActivity();
        IconChangeManager.changeIcon(this, 2);
    }

    public void openSecond(View view) {
        Intent intent = new Intent(this, OtherActivity.class);
        startActivity(intent);
    }

}
