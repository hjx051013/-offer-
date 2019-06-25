package com.leetcode;
/*
41. 缺失的第一个正数
给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

示例 1:

输入: [1,2,0]
输出: 3
示例 2:

输入: [3,4,-1,1]
输出: 2
示例 3:

输入: [7,8,9,11,12]
输出: 1
说明:

你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。

方法：
返回值只可能在1~nums.length之间，将每个不在合适位置（值!=下标+1）的元素与目标位置不合适元素互换，直到换到当前位置元素合适为止或者目标位置元素已经合适，继续下一个元素
遍历完之后，选出第一个不合适元素，返回其位置+1
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution61 s = new Solution61();
        int[] nums = {1};
        System.out.println(s.firstMissingPositive(nums));
    }
}

class Solution61 {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            while(nums[i]>=1&&nums[i]<=nums.length&&nums[i]!=i+1&&nums[nums[i]-1]!=nums[i]) {//当前元素不在应处位置，当前元素可以移到合适位置，并且目标位置元素不在应处位置
                swapNum(i, nums[i]-1, nums);
            }
        }
        int i;
        for(i = 0; i < nums.length; i++) {
            if(nums[i]!=i+1) return i+1;
        }
        if(i>=nums.length) return nums.length+1;
        return 0;
    }
    private void swapNum(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}