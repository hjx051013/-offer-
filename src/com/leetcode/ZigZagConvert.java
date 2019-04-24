package com.leetcode;

/*
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G

方法一：
模拟矩阵然后依次填充
方法二：
令n = 2(nRows-1)
那么每一行字符在字符串中位置的分布规律是
第0行：0     n         2n         3n ...
第1行：1 n-1 n+1  2n-1 2n+1  3n-1 3n+1
第j行： j n-j n+j  2n-j 2n+j  2n-j 3n+j
 */
public class ZigZagConvert {

    public static void main(String[] args) {
        Solution14 s = new Solution14();
        System.out.println(s.convert("LEETCODEISHIRING",3));
    }
}

class Solution14 {
//    private char[][] mat;
//    public String convert(String s, int numRows) {
//        //思想是建立矩阵从上到下从左到右填充字符
//        int perNum = numRows*2-2;//每个v型包含字符个数
//        int k = s.length()/perNum + 1;
//        int colNum = (numRows-1)*k;
//        mat = new char[numRows][colNum];
//        int curCol = 0;
//        for(int i = 0, j = 0; i < k&&j < s.length(); i++) {//i代表第几个v，j代表第几个字符
//            for(int p = 0; p < numRows&&j < s.length(); p++) {//从上到下填充列
//                mat[p][curCol] = s.charAt(j);
//                j++;
//            }
//            curCol++;
//            for(int p = numRows-2; p>0&&j < s.length(); p--) {//从左到右填充对角线
//                mat[p][curCol++] = s.charAt(j);
//                j++;
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < numRows; i++) {
//            for(int j = 0; j < colNum; j++) {
//                if(mat[i][j]!=0) {
//                    sb.append(mat[i][j]);
//                }
//            }
//        }
//        return sb.toString();
//    }

    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        if(numRows <= 1) return s;
        int n = numRows*2-2;
        int l = s.length();
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < l; j+=n) {
                if(j+i<l) sb.append(s.charAt(j+i));
                if(i%(n/2)!=0&&j-i+n<l) sb.append(s.charAt(j-i+n));
            }
        }
        return sb.toString();
    }
}
