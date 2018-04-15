package br.com.mtmn.java8;

public class LinkedLists {

    public static void main(String[] args){
        SingleListNode tree = new SingleListNode(10);

    }
}

class SingleListNode {

    SingleListNode next = null;
    int num;

    SingleListNode(int val){
        this.num = val;
    }

    void appendTo(int val){
        SingleListNode end = new SingleListNode(val);
        SingleListNode n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }
}
