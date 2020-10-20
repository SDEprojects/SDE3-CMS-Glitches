package com.glitches.models;


public class Room {
    private String name; //The name of the room, this is set from the Rooms.xml XML <name> tag
    private String description; //The room description, set from the Rooms.xml XML <description> tag
    private String storyText; //The text for the room that will be output to the GUI (from <story_text> in Rooms.xml)
    private int visibleButtons; //Represents buttons on the GUI for a given room (from <visible_buttons> in Rooms.xml)
    private String btn1Text; //Text for first GUI button (<btn1_text> from Rooms.xml)
    private String btn2Text; //Text for second GUI button (<btn2_text> from Rooms.xml)
    private String btn3Text; //Text for third GUI button (<btn3_text> from Rooms.xml)
    private String choice1; //uses the data from <adjacent_north> in Rooms.xml XML
    private String choice2; //uses the data from <adjacent_south> in Rooms.xml XML
    private String choice3; //uses the data from <adjacent_east> in Rooms.xml XML


    public Room (String roomName, String roomDescription, String roomText, int visibleButtons, String btn1Text,
     String btn2Text, String btn3Text, String choice1, String choice2, String choice3) {
        this.name = roomName;
        this.description = roomDescription;
        this.storyText = roomText;
        this.visibleButtons = visibleButtons;
        this.btn1Text = btn1Text;
        this.btn2Text = btn2Text;
        this.btn3Text = btn3Text;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
    }

    //Accessors
    public String getName() {
        return name;
    }

    public String getDescription() { return description; }

    public String getStoryText() { return storyText; }

    public int getVisibleButtons() { return visibleButtons; }

    public String getBtn1Text() { return btn1Text; }

    public String getBtn2Text() { return btn2Text; }

    public String getBtn3Text() { return btn3Text; }

    public String getChoice1() {
        return choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public String getChoice3() {
        return choice3;
    }

}