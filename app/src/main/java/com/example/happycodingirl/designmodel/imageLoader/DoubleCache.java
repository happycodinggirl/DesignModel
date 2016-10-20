package com.example.happycodingirl.designmodel.imageLoader;

import android.graphics.Bitmap;

/**
 * Created by Happycodingirl on 2016/10/20.
 */
public class DoubleCache implements ImageCache {
    MemoryImageCache memoryImageCache=new MemoryImageCache();
    DiskCache diskCache=new DiskCache();
    @Override
    public void put(String url, Bitmap bitmap) {

    }

    @Override
    public Bitmap get(String url) {
        Bitmap bitmap=memoryImageCache.get(url);
        if (bitmap==null){
            bitmap=diskCache.get(url);
        }
        return bitmap;
    }
}
