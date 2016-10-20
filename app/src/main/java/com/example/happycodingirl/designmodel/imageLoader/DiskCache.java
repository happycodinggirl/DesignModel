package com.example.happycodingirl.designmodel.imageLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Happycodingirl on 2016/10/20.
 */
public class DiskCache implements ImageCache {
    private String CACHE_DIR="/sdcard/lilycache";
    @Override
    public void put(String url, Bitmap bitmap) {
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=new FileOutputStream(CACHE_DIR+url);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            Utils.close(fileOutputStream);
        }
    }

    @Override
    public Bitmap get(String url) {
        return BitmapFactory.decodeFile(CACHE_DIR+url);
    }
}
