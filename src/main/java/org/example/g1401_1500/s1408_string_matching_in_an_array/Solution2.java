package org.example.g1401_1500.s1408_string_matching_in_an_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Альтернативное решение (с сортировкой по длине)
 *
 * Объяснение подхода:
 * Сначала сортируем слова по длине (от коротких к длинным)
 * Короткое слово может быть подстрокой длинного, но не наоборот
 * Это позволяет сократить количество проверок
 * Временная сложность: O(n log n + n² * L) - добавлена стоимость сортировки
 * Пространственная сложность: O(log n) для сортировки (пространство стека вызовов)
 *
 */
class Solution2 {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        // Сортируем слова по длине (от коротких к длинным)
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;

        // Проходим по всем словам, начиная с самых коротких
        for (int i = 0; i < n; i++) {
            String currentWord = words[i];

            // Проверяем только более длинные слова (j > i)
            for (int j = i + 1; j < n; j++) {
                String longerWord = words[j];

                // Если текущее слово является подстрокой более длинного слова
                if (longerWord.contains(currentWord)) {
                    result.add(currentWord);
                    break; // Прерываем цикл, так как нашли вхождение
                }
            }
        }

        return result;
    }
}
