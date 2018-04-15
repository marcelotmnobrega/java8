package br.com.mtmn.java8;

import java.util.Arrays;

public class ArraysStrings {

    public static void main(String[] args) {
//        System.out.println(hasUniqueChars("aabcdef"));
//        System.out.println(hasUniqueChars("abcdefega"));
//        System.out.println(hasUniqueChars("abcdef"));

//        System.out.println(isPermutation("abcd", "dabc"));
//        System.out.println(isPermutation("abcd", "dabc "));
//        System.out.println(isPermutation("abcd ", "dabc "));
//        System.out.println(isPermutation("abced", "dabc "));

        System.out.println("-->" + String.valueOf(replaceSpaces("Sample Text to be usedd. . ...".toCharArray())) + "<--");
        System.out.println("-->" + String.valueOf(replaceSpaces("Sample  Text to   be used".toCharArray())) + "<--");
    }

    //ASCII code (128 chars)
    public static boolean hasUniqueChars(String input) {
        boolean[] arr = new boolean[128];

        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i);
            if (arr[val]) {
                return false;
            } else {
                arr[val] = true;
            }
        }
        return true;
    }

    //Permutation - Anagram
    public static boolean isPermutation(String s1, String s2) {
        //pre-conditions
        assert (s1 != null);
        assert (s2 != null);
        if (s1.length() != s2.length()) return false;

        char[] arrS1 = s1.toCharArray();
        Arrays.sort(arrS1);
        String sortedS1 = new String(arrS1);

        char[] arrS2 = s2.toCharArray();
        Arrays.sort(arrS2);
        String sortedS2 = new String(arrS2);

        return sortedS1.equals(sortedS2);
    }

    public static char[] replaceSpaces(char[] input) {
        //inits
        int length = input.length;
        int spaceCount = 0, newLength, i;

        for (i = 0; i < length; i++) {
            if (input[i] == ' ') spaceCount++;
        }

        newLength = length + (spaceCount * 2);
        char[] output = new char[newLength];
        for (i = length - 1; i >= 0; i--) {
            if (input[i] == ' ') {
                output[newLength - 1] = '0';
                output[newLength - 2] = '2';
                output[newLength - 3] = '%';
                newLength -= 3;
            } else {
                output[newLength - 1] = input[i];
                newLength -= 1;
            }
        }
        return output;
    }

}
