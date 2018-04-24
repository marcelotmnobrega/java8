package com.pluralsight.java8;

import java.util.Comparator;

public class Main {

    public static void main(String[] args){

        Comparator<String> stringComparator = Comparator.comparingInt(String::length);

        Runnable r = () -> {
            System.out.println("Hello");
        };
        r.run();
    }
}
