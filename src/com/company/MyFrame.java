package com.company;

import javax.swing.*;

public class MyFrame extends JFrame {

    GraphicsPanel graphicsPanel = new GraphicsPanel();

    public MyFrame(){
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(graphicsPanel);
        this.setVisible(true);
        this.setResizable(false);
    }


}
