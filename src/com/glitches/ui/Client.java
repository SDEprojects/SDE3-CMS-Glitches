package com.glitches.ui;
import com.glitches.xml.*;

import java.awt.*;

public class Client {
    public static void main(String[] args) {
            ReadXMLFiles.initRooms();
            GlitchesGUI glitchesGUI = new GlitchesGUI();
            // set the frame in the center of the screen!
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            glitchesGUI.setLocation((int)(screenSize.getWidth()/2 - glitchesGUI.getSize().getWidth()/2),
                (int)(screenSize.getHeight()/2 - glitchesGUI.getSize().getHeight()/2));
    }
}
