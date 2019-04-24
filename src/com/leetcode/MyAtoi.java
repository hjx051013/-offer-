package com.leetcode;

/*
8. 字符串转换整数 (atoi)
请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

示例 1:

输入: "42"
输出: 42
示例 2:

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
示例 3:

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
示例 4:

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。
示例 5:

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     因此返回 INT_MIN (−231) 。

方法：
常规判断
先trim,然后获取第一个非数字字符位置i，获取[0,i)的子串，如果存在去掉排头的所有0，
如果字符串长度超限，返回Integer的最大或最小值，如果转成long型超越Integer的返回，同样返回Integer的最大或最小值
long强转int返回
 */
public class MyAtoi {
    public static void main(String[] args) {
        Solution16 s = new Solution16();
        String[] tests = {"42","   -42","4193 with words","words and 987","-91283472332","+0000","-000000000000001","2147483648","-2147483648","4193 with words"};
        for(int i = 0; i < tests.length; i++) {
            System.out.println(s.myAtoi(tests[i]));
        }
    }
}

class Solution16 {
    public int myAtoi(String str) {
        if(str==null) return 0;
        str = str.trim();
        if(str.equals("")||(str.charAt(0)!='+'&&str.charAt(0)!='-'&&!(str.charAt(0)>='0'&&str.charAt(0)<='9'))) {
            return 0;
        }
        //获得从开头到非空字符之间的字符串
        int end  = 0;
        int i;
        for(i = 0; i < str.length(); i++) {
            if(!(str.charAt(i)>='0'&&str.charAt(i)<='9')) {
                if(i==0&&(str.charAt(i)=='+'||str.charAt(i)=='-')) continue;
                else {
                    end = i;
                    break;
                }
            }
        }
        if(i==str.length()) end = str.length();
        String subStr = str.substring(0,end);
        if(subStr.equals("")) return 0;
        String abs = (subStr.startsWith("-")||subStr.startsWith("+"))?subStr.substring(1):subStr;
        for(i = 0; i < abs.length(); i++) {
            if(abs.charAt(i)!='0') break;
        }
        abs = abs.substring(i);
        if(abs.equals("")) return 0;
        if(abs.length()>10) {
            if(subStr.startsWith("-")) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        }
        long num = Long.parseLong(subStr);
        if(subStr.startsWith("-")&&num<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(!subStr.startsWith("-")&&num>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int)num;
    }

}
