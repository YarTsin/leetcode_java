package org.example.g0401_0500.s0500_keyboard_row;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Решение с маппингом символов на ряды
 * Объяснение:
 * Маппинг символов: Создаем карту от символа к номеру ряда
 * Проверка по первому символу: Определяем целевой ряд по первому символу слова
 * Верификация: Проверяем, что все остальные символы принадлежат тому же ряду
 */
class Solution2 {
    public String[] findWords(String[] words) {
        // Создаем мапу: символ → номер ряда
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> charToRow = new HashMap<>();

        for (int i = 0; i < rows.length; i++) {
            for (char c : rows[i].toCharArray()) {
                charToRow.put(c, i);
                charToRow.put(Character.toUpperCase(c), i);
            }
        }

        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (word.isEmpty()) continue;

            // Определяем ряд первого символа
            int targetRow = charToRow.get(Character.toLowerCase(word.charAt(0)));
            boolean valid = true;

            // Проверяем, что все символы принадлежат тому же ряду
            for (int i = 1; i < word.length(); i++) {
                char c = Character.toLowerCase(word.charAt(i));
                if (charToRow.get(c) != targetRow) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}
