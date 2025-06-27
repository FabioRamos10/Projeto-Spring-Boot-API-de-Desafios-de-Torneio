package com.we.tournament.backend.challenge;

import java.util.Arrays;

public class SortingChallenge {

    public static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static String arrayToString(int[] arr) {
        return Arrays.toString(arr).replaceAll("[\\[\\] ]", "");
    }
}
