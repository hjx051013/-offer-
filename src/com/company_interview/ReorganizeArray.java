package com.company_interview;
/*
给定一个数组 里面只有0跟1 然后把如果有0那么把0 变成2个，顺序不变,多出的位数 直接舍弃
例子 
[1,0,1]=>[1,0,0]
[001010]=>[000010]
时间复杂度 O(n)  空间复杂度O(n)
思路：
先计算重组后数组最末位在原数组的位置，然后对原数组从后往前更新，时间复杂度O(n)，空间复杂度O(1)
*/

import java.util.Scanner;

public class ReorganizeArray {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
        }
        int arrayLen = nums.length;
        int nowLen = 0;
        int i;
        for(i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nowLen += 2;
            } else {
                nowLen += 1;
            }
            if(nowLen >= arrayLen) {
                break;
            }
        }
        int k = nums.length-1;
        while(k >= 0 && i >= 0) {
            if(k == nums.length-1 && nowLen > arrayLen && nums[i] == 0) {//最后一个0只用填一遍
                nums[k--] = nums[i--];
            } else {
                if(nums[i]==0) {
                    nums[k--] = 0;
                    nums[k--] = 0;
                    i--;
                } else {
                    nums[k--] = 1;
                    i--;
                }
            }
        }
        for(i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        in.close();
    }
}
