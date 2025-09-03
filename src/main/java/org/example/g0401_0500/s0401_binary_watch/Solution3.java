package org.example.g0401_0500.s0401_binary_watch;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с использованием рекурсии/backtracking
 */
class Solution3 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        // Массивы возможных значений для часов и минут
        int[] hours = {1, 2, 4, 8};
        int[] minutes = {1, 2, 4, 8, 16, 32};

        // Перебираем все возможные комбинации количества светодиодов
        for (int i = 0; i <= turnedOn; i++) {
            // i светодиодов для часов, turnedOn - i для минут
            List<Integer> hourList = generateValues(hours, i, 11);
            List<Integer> minuteList = generateValues(minutes, turnedOn - i, 59);

            for (int h : hourList) {
                for (int m : minuteList) {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }

        return result;
    }

    private List<Integer> generateValues(int[] nums, int count, int max) {
        List<Integer> result = new ArrayList<>();
        generateCombinations(nums, count, 0, 0, result, max);
        return result;
    }

    private void generateCombinations(int[] nums, int count, int pos, int sum, List<Integer> result, int max) {
        if (count == 0) {
            if (sum <= max) {
                result.add(sum);
            }
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            generateCombinations(nums, count - 1, i + 1, sum + nums[i], result, max);
        }
    }
}
