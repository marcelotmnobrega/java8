package br.com.mtmn.java8;

import java.util.Arrays;

public class StacksQueues {

}

class Stack<T> {
    Node<T> top;

    T pop() {
        if (top != null) {
            T item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }

    void push(T item) {
        Node t = new Node(item);
        t.next = top;
        top = t;
    }

    T peek() {
        return top.data;
    }
}

class Node<T> {
    T data;
    Node next;

    Node(T item) {
        this.data = item;
        this.next = null;
    }
}

class Queue<T> {

    Node<T> first, last;

    void enqueue(T item) {
        if (first == null) {
            last = new Node(item);
            first = last;
        } else {
            last.next = new Node(item);
            last = last.next;
        }
    }

    T dequeue() {
        if (first != null) {
            T item = first.data;
            first = first.next;
            if (first == null) last = null;
            return item;
        }
        return null;
    }
}