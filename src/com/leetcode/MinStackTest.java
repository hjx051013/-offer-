package com.leetcode;

import java.util.LinkedList;

public class MinStackTest {

}


class MinStack {
    LinkedList<Integer> list;
    Integer min = null;
    /** initialize your data structure here. */
    public MinStack() {
        list = new LinkedList<>();
    }

    public void push(int x) {
        list.add(x);
        min = (min!=null)?(x<min?x:min):x;
    }

    public void pop() {
        if(list.size()==0) return;
        int popInt = list.removeLast();
        if(min==popInt) {
            min = Integer.MAX_VALUE;
            for(int i = 0; i < list.size(); i++) {
                if(list.get(i) < min) min = list.get(i);
            }
        }
    }

    public int top() {
        return list.getLast();
    }

    public int getMin() {
        return min;
    }
}