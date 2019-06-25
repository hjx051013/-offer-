package com.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        int target = -11;
        Solution46 s = new Solution46();
        List<List<Integer>> res = s.fourSum(nums, target);
        for(List<Integer> list:res) {
            for(int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if(i!=list.size()-1) System.out.print(",");
                else System.out.println();
            }
        }
    }
}

class Solution46 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len < 4) return res;
        Arrays.sort(nums);
        for(int i = 0; i <= len-4; i++) {
            if(i>0&&nums[i]==nums[i-1]) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) continue;
            for(int j = i+1; j <= len-3; j++) {
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) continue;
                int p1 = j+1, p2 = len-1;
                int nowTarget = target-(nums[i]+nums[j]);
                while(p1 < p2) {
                    if(p1>j+1&&nums[p1]==nums[p1-1]) {
                        p1++;
                        continue;
                    }
                    if(nums[p1]+nums[p2] > nowTarget) p2--;
                    else if(nums[p1]+nums[p2] < nowTarget) p1++;
                    else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[p1]);
                        list.add(nums[p2]);
                        res.add(list);
                        p1++;p2--;
                    }
                }
            }
        }
        return res;
    }
}