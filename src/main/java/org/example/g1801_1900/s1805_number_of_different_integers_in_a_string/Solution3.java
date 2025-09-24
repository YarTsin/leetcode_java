package org.example.g1801_1900.s1805_number_of_different_integers_in_a_string;

import java.util.HashSet;
import java.util.Set;

/**
 * Используем два указателя для выделения подстрок с числами.
 */
class Solution3 {
    public int numDifferentIntegers(String word) {
        Set<String> uniqueNumbers = new HashSet<>();
        int n = word.length();
        int left = 0;

        while (left < n) {
            // Ищем начало числа (первую цифру)
            while (left < n && Character.isLetter(word.charAt(left))) {
                left++;
            }

            if (left >= n) break;

            // Нашли начало числа, ищем конец
            int right = left;
            while (right < n && Character.isDigit(word.charAt(right))) {
                right++;
            }

            // Извлекаем подстроку с числом
            String numberStr = word.substring(left, right);

            // Убираем ведущие нули
            int start = 0;
            while (start < numberStr.length() - 1 && numberStr.charAt(start) == '0') {
                start++;
            }

            uniqueNumbers.add(numberStr.substring(start));

            left = right; // Перемещаем указатель
        }

        return uniqueNumbers.size();
    }
}
