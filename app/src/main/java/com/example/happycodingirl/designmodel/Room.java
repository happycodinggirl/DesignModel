package com.example.happycodingirl.designmodel;

/**
 * Created by Happycodingirl on 2016/10/19.
 */
public class Room {

    String window;
    String door;

    public Room setWindow(String window) {
        this.window = window;
        return this;
    }

    public Room setDoor(String door) {
        this.door = door;
        return this;
    }
}
