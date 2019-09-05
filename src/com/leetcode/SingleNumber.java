package com.leetcode;

/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4

思路：
相同数字异或得到0，0与x异或得到x
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        Solution69 s = new Solution69();
        System.out.println(s.singleNumber(arr));
    }
}

class Solution69 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
