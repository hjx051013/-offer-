package com.leetcode;

import java.util.Arrays;

/*
16. 最接近的三数之和
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

方法：
    与三数之和方法一致
 */
public class ClosestThreeSum {
    public static void main(String[] args) {
        int[] data = {-1,2,1,-4};
        Solution37 s = new Solution37();
        System.out.println(s.threeSumClosest(data,1));

    }
}

class Solution37 {
    public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int minDiff = Integer.MAX_VALUE;
            int resSum = 0;
            for(int i = 0; i < nums.length-2; i++) {
                if(i>0&&nums[i]==nums[i-1]) continue;
                else {
                    int p1 = i+1,p2 = nums.length-1,tar = target-nums[i];
                    while(p1<p2) {
                        if(Math.abs(nums[p1]+nums[p2]-tar)<minDiff) {
                            minDiff = Math.abs(nums[p1]+nums[p2]-tar);
                            resSum = nums[p1]+nums[p2]+nums[i];
                        }
                        if(nums[p1]+nums[p2]<tar) {
                            while(p1<p2&&nums[p1]==nums[++p1]);
                        }
                        else if(nums[p1]+nums[p2]>tar) {
                            while(p1<p2&&nums[p2]==nums[--p2]);
                        }
                        else {
                            while(p1<p2&&nums[p1]==nums[++p1]);
                            while(p1<p2&&nums[p2]==nums[--p2]);
                        }
                    }
                }

            }
            return resSum;
    }
}
