package com.leetcode;
import java.sql.SQLSyntaxErrorException;
import java.util.*;
/*
56. 合并区间
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

方法：
先让区间按照其实位置先后顺序排序
然后扫描区间，
1. 如果当前的end比当前扫描区间的start要小，之前的[start,end]形成一个区间，加入到结果区间中，更新start,end为当前扫描区间的start,end
2. 如果当前end比当前扫描区间的start要大
    - 比当前区间的end要大，那么直接扫描下一个区间
    - 比当前区间start要大，比end要小，更新end为当前区间end
 */
public class MergeInterval {
    public static void main(String[] args) {
        int[][] samples = {{1,4},{2,3}};
        List<Interval> intervals = new ArrayList<>();
        for(int i = 0; i < samples.length; i++) {
            intervals.add(new Interval(samples[i][0],samples[i][1]));
        }
        Solution12 s = new Solution12();
        intervals = s.merge(intervals);
        for(int i = 0; i < intervals.size(); i++) {
            if(i==0) System.out.print("[["+intervals.get(i).start+","+intervals.get(i).end+"]");
            else {
                System.out.print(",["+intervals.get(i).start+","+intervals.get(i).end+"]");
            }
            if(i==intervals.size()-1) {
                System.out.print("]");
            }
        }
    }
}

class Solution12 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if(intervals.size()==1||intervals.size()==0) {
            result.addAll(intervals);
            return result;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start<o2.start) return -1;
                else if(o1.start==o2.start) return 0;
                else return 1;
            }
        });

        int curStart = -1,curEnd = -1;
        for(int i = 0; i < intervals.size()-1; i++) {
            if(i==0) {
                curStart = intervals.get(i).start;
                curEnd = intervals.get(i).end;
            }
            if(curEnd<intervals.get(i+1).start) {
                result.add(new Interval(curStart,curEnd));
                curStart = intervals.get(i+1).start;
                curEnd = intervals.get(i+1).end;
            } else {
                if(curEnd < intervals.get(i+1).end) curEnd = intervals.get(i+1).end;
            }
        }
        if(curStart!=-1&&curEnd!=-1) {
            result.add(new Interval(curStart,curEnd));
        }

        return result;
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}