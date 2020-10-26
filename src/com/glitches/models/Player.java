package com.glitches.models;

import java.util.ArrayList;

public class Player {
    //set to private
    String name;
    ArrayList<String> inventory = new ArrayList<>();
    int tickets = 0;

    // CTOR
    public Player() {}

    // ACCESSORS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        this.tickets += tickets;
    }
}
