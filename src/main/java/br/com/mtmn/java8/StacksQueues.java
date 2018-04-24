package br.com.mtmn.java8;

import java.util.Arrays;

public class StacksQueues {

}

class Stack {
    Node top;

    Object pop() {
        if (top != null) {
            Object item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }

    void push(Object item) {
        Node t = new Node(item);
        t.next = top;
        top = t;
    }

    Object peek() {
        return top.data;
    }
}

class Node {
    Object data;
    Node next;

    Node(Object item) {
        this.data = item;
        this.next = null;
    }
}

class Queue {

    Node first, last;

    void enqueue(Object item) {
        if (first == null) {
            last = new Node(item);
            first = last;
        } else {
            last.next = new Node(item);
            last = last.next;
        }
    }

    Object dequeue() {
        if (first != null) {
            Object item = first.data;
            first = first.next;
            if (first == null) last = null;
            return item;
        }
        return null;
    }
}