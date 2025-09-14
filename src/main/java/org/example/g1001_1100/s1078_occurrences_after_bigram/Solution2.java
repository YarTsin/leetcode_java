package org.example.g1001_1100.s1078_occurrences_after_bigram;

import java.util.ArrayList;
import java.util.List;

/**
 * Подход с использованием указателей (альтернативное решение)
 * Объяснение:
 * Ручной парсинг: Обрабатываем текст посимвольно без использования split()
 * Скользящее окно: Проверяем тройки слов последовательно
 * Экономия памяти: Не создаем массив всех слов
 * Сложность: Время O(n), пространство O(1) дополнительной памяти
 */
class Solution2 {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = text.length();

        while (i < n) {
            // Ищем начало следующего слова
            while (i < n && text.charAt(i) == ' ') i++;
            if (i >= n) break;

            int start1 = i;
            // Ищем конец первого слова
            while (i < n && text.charAt(i) != ' ') i++;
            String word1 = text.substring(start1, i);

            // Пропускаем пробелы
            while (i < n && text.charAt(i) == ' ') i++;
            if (i >= n) break;

            int start2 = i;
            // Ищем конец второго слова
            while (i < n && text.charAt(i) != ' ') i++;
            String word2 = text.substring(start2, i);

            // Пропускаем пробелы
            while (i < n && text.charAt(i) == ' ') i++;
            if (i >= n) break;

            int start3 = i;
            // Ищем конец третьего слова
            while (i < n && text.charAt(i) != ' ') i++;
            String word3 = text.substring(start3, i);

            // Проверяем биграмму
            if (word1.equals(first) && word2.equals(second)) {
                result.add(word3);
            }

            // Возвращаемся на одно слово назад для следующей проверки
            i = start2;
        }

        return result.toArray(new String[0]);
    }
}
