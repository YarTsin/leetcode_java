package org.example.g1701_1800.s1716_calculate_money_in_leetcode_bank;

/**
 * Упрощенное математическое решение
 * Подход:
 * Более простая математическая формула без использования сложных вычислений.
 */
class Solution2 {
    public int totalMoney(int n) {
        int fullWeeks = n / 7;
        int remainingDays = n % 7;

        // Сумма за полные недели
        int weekSum = 28; // сумма первой недели
        int fullWeeksSum = fullWeeks * weekSum + 7 * (fullWeeks * (fullWeeks - 1)) / 2;

        // Сумма за оставшиеся дни
        int start = fullWeeks + 1;
        int remainingDaysSum = (2 * start + (remainingDays - 1)) * remainingDays / 2;

        return fullWeeksSum + remainingDaysSum;
    }
}
