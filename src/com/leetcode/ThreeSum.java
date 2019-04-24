package com.leetcode;

import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(s.threeSum(nums));
    }


}

class Solution1 {
    private List<List<Integer>> twoSum(int target, int[] nums, int start, int end) {

        List<List<Integer>> result = new ArrayList<>();

        return result;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++) {
            if(i>0&&nums[i]==nums[i-1]) continue;
            else {
                int p1 = i+1,p2 = nums.length-1,target = -nums[i];
                while(p1<p2) {
                    if(nums[p1]+nums[p2]<target) {
                        while(p1<p2&&nums[p1]==nums[++p1]);
                    }
                    else if(nums[p1]+nums[p2]>target) {
                        while(p1<p2&&nums[p2]==nums[--p2]);
                    }
                    else {
                        result.add(Arrays.asList(nums[i],nums[p1],nums[p2]));
                        while(p1<p2&&nums[p1]==nums[++p1]);
                        while(p1<p2&&nums[p2]==nums[--p2]);
                    }
                }
            }

        }
        return result;
    }
}