package com.huo.androidbasicstudy.activity.plugin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.huo.androidbasicstudy.activity.plugin.util.PluginAPKProvider;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;

import dalvik.system.DexClassLoader;

/**
 * 插件化宿主
 */
public class ProxyActivity extends Activity {
    public static final String PLUGIN_DEX_PATH = "plugin.dex.path";
    public static final String PLUGIN_ACTIIVTY_CLASS_NAME = "plugin.activity.class.name";
    Activity mPluginActivity = null;
    Resources mPluginResourcs = null;
    String mPluginDexPath;
    String mPluginActivityClassName;
    private Class pluginActivityClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent != null) {
            // 从Intent中获得要启动的功能Apk的路径和Activity完整类名
            mPluginDexPath = intent.getStringExtra(PLUGIN_DEX_PATH);
            mPluginActivityClassName = intent.getStringExtra(PLUGIN_ACTIIVTY_CLASS_NAME);

//            if (TextUtils.isEmpty(mPluginDexPath) || TextUtils.isEmpty(mPluginActivityClassName)) {
//                return;
//            }
            File dexOutputDir = PluginAPKProvider.getFile(this);
            mPluginDexPath = dexOutputDir.getPath();
            mPluginActivityClassName = PluginAPKProvider.mPluginActivityClassName;

            loadApkResources(); // 加载资源


            // 根据apk路径加载apk代码到DexClassLoader中
//            File dexOutputDir = this.getDir("dex", 0);
            DexClassLoader dexClassLoader = new DexClassLoader(mPluginDexPath,
                    dexOutputDir.getAbsolutePath(), null, ClassLoader.getSystemClassLoader());

            // 从DexClassLoader中获得功能Activity Class对象并通过反射创建一个功能Activity实例
            pluginActivityClass = null;
            try {
                pluginActivityClass = dexClassLoader.loadClass(mPluginActivityClassName);
                mPluginActivity = (Activity) pluginActivityClass.newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

            // 调用功能Activity的setProxyActivity方法，给其设置代理Activity
            try {
                Method setProxyActivityMethod = pluginActivityClass.getDeclaredMethod("setProxy", Activity.class);
                setProxyActivityMethod.invoke(mPluginActivity, this);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        // 调用功能Activity实例的onCreate方法
        try {
            Method onCreateMethod = pluginActivityClass.getDeclaredMethod("onCreate", Bundle.class);
            onCreateMethod.setAccessible(true);
            onCreateMethod.invoke(mPluginActivity, savedInstanceState);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        // 调用功能Activity实例的onCreate方法
        try {
            Method onCreateMethod = Activity.class.getDeclaredMethod("onResume");
            onCreateMethod.setAccessible(true);
            onCreateMethod.invoke(mPluginActivity);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onPause() {
        super.onPause();
        // 调用功能Activity实例的onCreate方法
        try {
            Method onCreateMethod = Activity.class.getDeclaredMethod("onPause");
            onCreateMethod.setAccessible(true);
            onCreateMethod.invoke(mPluginActivity);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 调用功能Activity实例的onCreate方法
        try {
            Method onCreateMethod = Activity.class.getDeclaredMethod("onStop");
            onCreateMethod.setAccessible(true);
            onCreateMethod.invoke(mPluginActivity);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    // 加载插件Apk的资源
    private void loadApkResources() {
        try {
            AssetManager assetManager = AssetManager.class.newInstance(); // 通过反射创建一个AssetManager对象
            Method addAssetPathMethod = AssetManager.class.getDeclaredMethod("addAssetPath", String.class); // 获得AssetManager对象的addAssetPath方法
            addAssetPathMethod.invoke(assetManager, mPluginDexPath); // 调用AssetManager的addAssetPath方法，将apk的资源添加到AssetManager中管理
            mPluginResourcs = new Resources(assetManager, super.getResources().getDisplayMetrics(), super.getResources().getConfiguration()); // 根据AssetMananger创建一个Resources对象
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    // 重写ProxyActivity的getResources方法，让其返回插件Apk的资源对象
    @Override
    public Resources getResources() {
        if (mPluginResourcs != null) {
            return mPluginResourcs;
        }
        return super.getResources();
    }

}