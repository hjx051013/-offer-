package com.offer.Array;

/*
面试题8：旋转数组的最小数字
题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。

思路：
    二分，如果中间值大于起始值，则选择中间值后的序列（包括）为新序列，如果小于末尾值，则选择中间值之前的序列（包括）为新序列。逐步二分，直到
    左右index相差等于1, 返回array[left]和array[right]中的最小值
 */
public class MinInRotateArray {
    public static void main(String[] args) {
        int[] array = {4,5,5,6,7};
        Solution8 s = new Solution8();
        System.out.println(s.findMinInRotateArray(array));
    }
}

class Solution8 {
    public int findMinInRotateArray(int[] array) {
        if(array.length==1) return array[0];
        if(array[0] < array[array.length-1]) return array[0];//说明是增序
        int left = 0, right = array.length-1;
        while(array[left] >= array[right]) {
            if(right-left==1) break;
            int mid = (left+right)/2;
            if(array[left]==array[right]&&array[left]==array[mid]) {
                int min = array[left];
                for(int k = left+1; k <= right; k++) {
                    if(array[k] < min) min = array[k];
                }
                return min;
            }
            if(array[mid] >= array[left]) left = mid;
            else if(array[mid] <= array[right]) right = mid;
        }

        return Math.min(array[left], array[right]);
    }
}