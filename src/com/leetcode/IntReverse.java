package com.leetcode;

/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

方法：常规做法
 */

public class IntReverse {

    public static void main(String[] args) {
        Solution15 s = new Solution15();
        System.out.println(s.reverse(-2147483648));
    }
}

class Solution15 {
    public int reverse(int x) {
        if(x == 0) return 0;
        StringBuilder sb = new StringBuilder();
        if(x < 0) sb.append('-');
        String x_str = String.valueOf(x);
        boolean isFirst = true;
        for(int i = x_str.length()-1; i >= 0; i--) {
            char c = x_str.charAt(i);
            if(c=='-') continue;
            if(c!='0') {
                sb.append(c);
            } else if(isFirst==false) {//如果c=='0'，而且已经不是第一位数字
                sb.append(c);
            }
            if(isFirst) isFirst = true;
        }
        long rx = Long.parseLong(sb.toString());
        if(rx > Integer.MAX_VALUE||rx < Integer.MIN_VALUE) return 0;
        else return Integer.parseInt(sb.toString());
    }
}
