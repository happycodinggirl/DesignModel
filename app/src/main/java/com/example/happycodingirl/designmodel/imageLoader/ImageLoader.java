package com.example.happycodingirl.designmodel.imageLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Happycodingirl on 2016/10/20.
 */
public class ImageLoader {

    ExecutorService executorService= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    ImageCache imageCache;

    public void setImageCache(ImageCache imageCache) {
        this.imageCache = imageCache;
    }

    public void displayImage(final String url, final ImageView imageView){
        if (imageCache.get(url)!=null){
            imageView.setImageBitmap(imageCache.get(url));
        }else{
            getBitmapFromUrl(url, imageView);
        }
    }

    private void getBitmapFromUrl(final String url, final ImageView imageView) {
        imageView.setTag(url);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                    Bitmap dowloadBmp=downLoadBitmap(url);
                if (imageView.getTag().equals(url)){
                    imageView.setImageBitmap(dowloadBmp);
                }

                imageCache.put(url,dowloadBmp);
            }
        });
    }

    private Bitmap downLoadBitmap(String url){
        try {
            URL url1=new URL(url);
            HttpURLConnection urlConnection= (HttpURLConnection) url1.openConnection();
            Bitmap bitmap=BitmapFactory.decodeStream(urlConnection.getInputStream());
            urlConnection.disconnect();
            return bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();

        }
        return null;
    }

}
