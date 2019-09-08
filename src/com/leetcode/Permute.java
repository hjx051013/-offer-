package com.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

思路：
1. 回溯法，即dfs
2. 从第一个元素起，将后一个元素插入到前面的全排列的子序列间隙中，形成新的全排列，循环到最后一个元素
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution66 s = new Solution66();
        List<List<Integer>> result = s.permute(nums);
        for(List<Integer> list:result) {
            for(Integer e:list) {
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }
}

class Solution66 {
    /*回溯法*/
    /*
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numList = new LinkedList<>();
        List<Integer> addedList = new LinkedList<>();
        for(Integer e:nums) {
            numList.add(e);
        }
        dfs(numList,addedList);

        return res;
    }

    private void dfs(List<Integer> numList, List<Integer> addedList) {
        if(numList.size()==0) {
            List<Integer> resList = new LinkedList<>();
            resList.addAll(addedList);
            res.add(resList);
        } else {
            int size = numList.size();
            for(int i = 0; i < size; i++) {
                Integer rmNum = numList.remove(i);
                addedList.add(rmNum);
                dfs(numList, addedList);
                addedList.remove(rmNum);
                numList.add(i,rmNum);
            }
        }
    }
    */
    /*非递归,插入法*/
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            int cur_size = res.size();
            for(int j = 0; j < cur_size; j++) {
                for(int k = 0; k <= i; k++) {
                    List<Integer> tempList = new ArrayList<>(res.get(j));
                    tempList.add(k,nums[i]);
                    res.add(tempList);
                }
            }

            for(int j = 0; j < cur_size; j++) {
                res.remove(0);
            }
        }

        return res;
    }
}
