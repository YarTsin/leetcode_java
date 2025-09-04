package org.example.g0501_0600.s0557_reverse_words_in_a_string_iii;

/**
 * Решение с использованием StringBuilder
 *
 * Подход
 * Разбиваем строку на слова, переворачиваем каждое слово и собираем обратно.
 * Преимущества:
 * Более читаемый код
 * Использует встроенные методы
 *
 * Недостатки:
 * Создает больше временных объектов
 * Менее эффективно по памяти
 *
 */
class Solution2 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            // Переворачиваем текущее слово
            String reversedWord = new StringBuilder(words[i]).reverse().toString();
            result.append(reversedWord);

            // Добавляем пробел после слова (кроме последнего)
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}