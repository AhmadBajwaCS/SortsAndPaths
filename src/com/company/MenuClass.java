package com.company;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.text.AttributedString;

public class MenuClass extends ScreenClass{

    //GraphicsPanel screen;
    Color test = getColor("1");

    public MenuClass(){

    }

    public MenuClass(GraphicsPanel graphicsPanel) {

        //super.screen = graphicsPanel;
        screen = graphicsPanel;

    }

    public void drawElements(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;


        g2D.setColor(getColor("1")/*new Color(255, 133, 173)*/);
        g2D.drawRoundRect(400, 200, 1100, 800, 50, 50);
        drawTitle(g);
        drawButtons(g);

    }

    public void drawTitle(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        int xPos = 500; int yPos = 150;
        int w = 900; int h = 100;
        int arc = 50;

        g2D.setColor(new Color(130, 90, 255));
        g2D.fillRoundRect(xPos, yPos, w, h, arc , arc);
        g2D.setColor(new Color(141, 86, 162));
        g2D.drawRoundRect(xPos, yPos, w, h, arc , arc );


        //g2D.setColor(new Color(234, 246, 255));
        //g2D.setColor(new Color(202, 185, 255));

        int textX = 585;
        int textY = 220;
        g2D.setFont(new Font("Georgia", Font.BOLD, 76));
        g2D.setColor(new Color(0, 0, 0));
        g2D.drawString("SORTS AND PATHS", textX,textY);
        g2D.drawString("SORTS AND PATHS", textX-5,textY);
        g2D.setFont(new Font("Georgia", Font.BOLD, 75));
        g2D.setColor(new Color(255, 255, 255));
        g2D.drawString("SORTS AND PATHS", textX,textY);


        g2D.setColor(new Color(67, 55, 151));
        g2D.fillRect(100, 0, 100, 1200);
        g2D.fillRect(1700, 0, 100, 1200);

    }

    private void drawButtons(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        int xPos = 650; int yPos = 400;
        int w = 600; int h = 100;
        int arc = 50;

        g2D.setColor(new Color(130, 90, 255));      // Sorts Button
        g2D.fillRoundRect(xPos, yPos, w, h, arc , arc);
        g2D.setColor(new Color(141, 86, 162));
        g2D.drawRoundRect(xPos, yPos, w, h, arc , arc );
        g2D.setColor(new Color(234, 246, 255));

        g2D.setColor(new Color(130, 90, 255));      // Algo Button
        g2D.fillRoundRect(xPos, yPos + 200, w, h , arc , arc);
        g2D.setColor(new Color(141, 86, 162));
        g2D.drawRoundRect(xPos, yPos + 200, w, h, arc , arc );
        g2D.setColor(new Color(234, 246, 255));
    }

    public void checkButtons(MouseEvent e) {
     System.out.println("Test click");

     int mouseX = e.getX();
     int mouseY = e.getY();

     if( (mouseX > 650 && mouseX < 1250) && (mouseY > 400 && mouseY < 500)){
         screen.setScreenId(1);
         //screen.repaint();
     } else if ((mouseX > 650 && mouseX < 1250) && (mouseY > 600 && mouseY < 700)){
         screen.setScreenId(2);
     }


    }


}
