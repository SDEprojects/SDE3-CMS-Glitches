package com.frogger.objects;

import java.util.ArrayList;

public class Lane {

    public static final int LEFT = 0, RIGHT = 1;
    int y, direction;
    double speed;
    public ArrayList<LaneItem> laneItems = new ArrayList<LaneItem>();


    public Lane(double speed, int direction, int y) {
        this.speed = speed;
        this.direction = direction;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public double getSpeed() {
        return speed;
    }

    public ArrayList<LaneItem> getLaneItems() {
        return laneItems;
    }

    public void update() {
        for (LaneItem laneItem : laneItems) {
            laneItem.update();
        }
    }
}