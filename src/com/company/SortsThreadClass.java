package com.company;

import java.awt.*;

public class SortsThreadClass implements Runnable  {

    int runId = 0;
    //int [] array;
    //GraphicsPanel screen;
    private Thread thread;
    SortsClass sortsClass;
    SortsThreadClass(){

    }

    SortsThreadClass(SortsClass sorts, int input){
        runId = input;
        sortsClass = sorts;
    }

    public synchronized void start(){
        thread = new Thread(this, "SORTS");
        thread.start();
    }

    public synchronized void stop(){
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        if( runId == 1){
            BubbleSort();
            System.out.println("Sorting");
        }
    }

    public void BubbleSort(){

        //int temp = 0;
        int n = sortsClass.array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                sortsClass.setFirstAndSecond(j, j+1);
                if (sortsClass.array[j] > sortsClass.array[j + 1]) {
                    // swap temp and arr[i]
                    repaint();
                    delayTime(5);
                    int temp = sortsClass.array[j];
                    sortsClass.array[j] = sortsClass.array[j + 1];
                    sortsClass.array[j + 1] = temp;
                }
            }

            repaint();
            delayTime(30);
        }
        sortsClass.setObjectColor(new Color (43, 189, 92));
        repaint();
        delayTime(500);
        sortsClass.setObjectColor(new Color(62, 122, 207));
        stop();
        //traverseArray();
        //screen.repaint();
    }

    public void InsertionSort(){

        //int temp = 0;
        int n = sortsClass.array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                sortsClass.setFirstAndSecond(j, j+1);
                if (sortsClass.array[j] > sortsClass.array[j + 1]) {
                    // swap temp and arr[i]
                    repaint();
                    delayTime(5);
                    int temp = sortsClass.array[j];
                    sortsClass.array[j] = sortsClass.array[j + 1];
                    sortsClass.array[j + 1] = temp;
                }
            }

            repaint();
            delayTime(30);
        }
        sortsClass.setObjectColor(new Color (43, 189, 92));
        repaint();
        delayTime(500);
        sortsClass.setObjectColor(new Color(62, 122, 207));
        stop();
        //traverseArray();
        //screen.repaint();
    }

    private void repaint(){
        sortsClass.screen.repaint();
    }

    private void delayTime( int i){
        sortsClass.screen.delayTime(i);
    }



}
