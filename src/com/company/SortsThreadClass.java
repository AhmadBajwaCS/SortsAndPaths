package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SortsThreadClass implements Runnable  {

    int runId;
    private Thread thread;
    SortsClass sortsClass;

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
        if(!isSorted()) {
            System.out.println("WE ARE HERE");
            if (runId == 1) {
                BubbleSort();
            }
            if (runId == 2) {
                InsertionSort();
            }

        }
        stop();
    }

    public boolean isSorted() {
        for (int i = 0; i < sortsClass.array.length - 1; i++) {
            if (sortsClass.array[i] > sortsClass.array[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public void BubbleSort(){

        //int temp = 0;
        int n = sortsClass.array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                sortsClass.redInd = new ArrayList<>(Arrays.asList(j , j+1));
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
        finishedSort();

    }

    public void InsertionSort(){

        //int temp = 0;
        int n = sortsClass.array.length;

        for (int i = 0; i < n; i++) {
            int temp = sortsClass.array[i];
            int j = i -1;
            while (j>= 0 && sortsClass.array[j] > temp) {
                sortsClass.redInd = new ArrayList<>(Arrays.asList(j, j + 1, i));
                sortsClass.array[j+1] = sortsClass.array[j];
                j = j - 1 ;
                repaint();
                delayTime(5);
            }

            sortsClass.array[j+1] = temp;

            repaint();
            delayTime(30);
        }

        finishedSort();

    }

    private void repaint(){
        sortsClass.screen.repaint();
    }

    private void delayTime( int i){
        sortsClass.screen.delayTime(i);
    }

    private void finishedSort(){
        sortsClass.setObjectColor(new Color (43, 189, 92));
        repaint();
        delayTime(500);
        sortsClass.setObjectColor(new Color(62, 122, 207));
        sortsClass.canRun = true;
        sortsClass.redInd = new ArrayList<Integer>();
        stop();
    }



}
