package com.glitches;

import com.glitches.models.Room;
import jdk.jfr.StackTrace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RoomsTest {

    @BeforeEach
    void setUp() {
        System.out.println("Before");
    }

    @Test
    void getRoomTest() {
        Room result = Rooms.getRoom("IntroArcade");
        // assertNotNull(result);
        // assertEquals(result, );
    }

    @Test
    void addRoomTest() {

    }
}
