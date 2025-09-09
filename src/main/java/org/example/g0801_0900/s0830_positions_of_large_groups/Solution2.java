package org.example.g0801_0900.s0830_positions_of_large_groups;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с использованием двух указателей
 */
class Solution2 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int stringLength = s.length();

        // Используем два указателя для определения границ групп
        int leftPointer = 0;

        while (leftPointer < stringLength) {
            int rightPointer = leftPointer;

            // Расширяем правую границу, пока символы одинаковы
            while (rightPointer < stringLength && s.charAt(rightPointer) == s.charAt(leftPointer)) {
                rightPointer++;
            }

            // Проверяем длину группы
            int currentGroupLength = rightPointer - leftPointer;
            if (currentGroupLength >= 3) {
                List<Integer> position = new ArrayList<>();
                position.add(leftPointer);
                position.add(rightPointer - 1); // -1 потому что rightPointer указывает на следующий символ
                result.add(position);
            }

            // Перемещаем левый указатель на начало следующей группы
            leftPointer = rightPointer;
        }

        return result;
    }
}
