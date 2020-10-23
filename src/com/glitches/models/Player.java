package com.glitches.models;

import java.util.ArrayList;

public class Player {
    String name;
    ArrayList<String> inventory = new ArrayList<>();
    public static int tickets;

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

    public static int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }
}
