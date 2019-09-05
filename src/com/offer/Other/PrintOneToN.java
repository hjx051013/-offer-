package com.offer.Other;

/*
面试题12：打印1到最大的n位数
题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999。

思路：
    实质上是n个'0'-'9'的字符的全排列问题。用递归解决。

 */
public class PrintOneToN {
    public static void main(String[] args) {
        Solution12 s = new Solution12();
        s.print1Ton(3);
    }
}

class Solution12 {
    public void print1Ton(int n) {
        char[] number = new char[n];
        for (int i = 0; i < 10; i++) {
            number[0] = (char)('0'+i);
            print1TonRecur(number,0);
        }

    }

    private void print1TonRecur(char[] number, int index) {
        if(index == number.length-1) {
            printNumber(number);
            return;
        }
        for(int i = 0; i < 10; i++) {
            number[index+1] = (char)('0' + i);
            print1TonRecur(number, index+1);
        }
    }

    private void printNumber(char[] number) {
        boolean isBegin0 = true;
        for(int i = 0; i < number.length; i++) {
            if(isBegin0&&number[i]!='0')
                isBegin0 = false;
            if(!isBegin0) {
                System.out.print(number[i]);
            }
        }
        if(!isBegin0)System.out.println();
    }
}
