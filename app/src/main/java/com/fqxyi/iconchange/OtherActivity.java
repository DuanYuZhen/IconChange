package com.fqxyi.iconchange;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        AppManager.getInstance().addActivity(this);
    }

    public void openMain(View view) {
        if (IconChangeManager.activityEnabled(this, ".MainActivity")) {
            IconChangeManager.openMain(this);
        } else {
            IconChangeManager.openAlias(this);
        }
    }

}
