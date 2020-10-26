package com.glitches.xml;

import com.glitches.models.Room;
import com.glitches.Rooms;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.Path;

public class ReadXMLFiles {

    public static void initRooms() {
        try {
           // taking XML from the provided txt doc "Rooms.xml" in data
            File inputFile = new File(String.valueOf(Path.of( "Rooms.xml")));
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList roomList = doc.getElementsByTagName("room"); //roomList now contains all the nodes in the file

            for (int i = 0; i < roomList.getLength(); i++) { //iterating over all the nodes in List

                // start out in IntroArcade
                Node room = roomList.item(i);

                //downcast, getting element we want, then recasting to node, then getting the text
                Element roomEle = (Element) room;
                String roomName = roomEle.getElementsByTagName("name").item(0).getTextContent();

                String roomDescription = roomEle.getElementsByTagName("description").item(0).getTextContent();

                //gets story text to display on GUI
                String storyText = roomEle.getElementsByTagName("story_text").item(0).getTextContent();

                //gets number in text format and parses it to an int to dictate number of buttons to display on GUI
                int visibleButtons =
                        Integer.parseInt(roomEle.getElementsByTagName("visible_buttons").item(0).getTextContent());

                //gets text for GUI buttons
                String btn1Text = roomEle.getElementsByTagName("btn1_text").item(0).getTextContent();
                String btn2Text = roomEle.getElementsByTagName("btn2_text").item(0).getTextContent();
                String btn3Text = roomEle.getElementsByTagName("btn3_text").item(0).getTextContent();
                String btn4Text = roomEle.getElementsByTagName("btn4_text").item(0).getTextContent();
                String btn5Text = roomEle.getElementsByTagName("btn5_text").item(0).getTextContent();
                String btn6Text = roomEle.getElementsByTagName("btn6_text").item(0).getTextContent();

                //gets action choices. returns corresponding room
                String choice1 = roomEle.getElementsByTagName("c1").item(0).getTextContent();
                String choice2 = roomEle.getElementsByTagName("c2").item(0).getTextContent();
                String choice3 = roomEle.getElementsByTagName("c3").item(0).getTextContent();
                String choice4 = roomEle.getElementsByTagName("c4").item(0).getTextContent();
                String choice5 = roomEle.getElementsByTagName("c5").item(0).getTextContent();
                String choice6 = roomEle.getElementsByTagName("c6").item(0).getTextContent();

                //adds room to the static, globally-accessible Rooms.rooms collection
                Rooms.addRoom(new Room(roomName, roomDescription, storyText, visibleButtons, btn1Text, btn2Text,
                                         btn3Text, btn4Text, btn5Text, btn6Text, choice1, choice2, choice3, choice4, choice5, choice6));
            }
        }
        catch (Exception e) {
            System.out.println("there was an error initializing the rooms list.");
            System.out.println(e.getMessage());
        }
    }
}
