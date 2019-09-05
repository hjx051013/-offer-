package com.leetcode;

/*
给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

思路：

 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        Solution70 s = new Solution70();
        System.out.println(s.majorityElement(arr));
    }
}

class Solution70 {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                tmp = nums[i];
                cnt++;
            }
            else {
                if(nums[i]==tmp) cnt++;
                else cnt--;
            }
        }
        return tmp;
    }
}
