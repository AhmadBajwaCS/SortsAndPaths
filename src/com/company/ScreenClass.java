package com.company;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class ScreenClass {

    Map<String, Color> colorPallete = new HashMap<String, Color>();
    GraphicsPanel screen;

    ScreenClass(){
            createColorPallete();
    }

    void createColorPallete(){
        colorPallete.put("0", new Color(130, 90, 255));
        colorPallete.put("1", new Color(255, 133, 173));
        colorPallete.put("2", new Color(184, 225, 253));
        colorPallete.put("3", new Color(184, 225, 253));
        colorPallete.put("4", new Color(184, 225, 253));
        colorPallete.put("5", new Color(184, 225, 253));
    }

    Color getColor(String colorStr){
         return colorPallete.get(colorStr);
    }

    public void drawElements(Graphics g){
        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(new Color(213, 223, 239));
        g2D.fillRoundRect(10, 10, 200, 85 , 50, 50);

        g2D.setColor(Color.BLACK);
        g2D.drawLine(0, 100, 2000, 100);
        g2D.drawRoundRect(10, 10, 200, 85, 50 , 50 );


        g2D.setFont(new Font("OpenSans", Font.BOLD, 45));
        g2D.drawString("< BACK", 25,70);

    }


    protected void checkButtons(MouseEvent e) {

        int mouseX = e.getX();
        int mouseY = e.getY();

        if( (mouseX > 10 && mouseX < 210) && (mouseY > 10 && mouseY < 90)){
            screen.setScreenId(0);
            System.out.println("TEST");
            //screen.repaint();
        }
    }
}
