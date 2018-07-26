/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.halim.array.frequency.counter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author ABDELHALIM
 */
public class FrequencyCounter {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] values = new int[queries.length];
        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (String text : strings) {
            if (frequencyMap.containsKey(text)) {
                frequencyMap.replace(text, frequencyMap.get(text), frequencyMap.get(text) + 1);
            } else {
                frequencyMap.put(text, 1);
            }
        }
        int index = 0;
        for (String query : queries) {
            if (frequencyMap.containsKey(query)) {
                values[index] = frequencyMap.get(query);
            } else {
                values[index] = 0;
            }
            index++;
        }

        return values;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

        //bufferedWriter.newLine();
        //bufferedWriter.close();
        scanner.close();
    }
}
