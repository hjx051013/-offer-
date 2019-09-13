package com.leetcode;
/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。

以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。

图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。

示例:

输入: [2,1,5,6,2,3]
输出: 10

思路：
    维护一个栈，栈先插入初值-1，然后遍历，高度递增不断入栈直到遇见一个比前一个柱子低的高度，
    然后不断从栈中剔除高度，直到栈顶高度值小于当前高度，这个过程中计算并更新最大面积，
    遍历完后如果栈中还有除-1外的值，不断从栈中删除值并且计算更新最大面积
 */

import java.util.*;

public class LargestRectangleArea {
    public static void main(String[] args) {
        Solution80 s = new Solution80();
        int[] heights = {0,9};
        System.out.println(s.largestRectangleArea(heights));
    }
}

class Solution80 {
    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length == 0) return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < heights.length; i++) {
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()]*(i-stack.peek()-1));
            }
            stack.push(i);
        }

        while(stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()]*(heights.length-stack.peek()-1));
        }
        return maxArea;
    }
}