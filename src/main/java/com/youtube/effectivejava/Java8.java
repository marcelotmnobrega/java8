package com.youtube.effectivejava;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static java.util.Comparator.comparingInt;

public class Java8 {

    public static void main(String[] args){

        List<String> list = Arrays.asList("Marcelo", "Tavares", "de", "Melo", "Nobrega");
        Collections.sort(list, comparingInt(String::length));
        list.stream().forEach(System.out::println);

    }
}
