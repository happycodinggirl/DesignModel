package com.example.happycodingirl.designmodel.imageLoader;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Happycodingirl on 2016/10/20.
 */
public class Utils {

    public static void close(Closeable closeable){
        try {
            closeable.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
