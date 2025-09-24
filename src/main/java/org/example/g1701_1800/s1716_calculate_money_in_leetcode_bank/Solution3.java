package org.example.g1701_1800.s1716_calculate_money_in_leetcode_bank;

/**
 * Итеративное решение
 * Подход:
 * Последовательно вычисляем сумму для каждого дня. Менее эффективно,
 * но проще для понимания.
 *
 * Сложность:
 * Время: O(n) - линейное время
 * Память: O(1) - не используем дополнительную память
 */
class Solution3 {
    public int totalMoney(int n) {
        int total = 0;
        int currentWeek = 0;
        int currentDayInWeek = 0;

        for (int day = 1; day <= n; day++) {
            currentDayInWeek++;

            if (currentDayInWeek > 7) {
                currentWeek++;
                currentDayInWeek = 1;
            }

            total += currentWeek + currentDayInWeek;
        }

        return total;
    }
}
