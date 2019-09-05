package com.offer.Array;

/*
面试题14：调整数组顺序使奇数位于偶数前面
题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

思路：
    设置两个指针p1,p2。p1从前往后遇到偶数停下, p2从后往前遇到奇数停下，交换位置，直到i >= j
 */
public class ArrayAdapt {
    public static void main(String[] args) {
        int[] arr = {5,4,6,8,9,10,11};
        Solution14 s = new Solution14();
        s.adapt(arr);
        for(int i:arr) {
            System.out.print(i+" ");
        }
    }
}

class Solution14 {
    public void adapt(int[] arr) {
        int i = 0, j = arr.length-1;
        while(i<j) {
            while(i < arr.length && arr[i]%2 != 0) i++;
            while(j >= 0 && arr[j]%2 != 1) j--;
            if(i < j) swap(arr,i,j);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}