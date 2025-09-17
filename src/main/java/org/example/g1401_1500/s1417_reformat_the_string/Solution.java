package org.example.g1401_1500.s1417_reformat_the_string;

// #Easy #String

import java.util.ArrayList;
import java.util.List;

/**
 * 1417. Reformat The String
 *
 * Дана строка s, содержащая только строчные английские буквы и цифры.
 * Нужно переформатировать строку так, чтобы буквы и цифры чередовались.
 * Если невозможно отформатировать строку согласно этому правилу,
 * вернуть пустую строку.
 *
 * Правила реформатирования:
 * Никакие две буквы не должны быть соседними
 * Никакие две цифры не должны быть соседними
 * (примеры внизу)
 *
 * Решение - разделение и слияние - не быстрое решение - 5 ms
 *
 */
class Solution {
    public String reformat(String s) {
        // Разделяем символы на буквы и цифры
        List<Character> letters = new ArrayList<>();
        List<Character> digits = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.add(c);
            } else {
                digits.add(c);
            }
        }

        // Проверяем возможность чередования
        int lettersCount = letters.size();
        int digitsCount = digits.size();

        // Если разница в количестве больше 1, чередование невозможно
        if (Math.abs(lettersCount - digitsCount) > 1) {
            return "";
        }

        // Определяем, с какой группы начинать (у какой больше элементов)
        boolean startWithLetter = lettersCount >= digitsCount;
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;

        // Поочередно добавляем символы из обеих групп
        while (i < lettersCount || j < digitsCount) {
            if (startWithLetter) {
                if (i < lettersCount) {
                    result.append(letters.get(i++));
                }
                if (j < digitsCount) {
                    result.append(digits.get(j++));
                }
            } else {
                if (j < digitsCount) {
                    result.append(digits.get(j++));
                }
                if (i < lettersCount) {
                    result.append(letters.get(i++));
                }
            }
        }

        return result.toString();
    }
}
/*
Пример 1
Input: s = "a0b1c2"
Output: "0a1b2c"
Объяснение:
Буквы: ['a','b','c'], цифры: ['0','1','2']
Чередование: цифра-буква-цифра-буква-цифра-буква

Пример 2
Input: s = "leetcode"
Output: ""
Объяснение:
Строка содержит только буквы, невозможно чередовать с цифрами

Пример 3
Input: s = "1229857369"
Output: ""
Объяснение:
Строка содержит только цифры, невозможно чередовать с буквами
 */