package org.example.g1701_1800.s1742_maximum_number_of_balls_in_a_box;

/**
 * Решение с оптимизацией для последовательных чисел
 */
class Solution4 {
    public int countBalls(int lowLimit, int highLimit) {
        int[] count = new int[46];
        int max = 0;

        // Начинаем с первого числа
        int current = lowLimit;
        int currentSum = digitSum(current);
        count[currentSum]++;
        max = Math.max(max, count[currentSum]);

        // Обрабатываем остальные числа, используя тот факт, что суммы цифр меняются предсказуемо
        for (int i = lowLimit + 1; i <= highLimit; i++) {
            // Сумма цифр увеличивается на 1, но при переходе через 9 нужно корректировать
            currentSum = nextDigitSum(i, currentSum);
            count[currentSum]++;
            if (count[currentSum] > max) {
                max = count[currentSum];
            }
        }

        return max;
    }

    private int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    private int nextDigitSum(int n, int prevSum) {
        // Если число заканчивается не на 9, то сумма увеличивается на 1
        // Если заканчивается на 9, нужно вычислить заново
        if (n % 10 != 0) {
            return prevSum + 1;
        } else {
            return digitSum(n);
        }
    }
}
