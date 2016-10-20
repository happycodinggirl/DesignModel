package com.example.happycodingirl.designmodel.imageLoader;

import android.graphics.Bitmap;

/**
 * Created by Happycodingirl on 2016/10/20.
 */
public interface ImageCache {

    void put(String url,Bitmap bitmap);
    Bitmap get(String url);

}
