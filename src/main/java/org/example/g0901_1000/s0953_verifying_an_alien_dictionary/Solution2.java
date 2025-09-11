package org.example.g0901_1000.s0953_verifying_an_alien_dictionary;

import java.util.HashMap;
import java.util.Map;

/**
 * Решение с использованием HashMap (менее эффективное по памяти)
 * Подход: Использование HashMap вместо массива для хранения порядка символов.
 * Недостатки этого решения:
 * HashMap использует больше памяти, чем массив
 * Медленнее из-за overhead HashMap операций
 * Более сложная логика с флагом foundDifference
 */
class Solution2 {
    public boolean isAlienSorted(String[] words, String order) {
        // Создаем HashMap для хранения порядка символов
        Map<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String current = words[i];
            String next = words[i + 1];

            int minLength = Math.min(current.length(), next.length());
            boolean foundDifference = false;

            for (int j = 0; j < minLength; j++) {
                char char1 = current.charAt(j);
                char char2 = next.charAt(j);

                if (char1 != char2) {
                    if (orderMap.get(char1) > orderMap.get(char2)) {
                        return false;
                    }
                    foundDifference = true;
                    break;
                }
            }

            // Если не нашли различий в символах, проверяем длину
            if (!foundDifference && current.length() > next.length()) {
                return false;
            }
        }

        return true;
    }
}
