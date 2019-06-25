package com.leetcode;

public class MaxSubArray{
    public static void main(String[] args) {
        int[] nums = {-2,-1};
        Solution28 s = new Solution28();
        System.out.println(s.maxSubArray(nums));
    }
}

class Solution28 {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int curMax = nums[0];
        int curVal = nums[0]<0?0:nums[0];
        for(int i = 1; i < nums.length; i++) {
            curVal += nums[i];
            if(curVal>curMax) curMax = curVal;
            if(curVal<0) curVal = 0;
        }
        return curMax;
    }
}
