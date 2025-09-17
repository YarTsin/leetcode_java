package org.example.g1401_1500.s1408_string_matching_in_an_array;

// #Easy #String #String_Matching

import java.util.ArrayList;
import java.util.List;

/**
 * 1408. String Matching in an Array
 *
 * Дан массив строк words. Необходимо вернуть все строки из массива,
 * которые являются подстрокой любой другой строки в массиве. Результат можно
 * вернуть в любом порядке.
 * (примеры внизу)
 *
 * Ограничения:
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 30
 * words[i] содержит только строчные английские буквы
 * Все строки в массиве уникальны
 *
 * Решение - Brute Force с оптимизацией
 * Не быстрое решение - 4 ms
 *
 * Временная сложность: O(n² * L), где n - количество слов, L - средняя длина слова
 * Пространственная сложность: O(1) без учета результата
 *
 */
class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        int n = words.length;

        // Проходим по всем словам в массиве
        for (int i = 0; i < n; i++) {
            String currentWord = words[i];

            // Для каждого слова проверяем, является ли оно подстрокой любого другого слова
            for (int j = 0; j < n; j++) {
                // Пропускаем сравнение слова с самим собой
                if (i != j) {
                    String otherWord = words[j];

                    // Если текущее слово является подстрокой другого слова
                    if (otherWord.contains(currentWord)) {
                        result.add(currentWord);
                        break; // Прерываем внутренний цикл, так как нашли хотя бы одно вхождение
                    }
                }
            }
        }

        return result;
    }
}
/*
Пример 1
Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Объяснение:
- "as" является подстрокой "mass"
- "hero" является подстрокой "superhero"

Пример 2
Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Объяснение:
- "et" является подстрокой "leetcode"
- "code" является подстрокой "leetcode"

 */