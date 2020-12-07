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
        sortsClass.canRun = true;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        if(!isSorted()) {

            if (runId == 1) {
                BubbleSort();
            }
            if (runId == 2) {
                InsertionSort();
            }
            if (runId == 3){
                MergeSort(0, sortsClass.array.length-1);
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

    public void MergeSort(int l,  int r){

        //int temp = 0;
        int n = sortsClass.array.length;

        if(l<r) {
            int m = (l + r) / 2;

            MergeSort(l, m);
            MergeSort(m+1, r);

            mergeHelper(l, m , r);
        }

        if(isSorted())
            finishedSort();

    }

    private void mergeHelper(int l,int m, int r){

        int n1 = m - l + 1;
        int n2 = r - m;

        int[] Left = Arrays.copyOfRange(sortsClass.array, l, sortsClass.array.length);
        int[] Right = Arrays.copyOfRange(sortsClass.array, m+1, sortsClass.array.length);

        int i = 0; int j = 0;

        int k = l;

        while (i < n1 && j < n2) {

            sortsClass.redInd = new ArrayList<>(Arrays.asList(k, k-(k-i), k-(k-j)));
            if (Left[i] <= Right[j]) {
                sortsClass.array[k] = Left[i];
                i++;
            }
            else {
                sortsClass.array[k] = Right[j];
                j++;
            }
            k++;
            repaint();
            delayTime(5);
        }

        while (i < n1) {
            sortsClass.array[k] = Left[i];
            i++;
            k++;
        }

        while (j < n2) {
            sortsClass.array[k] = Right[j];
            j++;
            k++;
        }
        repaint();
        delayTime(5);
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
        sortsClass.redInd = new ArrayList<Integer>();
        stop();
    }



}
