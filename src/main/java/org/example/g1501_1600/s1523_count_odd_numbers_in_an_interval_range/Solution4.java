package org.example.g1501_1600.s1523_count_odd_numbers_in_an_interval_range;

/**
 *  Наивное решение (Перебор)
 *  Это решение имеет временную сложность O(n)
 *  и должно использоваться только для понимания задачи.
 */
class Solution4 {
    public int countOdds(int low, int high) {
        int count = 0;

        // Перебираем все числа от low до high включительно
        for (int i = low; i <= high; i++) {
            // Проверяем, является ли число нечетным
            if (i % 2 != 0) {
                count++;
            }
        }

        return count;
    }
}
