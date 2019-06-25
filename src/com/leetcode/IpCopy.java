package com.leetcode;

import java.util.List;

import java.util.ArrayList;
import java.util.Scanner;
/*
93. 复原ip
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

示例:

输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]

方法：递归，回溯，剪枝

 */
public class IpCopy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution2 s = new Solution2();
        System.out.println(s.restoreIpAddresses(in.nextLine()));

    }
}

class Solution2 {

    private List<String> ipArr = new ArrayList<String>();

    public void restore(String str,int n,String prefix) {
        //递归解析，str为待解析的字符串，n为剩余字符串需要解析的整型个数，prefix代表已经解析字符串的前缀
        if(n > 1) {
            for(int i = 0; i < 3&&i<str.length() ;i++) {
                String curStr = str.substring(0,i+1);
                int curNum = Integer.parseInt(curStr);
                if(curNum>=0&&curNum<=255&&(curNum==0?curStr.length()==1:!curStr.startsWith("0"))&&i!=str.length()-1) {
                    restore(str.substring(i+1),n-1, prefix.equals("")?curStr:prefix+"."+curStr);
                }
            }
        } else if(n==1&&str.length()<=3) {
            String curStr = str.substring(0);
            int curNum = Integer.parseInt(curStr);
            if(curNum>=0&&curNum<=255&&(curNum==0?curStr.length()==1:!curStr.startsWith("0"))) {
                ipArr.add(prefix+"."+curStr);
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        restore(s,4,"");
        return ipArr;
    }
}
