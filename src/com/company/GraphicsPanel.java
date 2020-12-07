package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;


public class GraphicsPanel extends JPanel implements MouseListener {

    int screenId = 0; int tempScreenId = 0;
    SortsClass sorts;
    MenuClass menu;
    AlgoClass algo;
    boolean transitionBool;
    int opacity;
    int change = 10;
    boolean fadeOut = false; boolean fadeIn = false;
    boolean initialRun = true;
    boolean drawElements = true;
    int [] currArr;

    GraphicsPanel(){
        menu = new MenuClass(this);
        sorts = new SortsClass(this);
        algo = new AlgoClass(this);
        addMouseListener(this);
        opacity = 255;
    }

    GraphicsPanel(int screenId){
        this.screenId = screenId;

        if( screenId == 0) {
            menu = new MenuClass(this);
        }
        else if (screenId == 1){
            sorts = new SortsClass(this);
        }
        else if ( screenId == 2){
            algo = new AlgoClass(this);
        }

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        this.setBackground(new Color(49, 49, 91));

        if (screenId == 0) {
            menu.drawElements(g);
        } else if (screenId == 1) {
            sorts.drawElements(g);
            sorts.drawArray(g);
            //drawSortBars(g);
        }   else if (screenId == 2) {
            algo.drawElements(g);
        }

        if (initialRun) {
            Fadein(g, 10);
            repaint();
        }

        if(transitionBool){
            if(fadeOut) {
                FadeOut(g, 10);
                }

            if(fadeIn)
                Fadein(g, 10);
            repaint();

        }

    }

    public void Fadein(Graphics g, int delayAmount){

        Graphics g2D = (Graphics2D) g;
        g2D.setColor(new Color(0, 0 , 0, opacity));
        g2D.fillRect(0,0, 2000, 2000);
        delayTime(delayAmount);

        opacity -= change;


        if(opacity < 0) {
            transitionBool = false;
            if(initialRun) {initialRun = false;}
            opacity = 0;
            fadeIn = false;
        }
    }

    public void FadeOut(Graphics g, int delayAmount){

        Graphics g2D = (Graphics2D) g;
        g2D.setColor(new Color(0, 0 , 0, opacity));
        g2D.fillRect(0,0, 2000, 2000);
        delayTime(delayAmount);

        opacity += change;

        if (opacity > 255){
            fadeOut = false;
            fadeIn = true;
            opacity = 255;
            //drawElements = true;
            screenId = tempScreenId;
        }
    }

    public void delayTime(int delayAmount){
        long startTime = System.currentTimeMillis(); long elapsedTime = 0L;

        while (elapsedTime < delayAmount) {
            //perform db poll/check
            elapsedTime = (new Date()).getTime() - startTime;
        }

    }

    public void setScreenId(int inputScreenID){
        tempScreenId = inputScreenID;
        transitionBool = true; fadeOut = true;// drawElements = false;
        repaint();
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if(screenId == 0){
            menu.checkButtons(e);
        }
        else if(screenId == 1){
            sorts.checkButtons(e);
        }
        else if(screenId == 2){
            algo.checkButtons(e);
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
