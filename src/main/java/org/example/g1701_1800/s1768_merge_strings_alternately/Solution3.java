package org.example.g1701_1800.s1768_merge_strings_alternately;

/**
 * Решение - с рекурсией
 * Рекурсивная функция принимает два строковых аргумента и индекс.
 * Базовый случай - когда индекс превысил длины обеих строк.
 * Рекурсивно функция собирает результат, добавляя текущие символы
 * (если они есть) к результату вызова самой себя для следующего индекса.
 */
class Solution3 {
    public String mergeAlternately(String word1, String word2) {
        // Запускаем рекурсивный процесс с начальным индексом 0
        return mergeRecursively(word1, word2, 0);
    }

    private String mergeRecursively(String word1, String word2, int currentIndex) {
        // Базовый случай рекурсии: если индекс превысил длину обеих строк, возвращаем пустую строку.
        if (currentIndex >= word1.length() && currentIndex >= word2.length()) {
            return "";
        }

        // Создаем StringBuilder для формирования результата на текущем шаге рекурсии
        StringBuilder currentStepResult = new StringBuilder();

        // Если в word1 еще есть символ по текущему индексу, добавляем его
        if (currentIndex < word1.length()) {
            currentStepResult.append(word1.charAt(currentIndex));
        }
        // Если в word2 еще есть символ по текущему индексу, добавляем его
        if (currentIndex < word2.length()) {
            currentStepResult.append(word2.charAt(currentIndex));
        }

        // Рекурсивно вызываем функцию для следующего индекса и добавляем ее результат к текущему
        // Рекурсивный вызов происходит в конце, что делает хвостовую рекурсию (но Java ее не оптимизирует)
        currentStepResult.append(mergeRecursively(word1, word2, currentIndex + 1));

        return currentStepResult.toString();
    }
}