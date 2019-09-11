package com.leetcode;

/*
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

示例:

输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
进阶：

一个直观的解决方案是使用计数排序的两趟扫描算法。
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
你能想出一个仅使用常数空间的一趟扫描算法吗？

思路：
    荷兰国旗问题。
    采用指针begin, cur, end。begin指向位置之前的都是0，end指向位置之后的都是2,cur从左到右扫描：
    1. 如果扫描位置值为0，cur与begin位置值交换，并且cur++, begin++
    2. 如果扫描位置值为1，cur++即可
    3. 如果扫描位置值为2，cur与end位子值交换，并且cur++, end--

 */
public class SortColors {
    public static void main(String[] args) {
        Solution75 s = new Solution75();
        int[] nums = {2,0,2,1,1,0};
        s.sortColors(nums);
        for(int num:nums) {
            System.out.print(num+",");
        }
    }
}

class Solution75 {
    private void change(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public void sortColors(int[] nums) {
        int begin = 0, end = nums.length-1, cur = 0;
        while(cur <= end) {
            if (nums[cur] == 0) {
                change(nums, begin, cur);
                begin++;
                cur++;
            } else if(nums[cur] == 1) {
                cur++;
            } else {
                change(nums, cur, end);
                end--;
            }
        }
    }
}