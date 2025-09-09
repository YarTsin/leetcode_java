package org.example.g0801_0900.s0830_positions_of_large_groups;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с использованием группировки символов
 */
class Solution3 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();

        // Группируем последовательные одинаковые символы
        int groupStart = 0;
        char currentChar = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != currentChar) {
                // Завершаем текущую группу
                int groupLength = i - groupStart;
                if (groupLength >= 3) {
                    addGroupToResult(result, groupStart, i - 1);
                }

                // Начинаем новую группу
                groupStart = i;
                currentChar = s.charAt(i);
            }
        }

        // Проверяем последнюю группу
        int finalGroupLength = s.length() - groupStart;
        if (finalGroupLength >= 3) {
            addGroupToResult(result, groupStart, s.length() - 1);
        }

        return result;
    }

    private void addGroupToResult(List<List<Integer>> result, int start, int end) {
        List<Integer> group = new ArrayList<>();
        group.add(start);
        group.add(end);
        result.add(group);
    }
}
