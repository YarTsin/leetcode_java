package org.example.g0301_0400.s0389_find_the_difference;

/**
 *  Решение с использованием суммы символов
 */
class Solution3 {
    public char findTheDifference(String s, String t) {
        int sum = 0;

        // Суммируем коды символов t
        for (char c : t.toCharArray()) {
            sum += c;
        }

        // Вычитаем коды символов s
        for (char c : s.toCharArray()) {
            sum -= c;
        }

        // Остаток - код добавленного символа
        return (char) sum;
    }
}
