package org.example.g1701_1800.s1796_second_largest_digit_in_a_string;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Использование PriorityQueue
 */
class Solution5 {
    public int secondHighest(String s) {
        Set<Integer> uniqueDigits = new HashSet<>();

        // Собираем уникальные цифры
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                uniqueDigits.add(c - '0');
            }
        }

        // Если уникальных цифр меньше 2, возвращаем -1
        if (uniqueDigits.size() < 2) {
            return -1;
        }

        // Создаем максимальную кучу из уникальных цифр
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(uniqueDigits);

        // Удаляем наибольший элемент
        maxHeap.poll();

        // Возвращаем следующий наибольший (второй по величине)
        return maxHeap.poll();
    }
}
