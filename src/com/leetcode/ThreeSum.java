package com.leetcode;

import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;

/*
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

方法：
    遍历每个元素num[i]，对其后的元素采取两数之和为0-num[i]的方法求解
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(s.threeSum(nums));
    }


}

class Solution1 {
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