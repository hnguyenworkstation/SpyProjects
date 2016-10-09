package me.hnguyenuml.spyday.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by quang on 10/8/2016.
 */

public class SpydayActivity extends AppCompatActivity {
    protected static final String TAG = "SpyDay";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.addActivity(this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        ActivityManager.removeActivity(this);
    }
}
