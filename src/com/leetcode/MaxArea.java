package com.leetcode;

import org.omg.CORBA.MARSHAL;

/*
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。



图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。



示例:

输入: [1,8,6,2,5,4,8,3,7]
输出: 49
思路：双指针，将高度值比较小的指针网后或者往前移，这样能覆盖所有可能的矩形容器，并选出最大值
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        Solution31 s = new Solution31();
        System.out.println(s.maxArea(nums));
    }
}

class Solution31 {
    public int maxArea(int[] height) {
        if(height.length<2) return 0;
        int i = 0, j = height.length-1, res = 0;
        while(i<j) {
            int curArea = (j-i)* Math.min(height[i],height[j]);
            if(curArea>res) res = curArea;
            if(height[i] < height[j]) i++;
            else j--;
        }
        return res;
    }

}
