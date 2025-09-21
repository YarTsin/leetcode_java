package org.example.g1501_1600.s1588_sum_of_all_odd_length_subarrays;

/**
 * Оптимизированный перебор
 */
class Solution4 {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            // Для каждого элемента считаем сумму всех подмассивов нечетной длины,
            // которые заканчиваются на текущем элементе
            for (int j = i; j < n; j++) {
                currentSum += arr[j];
                // Если длина подмассива нечетная, добавляем к общей сумме
                if ((j - i + 1) % 2 == 1) {
                    totalSum += currentSum;
                }
            }
        }

        return totalSum;
    }
}
