package com.example.happycodingirl.designmodel.imageLoader;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by Happycodingirl on 2016/10/20.
 */
public class MemoryImageCache implements ImageCache {

    int maxMemory= (int) (Runtime.getRuntime().maxMemory()/1024); //单位kb
    LruCache<String,Bitmap> bitmapLruCache=new LruCache<String,Bitmap>(maxMemory){
        @Override
        protected int sizeOf(String key, Bitmap value) {
            return value.getRowBytes()*value.getHeight()/1024;
        }
    };

    @Override
    public void put(String url, Bitmap bitmap) {
        bitmapLruCache.put(url,bitmap);
    }

    @Override
    public Bitmap get(String url) {
        return bitmapLruCache.get(url);
    }
}
