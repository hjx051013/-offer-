package com.leetcode;
/*
给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

示例:

输入:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
输出: 6

思路：
    采用动态规划算法。维护3个长度为matrix[0].length的数组left[], right[], height[]。
   遍历每一行。针对每行下标为j的元素：
   matrix[row][j] == '0', left[j] = -1, right[j] = Integer.MAX_VALUE, height[j] = 0;
   为'1', left[j] = Math.max(left[j], leftZeroIndex+1), right[j] = Math.min(right[j], rightZeroIndex), height[j] = height[j]+1
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        Solution81 s = new Solution81();
        char[][] matrix = {};
        System.out.println(s.maximalRectangle(matrix));
    }
}

class Solution81 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int[] left = new int[matrix[0].length];
        int[] right = new int[matrix[0].length];
        int[] height = new int[matrix[0].length];
        int maxArea = 0;
        for(int k = 0; k < right.length; k++) {
            right[k] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < matrix.length; i++) {
            int j;
            int leftZeroIndex = -1;
            int rightZeroIndex = matrix[0].length;
            for(j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]=='0') {
                    height[j] = 0;
                    left[j] = -1;
                    right[j] = Integer.MAX_VALUE;
                    leftZeroIndex = j;
                } else {
                    height[j] = height[j] + 1;
                    left[j] = Math.max(left[j], leftZeroIndex+1);
                }
            }
            for(j = matrix[0].length-1; j >= 0; j--) {
                if(matrix[i][j]=='0') {
                    rightZeroIndex = j;
                } else {
                    right[j] = Math.min(right[j], rightZeroIndex);
                }
            }
            for(j = 0; j < matrix[0].length; j++) {
                maxArea = Math.max(maxArea, (right[j]-left[j])*height[j]);
            }
        }

        return maxArea;
    }
}