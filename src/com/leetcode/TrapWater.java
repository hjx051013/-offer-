package com.leetcode;

/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/rainwatertrap.png

上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

方法：
遍历寻找一个凹槽，即中间部分的高度都低于两端高度，然后填充，
循环直到waterCnt不发生变化

 */
public class TrapWater {

    public static void main(String[] args) {
        Solution13 s = new Solution13();
        int[] height = {4,2,0,3,2,4,3,4};
        System.out.print(s.trap(height));
    }
}

class Solution13 {
    public int trap(int[] height) {
        int prevCnt = 0;
        int waterCnt = 0;
        do {
            prevCnt = waterCnt;
            int start=0,end;
            for(int i = 0; i < height.length; i++) {
                if(height[i]>0) {
                    start = i;
                    break;
                }
            }
            for(int i = start+1; i < height.length; i++) {
                if(height[i]>height[i-1]&&((i!=height.length-1)?(height[i]>=height[i+1]):true)) {
                    end = i;
                    int paddingH = Math.min(height[start],height[end]);
                    for(int j = start; j <= end; j++) {
                        if(paddingH>height[j]) {
                            waterCnt += paddingH-height[j];
                            height[j] = paddingH;
                        }
                    }
                    start = i;
                }
            }
        } while (waterCnt>prevCnt);
        return waterCnt;
    }
}
