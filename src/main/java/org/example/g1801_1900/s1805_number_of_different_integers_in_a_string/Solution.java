package org.example.g1801_1900.s1805_number_of_different_integers_in_a_string;

// #Easy #String #Hash_Table

import java.util.HashSet;
import java.util.Set;

/**
 * 1805. Number of Different Integers in a String
 *
 * Дана строка word, которая состоит из цифр и строчных английских букв.
 * Нужно заменить каждую букву в строке на пробел, затем разбить
 * строку на числа (игнорируя ведущие нули в числах) и вернуть количество
 * различных целых чисел после выполнения всех замен.
 *
 * Важные моменты:
 * Числа могут иметь ведущие нули, но их нужно игнорировать
 * (например, "01" и "1" считаются одинаковыми числами)
 * Буквы заменяются на пробелы для разделения чисел
 * Нужно вернуть количество уникальных чисел
 *
 * Пример 1
 * Input: word = "a123bc34d8ef34"  * Output: 3
 * Объяснение: Числа: 123, 34, 8, 34. Уникальные: 123, 34, 8 → 3 различных числа
 *
 * Пример 2
 * Input: word = "leet1234code234" * Output: 2
 * Объяснение: Числа: 1234, 234. Уникальные: 1234, 234 → 2 различных числа
 *
 * Решение:  Однопроходный алгоритм с использованием Set для хранения уникальных чисел.
 * (это жадный алгоритм?) 2-е решение - 2 ms
 */
class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> uniqueNumbers = new HashSet<>();
        int n = word.length();
        int i = 0;

        while (i < n) {
            // Пропускаем все буквы
            if (Character.isLetter(word.charAt(i))) {
                i++;
                continue;
            }

            // Нашли цифру - начинаем извлекать число
            int j = i;
            // Пропускаем ведущие нули
            while (j < n && word.charAt(j) == '0') {
                j++;
            }

            // Извлекаем все цифры подряд
            int start = j;
            while (j < n && Character.isDigit(word.charAt(j))) {
                j++;
            }

            // Если после ведущих нулей не было цифр (случай "000")
            if (start == j) {
                // Это означает, что было только нули - добавляем "0"
                uniqueNumbers.add("0");
            } else {
                // Добавляем число без ведущих нулей
                uniqueNumbers.add(word.substring(start, j));
            }

            i = j; // Перемещаем указатель
        }

        return uniqueNumbers.size();
    }
}
