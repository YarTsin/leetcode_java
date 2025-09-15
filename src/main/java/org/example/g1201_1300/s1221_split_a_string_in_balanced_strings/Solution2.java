package org.example.g1201_1300.s1221_split_a_string_in_balanced_strings;

/**
 * Альтернативное решение - с явным подсчетом
 */
class Solution2 {
    public int balancedStringSplit(String s) {
        int rCount = 0; // Счетчик символов 'R'
        int lCount = 0; // Счетчик символов 'L'
        int result = 0; // Результат - количество сбалансированных подстрок

        for (char c : s.toCharArray()) {
            if (c == 'R') {
                rCount++;
            } else {
                lCount++;
            }

            // Когда количество 'R' и 'L' равно, нашли сбалансированную подстроку
            if (rCount == lCount) {
                result++;
                // Можно сбросить счетчики, но это не обязательно
                // так как мы продолжаем считать для следующей подстроки
            }
        }

        return result;
    }
}
