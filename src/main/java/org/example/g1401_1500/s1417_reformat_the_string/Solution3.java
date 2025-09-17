package org.example.g1401_1500.s1417_reformat_the_string;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с сортировкой и двумя указателями
 * Объяснение подхода:
 * Разделение и проверка: Аналогично первому решению
 * Нормализация: Гарантируем, что начинаем с большей группы
 * Чередование: Поочередно добавляем символы из обеих групп
 * Добавление остатка: Добавляем последний символ, если группы разного размера
 *
 * Временная сложность: O(n)
 * Пространственная сложность: O(n)
 *
 */
class Solution3 {
    public String reformat(String s) {
        // Разделяем символы
        List<Character> letters = new ArrayList<>();
        List<Character> digits = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.add(c);
            } else {
                digits.add(c);
            }
        }

        int lettersSize = letters.size();
        int digitsSize = digits.size();

        if (Math.abs(lettersSize - digitsSize) > 1) {
            return "";
        }

        // Убеждаемся, что больше элементов идет первым
        if (lettersSize < digitsSize) {
            // Меняем местами, чтобы всегда начинать с большей группы
            List<Character> temp = letters;
            letters = digits;
            digits = temp;
            int tempSize = lettersSize;
            lettersSize = digitsSize;
            digitsSize = tempSize;
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        // Чередуем символы
        while (i < digitsSize) {
            result.append(letters.get(i));
            result.append(digits.get(i));
            i++;
        }

        // Добавляем последний символ, если необходимо
        if (i < lettersSize) {
            result.append(letters.get(i));
        }

        return result.toString();
    }
}
