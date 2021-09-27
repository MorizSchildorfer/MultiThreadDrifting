package edu.uiowa.mc.hw1;

import java.util.ArrayList;

public class MergeSort {

    private static final int MAX_THREADS = 4;

    public static void multiThreadSort (long[] arr) {
        final int length = arr.length;
        boolean exact = length%MAX_THREADS == 0;
        int divider;

        if (exact) {
            divider = length/MAX_THREADS;
        }
        else {
            divider = length/(MAX_THREADS-1);
        }

        final ArrayList<MyThread> threadList = new ArrayList<>();

        for (int i=0; i < length; i+=divider) {
            int start = i;
            int remain = length - i;
            int end;

            if (remain < divider) {
                end = i + (remain-1);
            }
            else {
                end = i + (divider-1);
            }
            final MyThread t = new MyThread(arr, start, end);
            //System.out.println("new thread created");
            threadList.add(t);
        }

        for (Thread t: threadList) { //wait until all chunks are sorted first
            try {
                t.join();
            }
            catch(InterruptedException ignored){}
        }

        for (int i=0; i < length; i+=divider){
            int mid = i == 0? 0 : i-1;
            int remain = (length)-i;
            int end;

            if (remain < divider) {
                end = i + (remain-1);
            }
            else {
                end = i + (divider-1);
            }
            merge(arr, 0, mid, end);
        }

    }

    public static void mergeSort(long[] arr, int start, int end) {
        if (start<end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(long[] arr, int  start, int mid, int end) {
        long[] temp = new long[(end-start)+1];

        int i = start;
        int j = mid+1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i+=1;
            }
            else {
                temp[k] = arr[j];
                j+=1;
            }
            k+=1;
        }
        while (i <= mid) {
            temp[k] = arr[i];
            i+=1;
            k+=1;
        }
        while (j <= end) {
            temp[k] = arr[j];
            j+=1;
            k+=1;
        }
        for (i = start, k = 0; i <= end; i++, k++) {
            arr[i] = temp[k];
        }
    }
}
