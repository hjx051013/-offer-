package com.leetcode;

public class MaxProfitII {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        Solution24 s = new Solution24();
        System.out.println(s.maxProfit(prices));
    }
}

class Solution24 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 0; i < prices.length-1; i++) {
            if(prices[i+1]-prices[i] > 0) profit+=(prices[i+1]-prices[i]);
        }

        return profit;
    }
}
