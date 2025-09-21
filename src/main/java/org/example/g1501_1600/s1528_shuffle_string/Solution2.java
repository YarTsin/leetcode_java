package org.example.g1501_1600.s1528_shuffle_string;

/**
 * Альтернативное решение (Использование StringBuilder)
 * Аналогичное по эффективности решение, но с использованием StringBuilder.
 * Подход:
 * Создаем StringBuilder с заранее заданной длиной
 * Заполняем его пробелами или нулевыми символами
 * Заменяем символы на нужных позициях
 *
 */
class Solution2 {
    public String restoreString(String s, int[] indices) {
        int n = s.length();
        // Создаем StringBuilder и заполняем его пробелами
        StringBuilder result = new StringBuilder();
        result.setLength(n);

        // Проходим по всем индексам
        for (int i = 0; i < n; i++) {
            // Устанавливаем символ на нужную позицию
            result.setCharAt(indices[i], s.charAt(i));
        }

        return result.toString();
    }
}