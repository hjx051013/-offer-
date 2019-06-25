package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
        int[] test = {1,3,5,6,7,9,10};
        Solution35 s = new Solution35();
        System.out.println(s.FindNumbersWithSum(test,13));
    }
}

class Solution35 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int i = 0, j = array.length-1;
        int multiply = Integer.MAX_VALUE;
        ArrayList<Integer> res = new ArrayList<>();
        while(i < j) {
            if(array[i]+array[j]>sum) j--;
            else if(array[i]+array[j]<sum) i++;
            else {
                if(array[i]*array[j] < multiply) {
                    res.clear();
                    res.add(array[i]);
                    res.add(array[j]);
                    multiply = array[i]*array[j];
                }
                i++;j--;
            }
        }
        return res;
    }
}
