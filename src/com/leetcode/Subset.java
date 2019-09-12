package com.leetcode;
import java.util.*;
/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
思路：
    深度遍历。每一个数字可选可不选

 */
public class Subset {
    public static void main(String[] args) {
        Solution78 s = new Solution78();
        int[] nums = {1,2,3};
        List<List<Integer>> res = s.subsets(nums);
        System.out.println("size = "+res.size());
        for(List<Integer> list:res) {
            for(int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if(i!=list.size()-1) System.out.print(",");
            }
            System.out.println();
        }
    }
}

class Solution78 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> tmp = new LinkedList<>();
        dfs(nums, 0, tmp);
        return res;
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> preRes) {
        if(index >= nums.length) {
            List<Integer> resCopy = new ArrayList<>(preRes);
            res.add(resCopy);
            return;
        }
        //不加当前值
        dfs(nums, index+1, preRes);
        //加入当前值
        preRes.addLast(nums[index]);
        dfs(nums, index+1, preRes);
        preRes.removeLast();

    }
}