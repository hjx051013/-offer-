package com.leetcode;
/*
29. 两数相除
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

示例 1:

输入: dividend = 10, divisor = 3
输出: 3
示例 2:

输入: dividend = 7, divisor = -3
输出: -2
说明:

被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。

思想：
先都转成long型正值（担心dividend = Integer.MIN_VALUE），
根据dividend = divisor*(2^k1+2^k2+...+2^kn)
先找到2^k1,然后dividend -= divisor*2^k1
迭代下去
直到dividend < divisor为止
 */
public class Divide {
    public static void main(String[] args) {
        Solution62 s = new Solution62();
        System.out.println(s.divide(Integer.MIN_VALUE, -1));
    }
}

class Solution62 {
    public int divide(int dividend, int divisor) {
        if(dividend==0) return 0;
        if(dividend==Integer.MIN_VALUE&&divisor==-1) return Integer.MAX_VALUE;
        long ldivdend  = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if(ldivdend<ldivisor) return 0;
        boolean isPos = (dividend>0&&divisor>0) || (dividend<0&&divisor<0);

        long tempDivdend = ldivdend, tempSub = ldivisor;
        int result = 0;
        while(tempDivdend>=tempSub) {
            int p = 1;
            while(tempDivdend-(tempSub+tempSub)>=0) {
                tempSub += tempSub;
                p <<= 1;
            }
            result += p;
            tempDivdend -= tempSub;
            tempSub = ldivisor;
        }

        return isPos?result:-result;
    }
}
