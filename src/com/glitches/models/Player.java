package com.glitches.models;

import java.util.ArrayList;

public class Player {
    //set to private
    public static String name;
    public ArrayList<String> inventory = new ArrayList<>();
    public static int tickets = 0;

    // CTOR
    public Player() {}

    // ACCESSORS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        Player.name = name;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<String> inventory) {
        this.inventory = inventory;
    }

    public void addToInventory(String key) { this.inventory.add(key); }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
       Player.tickets += tickets;
    }
}
