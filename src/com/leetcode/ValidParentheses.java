package com.leetcode;

import java.util.HashMap;
import java.util.Stack;
import java.util.Map;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

方法：
使用栈，遇到左括号就插入栈，遇到右括号就pop出栈元素后与该右括号进行比较
 */
public class ValidParentheses {
    public static void main(String[] args) {
        Solution20 s = new Solution20();
        System.out.println(s.isValid("{"));
    }
}

class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for(int i = 0; i < s.length();i++) {
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[') {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()) return false;
                else {
                    char c = stack.pop();
                    char now = s.charAt(i);
                    if(map.get(c)!=now) return false;
                }
            }
        }
        return stack.isEmpty()?true:false;
    }
}