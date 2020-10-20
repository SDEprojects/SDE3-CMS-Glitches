package com.glitches;

import com.glitches.models.Room;

import java.util.ArrayList;

public class Rooms {

    // PROPERTIES
    private static ArrayList<Room> rooms = new ArrayList<>();

    // CTOR
    private Rooms() {}

    // ACCESSORS
    public static void setRooms(ArrayList<Room> rooms) {
        Rooms.rooms = rooms;
    }

    public static void addRoom(Room room) {
        Rooms.rooms.add(room);
    }

    public static ArrayList<Room> getRooms() {
        return rooms;
    }

    public static Room getRoomByIndex(int index) {
        return rooms.get(index);
    }

    // GETS ONE ROOM FROM ROOMS BY USING ITS NAME
    public static Room getRoom(String name) {
        Room rtnRoom = null;
        for (Room room : rooms) {
            if(room.getName().equals(name)) {
                return room;
            }
        }
        return rtnRoom;
    }
}
