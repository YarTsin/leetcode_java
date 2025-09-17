package org.example.g1401_1500.s1408_string_matching_in_an_array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Решение с использованием хэширования
 * Объяснение подхода:
 * Объединяем все слова в одну строку с разделителем
 * Для каждого слова ищем его первое и второе вхождение в объединенной строке
 * Если найдено второе вхождение, значит слово встречается как минимум дважды (включая само себя)
 * Используем Set для избежания дубликатов
 * Менее надежное решение (может быть false positives)
 */
class Solution3 {
    public List<String> stringMatching(String[] words) {
        Set<String> resultSet = new HashSet<>();
        int n = words.length;

        // Создаем одну большую строку, содержащую все слова, разделенные специальным символом
        String combined = String.join(",", words);

        for (int i = 0; i < n; i++) {
            String currentWord = words[i];

            // Ищем первое вхождение слова в объединенной строке
            int firstIndex = combined.indexOf(currentWord);

            // Ищем второе вхождение, начиная с позиции после первого вхождения
            if (firstIndex != -1) {
                int secondIndex = combined.indexOf(currentWord, firstIndex + 1);

                // Если найдено второе вхождение, значит это слово является подстрокой другого слова
                if (secondIndex != -1) {
                    resultSet.add(currentWord);
                }
            }
        }

        return new ArrayList<>(resultSet);
    }
}
