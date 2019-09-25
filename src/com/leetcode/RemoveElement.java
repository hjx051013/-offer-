package com.leetcode;

public class RemoveElement {
    public static void main(String[] args) {
        Solution86 s = new Solution86();
        int[] nums = {0,1,2,2,3,0,4,2};
        int availNum = s.removeElement(nums, 2);
        System.out.println(availNum);
        for(int i = 0; i < availNum; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}

class Solution86 {
    private void swapElement(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public int removeElement(int[] nums, int val) {
        int p1 = 0, p2 = 0;
        while(p2<nums.length) {
            if(nums[p2]==val) {
                p2++;
            } else {
                swapElement(nums,p1,p2);
                p1++;
                p2++;
            }
        }
        return p1;
    }
}


