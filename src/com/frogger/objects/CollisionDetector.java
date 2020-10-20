package com.frogger.objects;

import java.awt.geom.Area;

public class CollisionDetector {

    public static boolean CollisionDetector(Frog frog, Lane[] items) {

        for (Lane item : items) {
            for (int i = 0; i < item.getLaneItems().size(); i++) {
                Area intersect = new Area(item.getLaneItems().get(i).getBoundingBox());
                intersect.intersect(new Area(frog.getBoundingBox()));
                if (!intersect.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }
}