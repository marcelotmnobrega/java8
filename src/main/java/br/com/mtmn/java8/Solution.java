package br.com.mtmn.java8;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the findSuffix function below.
     */
    static int findSuffix(String[] collections, String queryString) {
        /*
         * Write your code here.
         */
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < collections.length; i++) {
            String key = collections[i];
            if (hm.containsKey(key)) {
                hm.put(key, hm.get(key) + 1);
            } else {
                hm.put(key, 1);
            }
        }
        return hm.containsKey(queryString) ? hm.get(queryString) : 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        String[] strings = new String[stringsCount];

        for (int stringsItr = 0; stringsItr < stringsCount; stringsItr++) {
            String stringsItem = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
            strings[stringsItr] = stringsItem;
        }

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int qItr = 0; qItr < q; qItr++) {
            String queryString = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            int res = findSuffix(strings, queryString);

            bufferedWriter.write(String.valueOf(res));


            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

