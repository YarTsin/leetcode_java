package org.example.g1801_1900.s1816_truncate_sentence;

/**
 * Решение с использованием встроенных функций
 * Подход: Используем метод split() для разделения строки на слова,
 * затем объединяем первые k слов.
 */
class Solution2 {
    public String truncateSentence(String s, int k) {
        // Разделяем строку на слова по пробелам
        String[] words = s.split(" ");

        // Если k больше или равно количеству слов, возвращаем всю строку
        if (k >= words.length) {
            return s;
        }

        // Собираем первые k слов обратно в строку
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (i > 0) {
                result.append(" ");
            }
            result.append(words[i]);
        }

        return result.toString();
    }
}