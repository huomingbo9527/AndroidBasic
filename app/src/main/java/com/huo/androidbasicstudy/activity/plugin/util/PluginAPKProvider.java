package com.huo.androidbasicstudy.activity.plugin.util;

import android.app.Activity;
import android.content.res.AssetManager;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PluginAPKProvider {

    public static String stubActivityName = "com.huo.androidbasicstudy.activity.plugin.other.PluginStubActivity";
    public static String mPluginActivityClassName = "com.huo.plugin_function.PluginRealTestActivity";

    @NotNull
    public static File getFile(Activity activity) {
        AssetManager assets = activity.getAssets();
        String[] list = new String[0];
        try {
            list = assets.list("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String apkName = null;
        for(String name : list){
            if (name.endsWith(".apk")){
                apkName = name;
            }
        }
        File dexOutputDir = new File(activity.getExternalCacheDir(), "plugin.apk");
        try {
            writeBytesToFile(assets.open(apkName),dexOutputDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dexOutputDir;
    }

    public static void writeBytesToFile(InputStream is, File file) throws IOException{
        FileOutputStream fos = null;
        try {
            byte[] data = new byte[2048];
            int nbread = 0;
            fos = new FileOutputStream(file);
            while((nbread=is.read(data))>-1){
                fos.write(data,0,nbread);
            }
        }
        catch (Exception ex) {
            Log.v("Exception",ex.getMessage());
        }
        finally{
            if (fos!=null){
                fos.close();
            }
        }
    }

}
