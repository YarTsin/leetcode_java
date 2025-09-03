package org.example.g0401_0500.s0500_keyboard_row;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с использованием битовых масок
 * Объяснение:
 * Битовые маски: Представляем каждый ряд как битовую маску
 * Проверка включения: Если слово полностью содержится в одной из масок
 * Эффективно по памяти: Использует только 3 integers
 */
class Solution3 {
    public String[] findWords(String[] words) {
        // Представляем ряды как битовые маски (только для строчных букв)
        int row1 = getBitMask("qwertyuiop");
        int row2 = getBitMask("asdfghjkl");
        int row3 = getBitMask("zxcvbnm");

        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (isInOneRow(word.toLowerCase(), row1, row2, row3)) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }

    private int getBitMask(String s) {
        int mask = 0;
        for (char c : s.toCharArray()) {
            // Устанавливаем бит для каждой буквы (a=0, b=1, ..., z=25)
            mask |= (1 << (c - 'a'));
        }
        return mask;
    }

    private boolean isInOneRow(String word, int row1, int row2, int row3) {
        int wordMask = getBitMask(word);

        // Проверяем, что все биты слова содержатся в одной из масок рядов
        return (wordMask & ~row1) == 0 ||
                (wordMask & ~row2) == 0 ||
                (wordMask & ~row3) == 0;
    }
}