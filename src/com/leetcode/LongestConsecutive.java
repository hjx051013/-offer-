package com.leetcode;

import java.util.HashMap;
import java.util.Map;
/*
128. 最长连续序列
给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。

方法：
HashMap存储每个数字出现次数
对于一个之前未出现的数nums[i]，如果
1. nums[i]-1和nums[i]+1之前都出现过，那么相当于可以将该数左右两线段合并
2. nums[i]-1出现而nums[i]+1未出现，将该数加入到左线段中
3. nums[i]-1未出现而nums[i]+1未出现，将该数加入到右线段中
4. nums[i]-1和nums[i]+1未出现，该数单独成为一个线段
 */
public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        Solution6 s = new Solution6();
        System.out.println(s.longestConsecutive(nums));
    }
}

class Solution6 {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])==null) {
                Integer prevVal = map.get(nums[i]-1);
                Integer nextVal = map.get(nums[i]+1);
                int newVal;
                if(prevVal==null&&nextVal==null) {
                    newVal = 1;
                    map.put(nums[i],newVal);
                } else if(prevVal==null&&nextVal!=null) {
                    newVal = nextVal+1;
                    map.put(nums[i],newVal);
                    map.put(nums[i]+nextVal,newVal);
                } else if(prevVal!=null&&nextVal==null) {
                    newVal = prevVal+1;
                    map.put(nums[i],newVal);
                    map.put(nums[i]-prevVal,newVal);
                } else {
                    newVal = prevVal+nextVal+1;
                    map.put(nums[i]-prevVal,newVal);
                    map.put(nums[i]+nextVal,newVal);
                    map.put(nums[i],newVal);
                }
                if(newVal>maxLen) maxLen = newVal;
            }
        }
        return maxLen;
    }
}
