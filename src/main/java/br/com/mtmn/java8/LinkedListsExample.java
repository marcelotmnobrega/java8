package br.com.mtmn.java8;

import java.util.Arrays;

public class LinkedListsExample {

    public static void main(String[] args){
        SingleListNode<Integer> head = new SingleListNode(10);
        Arrays.asList(1,2,3,4,5).stream().forEach(head::appendTo);
        System.out.println(head);
    }
}

class SingleListNode<T> {

    SingleListNode next = null;
    T val;

    SingleListNode(T val){
        this.val = val;
    }

    void appendTo(T val){
        SingleListNode<T> end = new SingleListNode<>(val);
        SingleListNode n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        SingleListNode n = this;
        sb.append("[ " + n.val.toString());
        while(n.next != null) {
            n = n.next;
            sb.append(", " + n.val);
        }
        sb.append("]");
        return sb.toString();
    }
}
