package com.leetcode;

public class SearchRange {
    public static void main(String[] args) {
        Solution67 s = new Solution67();
        int[] nums = {5,7,7,8,8,10};
        int[] res = s.searchRange(nums, 6);
        System.out.println("["+res[0]+","+res[1]+"]");
    }
}

class Solution67 {
    public int[] searchRange(int[] nums, int target) {
        int index = halfFind(nums, target);
        int[] res = {-1,-1};
        if (index == -1) return res;
        else {
            int k = index;
            while(k>=0 && nums[k]==nums[index]) {
                res[0] = k;
                k--;
            }
            k = index;
            while(k<nums.length && nums[k]==nums[index]) {
                res[1] = k;
                k++;
            }
            return res;
        }
    }

    private int halfFind(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int mid;
        while(low <= high) {
            mid = (low + high)/2;
            if (nums[mid] < target) low = mid + 1;
            else if(nums[mid] > target) high = mid - 1;
            else return mid;
        }
        return -1;
    }
}