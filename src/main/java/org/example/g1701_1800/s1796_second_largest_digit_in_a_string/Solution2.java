package org.example.g1701_1800.s1796_second_largest_digit_in_a_string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Использование множества (Set) для уникальных цифр
 * Это решение собирает все уникальные цифры в Set, затем преобразует в массив и сортирует.
 */
class Solution2 {
    public int secondHighest(String s) {
        Set<Integer> digits = new HashSet<>();

        // Собираем все цифры из строки
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.add(c - '0'); // Добавляем числовое значение
            }
        }

        // Если уникальных цифр меньше 2, второй по величине нет
        if (digits.size() < 2) {
            return -1;
        }

        // Преобразуем Set в массив и сортируем
        Integer[] uniqueDigits = digits.toArray(new Integer[0]);
        Arrays.sort(uniqueDigits);

        // Вторая по величине цифра - предпоследний элемент в отсортированном массиве
        return uniqueDigits[uniqueDigits.length - 2];
    }
}
