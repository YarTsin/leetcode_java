package org.example.g1801_1900.s1816_truncate_sentence;

/**
 * Решение с использованием двух указателей
 * Подход: Используем два указателя для определения границ слов.
 */
class Solution4 {
    public String truncateSentence(String s, int k) {
        int wordCount = 0;
        int endIndex = s.length();

        for (int i = 0; i < s.length(); i++) {
            // Находим начало слова (после пробела или начало строки)
            if (i == 0 || s.charAt(i - 1) == ' ') {
                wordCount++;

                // Если достигли k слов, запоминаем конец
                if (wordCount == k) {
                    // Ищем конец текущего слова (следующий пробел или конец строки)
                    endIndex = i;
                    while (endIndex < s.length() && s.charAt(endIndex) != ' ') {
                        endIndex++;
                    }
                    break;
                }
            }
        }

        return s.substring(0, endIndex);
    }
}
