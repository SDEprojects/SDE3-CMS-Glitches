package com.glitches.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getName() {
        Player player = new Player();
        player.setName("Jay");
        assertNotNull(player.getName(), "Jay");
    }

    @Test
    void setName() {
    }

    @Test
    void getInventory() {
    }

    @Test
    void addToInventory() {
    }
}