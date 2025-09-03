package org.example.g0301_0400.s0387_first_unique_character_in_a_string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Альтернативное решение с LinkedHashMap
 */
class Solution2 {
    public int firstUniqChar(String s) {
        // Используем LinkedHashMap для сохранения порядка вставки
        Map<Character, Integer> charCount = new LinkedHashMap<>();

        // Подсчитываем частоту символов
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Находим первый символ с частотой 1
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                // Возвращаем индекс первого вхождения этого символа
                return s.indexOf(entry.getKey());
            }
        }

        return -1;
    }
}
