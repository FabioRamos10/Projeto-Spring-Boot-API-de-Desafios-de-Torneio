package com.we.tournament.backend.challenge;

import com.we.tournament.backend.model.Player;
import com.we.tournament.backend.model.Tournament;
import com.we.tournament.backend.service.ChallengeScoreService;
import org.springframework.stereotype.Service;

@Service
public class ChallengeService {

    private final ChallengeScoreService scoreService;

    public ChallengeService(ChallengeScoreService scoreService) {
        this.scoreService = scoreService;
    }

    public String execute(String type, String input, Player player, Tournament tournament) {
        int score = 0;
        String result = "";

        switch (type.toLowerCase()) {
            case "fibonacci":
                int n = Integer.parseInt(input);
                int fib = FibonacciChallenge.calculate(n);
                result = String.valueOf(fib);
                score = 10;
                break;

            case "palindrome":
                boolean isPal = PalindromeChallenge.isPalindrome(input);
                result = String.valueOf(isPal);
                score = isPal ? 5 : 0;
                break;

            case "sorting":
                int[] numbers = parseArray(input);
                int[] sorted = SortingChallenge.sort(numbers);
                result = SortingChallenge.arrayToString(sorted);
                score = 7;
                break;

            default:
                throw new IllegalArgumentException("Tipo de desafio inválido: " + type);
        }

        scoreService.register(player, tournament, type.toLowerCase(), score);
        return result + "|" + score;
    }

    private int[] parseArray(String input) {
        String[] parts = input.replaceAll("[\\[\\] ]", "").split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        return arr;
    }
}
