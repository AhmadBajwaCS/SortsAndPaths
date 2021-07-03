package com.company;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.List;

public class SortsClass extends ScreenClass{

    int barWidth = 10;
    int numBars = 1900/barWidth;
    int [] array = new int[numBars];
    List<Integer> circleRad = new ArrayList<>();
    int rand = 20; int firstRedInd = 1000; int secondRedInd = 1000;
    SortsThreadClass sortThread = new SortsThreadClass(this, 0);
    Color objectColor = new Color(62, 122, 207);
    boolean canRun = true;
    ArrayList<Integer> redInd = new ArrayList<>();

    SortsClass(){

    }

    SortsClass(GraphicsPanel graphicsPanel){
        screen = graphicsPanel;
        initializeArray();
    }


    public void drawElements(Graphics g) {
        super.drawElements(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(Color.WHITE);
        g2D.fillRoundRect(250, 950, 200, 85 , 50, 50);   //Bubble Sort
        g2D.fillRoundRect(500, 950, 200, 85,50, 50 );   //Insertion Sort
        g2D.fillRoundRect(750, 950, 200, 85 , 50, 50);  //Merge Sort
        g2D.fillRoundRect(1000, 950, 200, 85 , 50, 50); // Quick Sort
        g2D.fillRoundRect(900, 10, 200, 85 , 50, 50);   //Shuffle

        g2D.setColor(Color.BLACK);
        g2D.drawRoundRect(250, 950, 200, 85 , 50, 50);
        g2D.drawRoundRect(500, 950, 200, 85 , 50, 50);
        g2D.drawRoundRect(750, 950, 200, 85 , 50, 50);
        g2D.drawRoundRect(1000, 950, 200, 85 , 50, 50);
        g2D.drawRoundRect(900, 10, 200, 85 , 50, 50);

        g2D.setFont(new Font("OpenSans", Font.BOLD, 45));
        g2D.drawString("Shuffle", 925,65);

        g2D.setFont(new Font("OpenSans", Font.PLAIN, 35));
        g2D.drawString("Bubble Sort", 260,1005);

        g2D.drawString("Insertion", 530,990);
        g2D.drawString("Sort", 570,1025);

        g2D.drawString("Merge Sort", 770,1005);

        g2D.drawString("Quick Sort", 1020,1005);

    }

    public void initializeArray(){

        for(int i = 0; i<numBars;i++){
            array[i] = i;
        }

        shuffleArray();

    }

    public boolean checkStop(){
        if(stopButton) {
            stopButton = false;
            return true;
        }
        return false;
    }

    public void drawArray(Graphics g){

        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(objectColor);

        for(int i = 0; i<numBars;i++){
            if (redInd.contains(i))
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


        if(canRun) {

            if ((mouseX > 250 && mouseX < 450) && (mouseY > 950 && mouseY < 1035)) {    // bubble sort
                beginSort(1);
            }

            if ((mouseX > 500 && mouseX < 700) && (mouseY > 950 && mouseY < 1035)) {    // Insertion sort
                beginSort(2);
            }

            if ((mouseX > 750 && mouseX < 950) && (mouseY > 950 && mouseY < 1035)) {    // Merge sort
                beginSort(3);
            }

            if ((mouseX > 1000 && mouseX < 1250) && (mouseY > 950 && mouseY < 1035)) {    // Quick sort
                beginSort(4);
            }

            if((mouseX > 900 && mouseX < 1100) && (mouseY > 5 && mouseY < 90)){     //Shuffle
                shuffleArray();
            }

        }


    }

    private void beginSort(int sortNum){
        canRun = false;
        sortThread = new SortsThreadClass(this, sortNum);
        sortThread.start();
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


    public void traverseArray(){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void setRedInd(int i){
        redInd.add(i);
    }

    public void setObjectColor(Color c){
        objectColor = c;
    }

}
