package br.com.mtmn.java8;

public class TreeNode<T> {

    T elem = null;
    TreeNode<T> left = null;
    TreeNode<T> right = null;

    public TreeNode(T elem){
        this.elem = elem;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);

    }
}


