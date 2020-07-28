package com.huo.androidbasicstudy.activity.plugin.other;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.huo.androidbasicstudy.R;
import com.huo.androidbasicstudy.activity.plugin.util.PluginAPKProvider;

public class PluginTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources.Theme theme = getTheme();

        setContentView(R.layout.activity_plugin_test);
    }

    public void loadPlugin(View view) {
        try {
            PluginHelper.loadPlugin(this, getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "插件加载失败", Toast.LENGTH_SHORT).show();
        }
    }

    public void launchPluginActivity(View view) {
        Class pluginActivityClass = null;
        try {
            pluginActivityClass = Class.forName(PluginAPKProvider.mPluginActivityClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (pluginActivityClass == null) {
            Toast.makeText(this, "找不到PluginActivity", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, pluginActivityClass);
        startActivity(intent);
    }

}
