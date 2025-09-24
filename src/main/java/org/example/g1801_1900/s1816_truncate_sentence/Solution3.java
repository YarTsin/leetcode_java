package org.example.g1801_1900.s1816_truncate_sentence;

/**
 * Решение с использованием StringBuilder (однопроходное)
 * Подход: Собираем результат посимвольно, отслеживая количество слов.
 */
class Solution3 {
    public String truncateSentence(String s, int k) {
        StringBuilder result = new StringBuilder();
        int wordCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // Если текущий символ - пробел, увеличиваем счетчик слов
            if (currentChar == ' ') {
                wordCount++;
                // Если достигли k слов, выходим из цикла
                if (wordCount == k) {
                    break;
                }
            }

            // Добавляем текущий символ к результату
            result.append(currentChar);
        }

        // Если прошли всю строку и не набрали k слов, возвращаем всю строку
        // Иначе возвращаем собранную строку
        return result.toString();
    }
}