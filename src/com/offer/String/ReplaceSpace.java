package com.offer.String;

/*
请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
要求使用时间复杂度为O(n)，空间复杂度为O(1)的算法
思路：
如果直接使用StringBuffer的replace函数，肯定会涉及到数组的扩容和数组元素的复制移动，时间复杂度为O(n^2)

* */
public class ReplaceSpace {
    public static void main(String[] args) {
        Solution5 s = new Solution5();
        String res = s.replaceSpace(new StringBuffer("We Are Happy"));
        System.out.println(res);
    }
}

class Solution5 {
    public String replaceSpace(StringBuffer buffer) {
        int  p1 = buffer.length()-1;
        for(int i = 0; i <= p1; i++) {
            if(buffer.charAt(i)==' ') buffer.append("  ");
        }
        int p2 = buffer.length()-1;
        while(p1>=0 && p2>=0) {
            if(buffer.charAt(p1)==' ') {
                buffer.setCharAt(p2--, '0');
                buffer.setCharAt(p2--, '2');
                buffer.setCharAt(p2--, '%');
            } else {
                buffer.setCharAt(p2--, buffer.charAt(p1));
            }
            p1--;
        }

        return buffer.toString();
    }
}