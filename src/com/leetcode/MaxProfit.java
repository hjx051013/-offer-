package com.leetcode;

public class MaxProfit {

    public static void main(String[] args) {
        Solution23 s = new Solution23();
        int[] prices = {7,6,4,3,1};
        System.out.println(s.maxProfit(prices));
    }
}

class Solution23 {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i]<min) {
                min = prices[i];
            }
            if(i>0 && prices[i]-min>maxProfit) {
                maxProfit = prices[i]-min;
            }
        }

        return maxProfit;
    }
}
