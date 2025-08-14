package org.example.g0201_0300.s0202_happy_number;

/**
 * Альтернативное решение
 * Метод быстрого и медленного указателя
 *
 * Этот подход аналогичен обнаружению цикла в связанном списке.
 */
class Solution2 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNextNumber(n);

        // Продолжаем, пока быстрый указатель не станет 1 или не догонит медленный
        while (fast != 1 && slow != fast) {
            slow = getNextNumber(slow);
            fast = getNextNumber(getNextNumber(fast));
        }

        return fast == 1;
    }

    private int getNextNumber(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
