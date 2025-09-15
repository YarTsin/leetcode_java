package org.example.g1301_1400.s1370_increasing_decreasing_string;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * С использованием сортировки и очереди
 */
class Solution2 {
    public String sortString(String s) {
        // Преобразуем строку в массив символов и сортируем
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        // Создаем очередь из символов
        LinkedList<Character> queue = new LinkedList<>();
        for (char c : chars) {
            queue.add(c);
        }

        StringBuilder result = new StringBuilder();
        boolean ascending = true;

        while (!queue.isEmpty()) {
            if (ascending) {
                // Проход в возрастающем порядке
                char prev = '\0';
                for (int i = 0; i < queue.size(); i++) {
                    if (queue.get(i) > prev) {
                        prev = queue.remove(i);
                        result.append(prev);
                        i--; // Уменьшаем индекс т.к. удалили элемент
                    }
                }
            } else {
                // Проход в убывающем порядке
                char prev = '\0';
                for (int i = queue.size() - 1; i >= 0; i--) {
                    if (queue.get(i) < prev || prev == '\0') {
                        prev = queue.remove(i);
                        result.append(prev);
                    }
                }
            }
            ascending = !ascending;
        }

        return result.toString();
    }
}
