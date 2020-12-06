package com.company;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

public class SortsClass extends ScreenClass{

    int barWidth = 10;
    int numBars = 1900/barWidth;
    int [] array = new int[numBars];
    List<Integer> circleRad = new ArrayList<>();;
    int rand = 20; int firstRedInd = 1000; int secondRedInd = 1000;
    SortsThreadClass sortThread = new SortsThreadClass(this, 0);
    Color objectColor = new Color(62, 122, 207);
    SortsClass(){

    }

    SortsClass(GraphicsPanel graphicsPanel){
        screen = graphicsPanel;
        initializeArray();
    }


    public void drawElements(Graphics g) {
        super.drawElements(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);
        //draw(g);
        g2D.drawRect(10, 950, 150, 85 );
    }

    public void initializeArray(){

        for(int i = 0; i<numBars;i++){
            array[i] = i;
        }

        shuffleArray();
        Collections.shuffle(circleRad);

    }

    public void drawArray(Graphics g){

        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(objectColor);

        for(int i = 0; i<numBars;i++){
            if (i == firstRedInd || i == secondRedInd)
                g2D.setColor(Color.RED);
            g2D.fillRect(i*10, 920-array[i]*4, barWidth, array[i]*4);
            g2D.setColor(Color.BLACK);
            g2D.drawRect(i*10, 920-array[i]*4, barWidth, array[i]*4);
            g2D.setColor(objectColor);
        }

        screen.repaint();
    }

    public void checkButtons(MouseEvent e) {
        super.checkButtons(e);

        int mouseX = e.getX();
        int mouseY = e.getY();

        if( (mouseX > 10 && mouseX < 160) && (mouseY > 950 && mouseY < 1035)){
            sortThread = new SortsThreadClass(this, 1);
            sortThread.start();
            //screen.repaint();
        }
    }

    public void shuffleArray(){

        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }

    }

    public void BubbleSort(){

        //int temp = 0;
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    // swap temp and arr[i]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

            screen.repaint();
            screen.delayTime(10);
        }
        //traverseArray();
        //screen.repaint();
    }

    public void traverseArray(){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void setFirstAndSecond( int i, int j){
        firstRedInd = i; secondRedInd = j;
    }

    public void setObjectColor( Color c){
        objectColor = c;
    }

}
