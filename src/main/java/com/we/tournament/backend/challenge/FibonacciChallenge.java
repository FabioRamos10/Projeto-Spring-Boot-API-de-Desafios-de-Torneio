package com.we.tournament.backend.challenge;

public class FibonacciChallenge {
    public static int calculate(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, res = 1;
        for (int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
