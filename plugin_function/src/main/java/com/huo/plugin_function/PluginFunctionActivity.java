package com.huo.plugin_function;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class PluginFunctionActivity extends AppCompatActivity {


    private Activity proxy;

    public Activity getProxy() {
        return proxy;
    }

    public void setProxy(Activity proxy) {
        this.proxy = proxy;
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(proxy != null)
            proxy.setContentView(R.layout.activity_plugin_function);
        Log.v("pluginActivity","onCreate");
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onResume() {
        Log.v("pluginActivity","onResume");
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onPause() {
        Log.v("pluginActivity","onPause");
    }
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onStop() {
        Log.v("pluginActivity","onStop");
    }
}