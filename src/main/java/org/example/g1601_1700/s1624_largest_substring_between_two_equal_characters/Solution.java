package org.example.g1601_1700.s1624_largest_substring_between_two_equal_characters;

// #Easy #String #HasMap

import java.util.HashMap;
import java.util.Map;

/**
 * 1624. Largest Substring Between Two Equal Characters
 * Дана строка s. Нужно найти самую длинную подстроку, которая находится
 * между двумя одинаковыми символами в строке, и вернуть ее длину. Если такой
 * подстроки не существует, вернуть -1.
 *
 * Важные уточнения:
 * Под "подстрокой между двумя одинаковыми символами" понимается расстояние
 * между первым и последним вхождением одного и того же символа
 * Нужно найти максимальную длину такой подстроки для всех символов в строке
 * Длина подстрыки считается как количество символов между двумя одинаковыми
 * символами (не включая сами эти символы)
 *
 * Пример 1
 * Input: s = "aa"  * Output: 0
 * Объяснение: Два символа 'a', между ними 0 символов
 *
 * Пример 2
 * Input: s = "abca"  * Output: 2
 * Объяснение: Между первым 'a' (индекс 0) и последним 'a' (индекс 3)
 * находится подстрока "bc" длиной 2
 *
 * Решение - использовать HashMap - не самое быстрое - 2 ms
 *
 * Сложность: O(n) по времени, O(1) по памяти (так как алфавит ограничен)
 *
 */
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        // Мапа для хранения первого вхождения каждого символа
        Map<Character, Integer> firstOccurrence = new HashMap<>();
        int maxLength = -1;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (firstOccurrence.containsKey(currentChar)) {
                // Вычисляем длину подстроки между первым и текущим вхождением
                int currentLength = i - firstOccurrence.get(currentChar) - 1;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                // Сохраняем первое вхождение символа
                firstOccurrence.put(currentChar, i);
            }
        }

        return maxLength;
    }
}