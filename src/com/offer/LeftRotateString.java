package com.offer;

public class LeftRotateString {
    public static void main(String[] args) {
        String str = "abcXYZdef";
        Solution3 s = new Solution3();
        System.out.println(s.LeftRotateString(str,3));
    }
}

class Solution3 {
    public String LeftRotateString(String str,int n) {
        n = n%str.length();
        return str.substring(n)+ str.substring(0,n);
    }
}
