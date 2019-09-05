package com.offer.Stack_Queue;

import java.util.EmptyStackException;
import java.util.Stack;
/*
题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead，
分别完成在队列尾部插入结点和在队列头部删除结点的功能。

思路：
    appendTail只需要把append元素加入到stack1中
    deleteHead如果stack2为空，则将stack1中元素全部移到stack2中，然后pop出stack2的元素
 */
public class TwoStackQueue {
    public static void main(String[] args) {
        QueueWithTwoStack<Integer> q = new QueueWithTwoStack<>();
        for(int i = 1; i < 10; i++) {
            q.appendTail(i*i);
            System.out.println(q.deleteHead());
        }
    }
}

class QueueWithTwoStack<E> {
    private Stack<E> s1 = new Stack<>();
    private Stack<E> s2 = new Stack<>();

    public void appendTail(E element) {
        s1.push(element);
    }

    public E deleteHead() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                E tmp = s1.pop();
                s2.push(tmp);
            }
        }
        if(s2.isEmpty()) {
            throw new EmptyStackException();
        }
        return s2.pop();
    }

    public boolean isEmpty() {
        return s1.isEmpty()&&s2.isEmpty();
    }
}
