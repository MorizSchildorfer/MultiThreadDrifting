package edu.uiowa.mc.hw1;

public class MyThread extends Thread {

    MyThread(long[] arr, int start, int end) {
        super(()->{
            MergeSort.mergeSort(arr, start, end);
        });
        this.start();
    }

}
