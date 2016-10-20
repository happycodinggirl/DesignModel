package com.example.happycodingirl.designmodel;

/**
 * Created by Happycodingirl on 2016/10/19.
 */
public class ConstrateRoomBuilder implements RoomBuider{
    Room room=new Room();
    @Override
    public Room makeWindow() {
        return room.setWindow("window");
    }

    @Override
    public Room makeDoor() {
        return room.setDoor("door");
    }
}
