package com.we.tournament.backend.challenge;

public class PalindromeChallenge {
    public static boolean isPalindrome(String input) {
        String clean = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return new StringBuilder(clean).reverse().toString().equals(clean);
    }
}
