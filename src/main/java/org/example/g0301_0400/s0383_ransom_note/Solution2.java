package org.example.g0301_0400.s0383_ransom_note;

import java.util.HashMap;
import java.util.Map;

/**
 * Альтернативное решение с HashMap
 */
class Solution2 {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Создаем HashMap для подсчета частот букв
        Map<Character, Integer> letterCount = new HashMap<>();

        // Подсчитываем частоту каждой буквы в magazine
        for (char c : magazine.toCharArray()) {
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
        }

        // Проверяем, хватает ли букв для составления ransomNote
        for (char c : ransomNote.toCharArray()) {
            // Если буквы нет в magazine или ее недостаточно
            if (!letterCount.containsKey(c) || letterCount.get(c) <= 0) {
                return false;
            }

            // Уменьшаем счетчик для текущей буквы
            letterCount.put(c, letterCount.get(c) - 1);
        }

        return true;
    }
}