package com.leetcode;

import java.util.ArrayList;
import java.util.List;
/*
给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

说明：

如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。

 */
public class MinimumTotal {

    public static void main(String[] args) {
        Solution29 s = new Solution29();

        List<List<Integer>> triangle = new ArrayList<>();
        int[][] nums = {{2},
                        {3,4},
                        {6,5,7},
                        {4,1,8,3}
        };
        for(int i = 0; i < nums.length; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < nums[i].length; j++) {
                row.add(nums[i][j]);
            }
            triangle.add(row);
        }

        System.out.println(s.minimumTotal(triangle));
    }


}

class Solution29 {
    //下面的方法超时
    /*
    private int minTotal = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        traverse(triangle,0,0,0);
        return minTotal;
    }

    private void traverse(List<List<Integer>> triangle, int curLevel, int curIndex, int preSum) {
        if(curLevel<triangle.size()&&curIndex<triangle.get(curLevel).size()) {
            preSum += triangle.get(curLevel).get(curIndex);
            if(curLevel==triangle.size()-1) {
                if(preSum < minTotal) minTotal = preSum;
            } else {//没有遍历到底层
                traverse(triangle,curLevel+1,curIndex,preSum);
                traverse(triangle,curLevel+1,curIndex+1,preSum);
            }
        }
    }*/
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] prevLevelMin = new int[triangle.get(triangle.size()-1).size()];
        int[] curLevelMin = new int[prevLevelMin.length];
        prevLevelMin[0] = triangle.get(0).get(0);
        curLevelMin[0] = prevLevelMin[0];
        for(int i = 1; i < triangle.size(); i++) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                if(j == 0) curLevelMin[j] = prevLevelMin[j]+triangle.get(i).get(j);
                else if(j == triangle.get(i).size()-1) curLevelMin[j] = prevLevelMin[j-1]+triangle.get(i).get(j);
                else {
                    curLevelMin[j] = Math.min(prevLevelMin[j-1],prevLevelMin[j])+triangle.get(i).get(j);
                }
            }
            if(i<triangle.size()-1) {
                int[] temp = prevLevelMin;
                prevLevelMin = curLevelMin;
                curLevelMin = temp;
            }
        }



        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < curLevelMin.length; i++) {
//            System.out.println(curLevelMin[i]);
            if(curLevelMin[i] <minVal) minVal = curLevelMin[i];
        }
        return minVal;
    }

}
