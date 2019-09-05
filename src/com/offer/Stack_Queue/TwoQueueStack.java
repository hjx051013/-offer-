package com.offer.Stack_Queue;

/*
用两个队列实现一个栈。
思路：
    时钟保持一个队列为空另一个队列不空
    push,如果两个队列都空，随便选一个队列appendTail，否则选择不空的队列appendTail
    pop, 如果两个队列都空，则抛出异常，否则选出其中不空的队列，将出尾部元素外的元素全部腾挪到另一个空队列中，将最后一个尾部元素返回
 */
public class TwoQueueStack {
    public static void main(String[] args) {
        StackWithTwoQueue<Integer> stack = new StackWithTwoQueue<>();
        for(int i = 0; i < 10; i++) stack.push(i);
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
class StackWithTwoQueue<E> {
    //始终保持有一个队列为空
    private QueueWithTwoStack<E> q1 = new QueueWithTwoStack<>();
    private QueueWithTwoStack<E> q2 = new QueueWithTwoStack<>();

    public E pop() {
        QueueWithTwoStack<E> tmpQ = q1.isEmpty()?q2:q1;
        QueueWithTwoStack<E> emptyQ = q1.isEmpty()?q1:q2;
        if(tmpQ.isEmpty()) {
            throw new QueueEmptyException();
        }
        E element = null;
        while(!tmpQ.isEmpty()) {
            if(element!=null) emptyQ.appendTail(element);
            element = tmpQ.deleteHead();
        }
        return element;
    }

    public void push(E e) {
        QueueWithTwoStack<E> tmpQ = q1.isEmpty()?q2:q1;
        tmpQ.appendTail(e);
    }

    public boolean isEmpty() {
        return q1.isEmpty()&&q2.isEmpty();
    }

}
