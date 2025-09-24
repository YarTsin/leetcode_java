package org.example.g1701_1800.s1742_maximum_number_of_balls_in_a_box;

/**
 * Решение с оптимизированным вычислением суммы цифр
 */
class Solution2 {
    public int countBalls(int lowLimit, int highLimit) {
        int[] boxes = new int[46];
        int maxCount = 0;

        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            int n = i;

            // Вычисляем сумму цифр
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }

            boxes[sum]++;
            // Сразу обновляем максимум
            if (boxes[sum] > maxCount) {
                maxCount = boxes[sum];
            }
        }

        return maxCount;
    }
}
