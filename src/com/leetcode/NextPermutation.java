package com.leetcode;
/*
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

思路：

 */
public class NextPermutation {
    public static void main(String[] args) {
        Solution65 s = new Solution65();
        int[] arr = {2,2,0,4,3,1};
        s.nextPermutation(arr);
        for(Integer e:arr) {
            System.out.print(e+" ");
        }
    }
}

class Solution65 {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length == 1) return;
        int i;
        for(i = nums.length-2; i >= 0; i--) {//逆序寻找第一次下降的相邻数p
            if(nums[i] < nums[i+1]) {
                for(int j = nums.length-1; j > i; j--) {//在该数后面序列l中找到刚好比nums[i]大的数q，交换p,q，将l逆序
                    if(nums[j] > nums[i]) {
                        swap(nums, i, j);
                        reverse(nums,i+1, nums.length-1);
                        return;
                    }
                }
            }
        }
        if(i < 0) reverse(nums, 0, nums.length-1);
    }

    private void swap(int[] nums, int px, int py) {
        int temp = nums[px];
        nums[px] = nums[py];
        nums[py] = temp;
    }

    private void reverse(int[] nums, int l,int r) {
        int p1 = l, p2 = r;
        while(p1 < p2) {
            swap(nums, p1++, p2--);
        }
    }
}