package com.leetcode;

import java.util.Arrays;
/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1


方法一：
递归搜寻数组中的目标值
方法二：
在num数组中先找到转折的两个数，然后再确定目标数是在左序列还是右序列中。

 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        Solution5 s = new Solution5();
        System.out.println(s.search(nums,3));

    }
}

class Solution5 {
//    public int search(int[] nums, int target) {
//        return searchRange(nums,0,nums.length-1,target);
//    }
//
//    public int searchRange(int[] nums,int start,int end,int target) {
//        if(start>end) return -1;
//        if(start==end) return nums[start]==target?start:-1;
//        int targetIndex = -1;
//        int mid = (start+end)/2;
//        if(nums[mid]!=target) {
//            if(nums[mid]>=nums[start]) {//mid在左边递增序列中
//                if(target>=nums[start]&&target<nums[mid]) targetIndex = Arrays.binarySearch(nums,start,mid,target);//如果在mid左边，直接二分搜索
//                else targetIndex = searchRange(nums,mid+1,end,target);
//            } else if(nums[mid]<=nums[end]) {//mid在右边递增序列中
//                if(target<=nums[end]&&target>nums[mid]) targetIndex = Arrays.binarySearch(nums,mid+1,end+1,target);//如果在mid右边，直接二分搜索
//                else targetIndex = searchRange(nums,start,mid-1,target);
//            }
//        } else {
//            targetIndex = mid;
//        }
//        if(targetIndex<0) return -1;
//        else return targetIndex;
//    }

    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        int l = 0, r = nums.length-1;
        if(nums[l] >= nums[r]) {
            int m;
            //寻找到转折的两个位置
            while(r-l>1) {
                m = (l+r)/2;
                if(nums[l]<nums[m]) l = m;
                if(nums[r]>nums[m]) r = m;
            }
            if(target>=nums[0]) {//target在左边递增序列中
                r = l;
                l = 0;
            } else {//target在右边递增序列中
                l = r;
                r = nums.length-1;
            }
        }

//        在[l,r]区间内进行二分查找
        int m;
        while(l<=r) {
            m = (l+r)/2;
            if(target < nums[m]) r = m-1;
            else if(target > nums[m]) l = m+1;
            else return m;
        }
        return -1;
    }


}


