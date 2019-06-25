package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        Solution30 s = new Solution30();
        System.out.println(s.maxEnvelopes(envelopes));
    }
}

class Solution30 {
    /*
    private int maxNum;
    public int maxEnvelopes(int[][] envelopes) {
        List<Pair<Integer,Integer>> pairList = new ArrayList<>();
        for(int i = 0; i < envelopes.length; i++) {
            pairList.add(new Pair(envelopes[i][0],envelopes[i][1]));
        }
        pairList.sort(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if(o1.v1==o2.v1) {
                    if(o1.v2<o2.v2) return -1;
                    else if(o1.v2==o2.v2) return 0;
                    else return 1;
                } else {
                    return o1.v1<o2.v1?-1:1;
                }
            }
        });
        List<List<Pair<Integer,Integer>>> pairs = new ArrayList<>();
        int prevV1 = 0;
        List<Pair<Integer,Integer>> curList = null;
        for(int i = 0; i < pairList.size(); i++) {
            if(pairList.get(i).v1==prevV1) {
                curList.add(pairList.get(i));
            } else {//当前长度与前一个长度不同，则加入新的
                if(curList!=null) pairs.add(curList);
                curList = new ArrayList<>();
                prevV1 = pairList.get(i).v1;
                curList.add(pairList.get(i));
            }
        }
        pairs.add(curList);

        traverse(pairs,0,0,0);

        return maxNum;
    }

    private void traverse(List<List<Pair<Integer,Integer>>> pairs,int prevNum,int prevV2,int curIndex) {
        if(curIndex==pairs.size()) {
            if(prevNum>maxNum) maxNum = prevNum;
        } else {
            for(int i = 0; i < pairs.get(curIndex).size(); i++) {
                int curV2 = pairs.get(curIndex).get(i).v2;
                if(curV2>prevV2) {
                    traverse(pairs,prevNum+1,curV2,curIndex+1);//找到刚好放得下的最小宽度的当前长度的信封
                    break;
                }
            }
            traverse(pairs,prevNum,prevV2,curIndex+1);//当前长度的信封不选
        }
    }*/

    public int maxEnvelopes(int[][] envelopes) {
        List<Pair<Integer,Integer>> pairList = new ArrayList<>();
        for(int i = 0; i < envelopes.length; i++) {
            pairList.add(new Pair(envelopes[i][0],envelopes[i][1]));
        }
        pairList.sort(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if(o1.v1==o2.v1) {
                    if(o1.v2<o2.v2) return -1;
                    else if(o1.v2==o2.v2) return 0;
                    else return 1;
                } else {
                    return o1.v1<o2.v1?-1:1;
                }
            }
        });

        int[] dp = new int[pairList.size()];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for(int i = 0; i < pairList.size(); i++) {
            for(int j = i+1; j < pairList.size(); j++) {
                if(pairList.get(j).v1>pairList.get(i).v1&&pairList.get(j).v2>pairList.get(i).v2) {
                    dp[j] = Math.max(dp[j],dp[i]+1);
                }
            }
        }

        int maxNum = 0;
        for(int i = 0; i < dp.length; i++) {
            if(dp[i]>maxNum) maxNum = dp[i];
        }
        return maxNum;
    }
}

