package org.example.g0601_0700.s0682_baseball_game;

import java.util.ArrayList;
import java.util.List;

/**
 * Альтернативное решение (С использованием списка)
 */
class Solution2 {
    public int calPoints(String[] operations) {
        List<Integer> scores = new ArrayList<>();

        for (String op : operations) {
            int size = scores.size();
            switch (op) {
                case "+":
                    int sum = scores.get(size - 1) + scores.get(size - 2);
                    scores.add(sum);
                    break;
                case "D":
                    int doubleScore = scores.get(size - 1) * 2;
                    scores.add(doubleScore);
                    break;
                case "C":
                    scores.remove(size - 1);
                    break;
                default:
                    scores.add(Integer.parseInt(op));
                    break;
            }
        }

        int total = 0;
        for (int score : scores) {
            total += score;
        }

        return total;
    }
}
