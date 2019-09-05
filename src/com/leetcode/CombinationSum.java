package com.leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        Solution68 s = new Solution68();
        List<List<Integer>> res = s.combinationSum(candidates, target);
        System.out.println("[");
        for(int i = 0; i < res.size(); i++) {
            System.out.print("[");
            for(int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j));
                if(j != res.get(i).size()-1) System.out.print(",");
            }
            System.out.print("]");
            if(i != res.size()-1) System.out.print(",");
            System.out.println();
        }
        System.out.println("]");
    }
}

class Solution68 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> integerList = new LinkedList<>();
        dfs(candidates,0,integerList,target);
        return res;
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> integerList, int avail) {
        if(index >= nums.length || avail < nums[index]) return;

        if(avail - nums[index] == 0) {
            integerList.addLast(nums[index]);
            List<Integer> integers = new ArrayList<>(integerList);
            res.add(integers);
            integerList.removeLast();
            return;
        }
        //取当前数字，不走下一个index
        integerList.addLast(nums[index]);
        if(avail - nums[index] > 0) dfs(nums, index, integerList,avail - nums[index]);
        integerList.removeLast();

        //取当前数字，走下一个index
        integerList.addLast(nums[index]);
        if(avail - nums[index] > 0) dfs(nums, index+1, integerList,avail - nums[index]);
        integerList.removeLast();

        //如果之前没有取过当前数字且决定不取当前数字，直接走下一个index
        if(integerList.indexOf(nums[index]) == -1) dfs(nums, index+1, integerList, avail);
    }
}