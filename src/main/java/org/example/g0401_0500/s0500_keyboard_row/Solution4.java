package org.example.g0401_0500.s0500_keyboard_row;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с регулярными выражениями
 *
 * Объяснение:
 * Регулярное выражение: Проверяет, состоит ли слово только из символов одного ряда
 * Простота: Очень компактное решение
 * Читаемость: Легко понять
 *
 * Недостатки:
 * Может быть медленнее для больших слов (почему?)
 * Создает объекты Pattern внутри
 *
 */
class Solution4 {
    public String[] findWords(String[] words) {
        // Регулярные выражения для каждого ряда
        String pattern = "^[qwertyuiopQWERTYUIOP]*$|^[asdfghjklASDFGHJKL]*$|^[zxcvbnmZXCVBNM]*$";

        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (word.matches(pattern)) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}
