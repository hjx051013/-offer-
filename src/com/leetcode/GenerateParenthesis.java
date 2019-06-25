package com.leetcode;
import java.util.*;
/*
22. 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

思路：
1.递归，每次递归选择一个左括号或者右括号，直到用完所有的左括号和右括号，当剩余左括号数量大于右括号数量时，停止递归返回
2.用一个map每次迭代构建的左右括号组成的字符串，一共迭代2n次，刚好用完所有的括号
* */
public class GenerateParenthesis {
    public static void main(String[] args) {
        Solution47 s = new Solution47();
        List<String> res = s.generateParenthesis(3);
        System.out.println(res.size());
        for(String str:res) {
            System.out.println(str);
        }
    }
}

class Solution47 {
    //递归方法
    /*
    private List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int rParNum = n, lParNum = n;
        dfs("",lParNum,rParNum);
        return res;
    }

    private void dfs(String str, int lParNum, int rParNum) {
        if(rParNum < lParNum || lParNum<0 ||rParNum<=0) return;
        if(rParNum ==1 && lParNum==0) {
            res.add(str+")");
        } else {
            dfs(str+"(",lParNum-1,rParNum);
            dfs(str+")",lParNum,rParNum-1);
        }
    }
    */
    //非递归方法
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Map<String,Pair<Integer,Integer>> resMap = new HashMap<>();
        resMap.put("", new Pair<>(0, 0));
        for(int i = 0; i < n*2; i++) {
            String[] keyArr = resMap.keySet().toArray(new String[0]);
            for(int j = 0; j < keyArr.length; j++) {
                Pair<Integer,Integer> usedPar = resMap.remove(keyArr[j]);
                int lParNum = usedPar.v1;
                int rParNum = usedPar.v2;
                if(n-lParNum>0) resMap.put(keyArr[j]+"(",new Pair<>(lParNum+1, rParNum));
                if(n-rParNum>0&&lParNum>rParNum) resMap.put(keyArr[j]+")",new Pair<>(lParNum, rParNum+1));
            }
        }
        for(String key:resMap.keySet()) {
            res.add(key);
        }
        return res;
    }
}
