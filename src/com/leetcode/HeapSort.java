package com.leetcode;

public class HeapSort {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        for(int i = 0; i < 10; i++) {
            heap.add(i);
        }

        while(!heap.isEmpty()) {
            System.out.println(heap.delMax());
        }
    }

}

class MaxHeap {
    private int[] array;
    private int size;
    public MaxHeap(int cap) {
        array = new int[cap];
        size = 0;
    }
    public MaxHeap(int[] arr) {
        array = arr;
        for(int k = (arr.length-2)/2; k>=0;k--) {
            down(arr,k);
        }
    }

    public boolean isEmpty() {
        return size==0;
    }
    public void add(int x) {
        array[size++] = x;
        up(array,size-1);
    }

    public int delMax() {
        int ret = array[0];
        swap(array,size-1,0);
        down(array,0);
        size--;
        return ret;
    }

    public int[] getArray() {
        return array;
    }

    private void down(int[] arr, int k) {
        while(k*2+1 < arr.length) {
            int maxIndex = k*2+1;
            if(k*2+2 < arr.length && arr[k*2+2] > arr[k*2+1]) {
                maxIndex = k*2+2;
            }
            if(arr[k] >= arr[maxIndex]) break;
            else {
                swap(arr,k,maxIndex);
                k = maxIndex;
            }
        }
    }

    private void up(int[] arr, int k) {
        while(k>0) {
            if(arr[(k-1)/2] < arr[k]) {
                swap(arr,(k-1)/2,k);
                k = (k-1)/2;
            } else {
                break;
            }
        }
    }

    private void swap(int[] arr, int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}