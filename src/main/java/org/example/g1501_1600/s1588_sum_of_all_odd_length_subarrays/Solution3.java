package org.example.g1501_1600.s1588_sum_of_all_odd_length_subarrays;

/**
 * Использование префиксных сумм
 */
class Solution3 {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n + 1];

        // Создаем массив префиксных сумм
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        int totalSum = 0;

        // Перебираем все подмассивы нечетной длины
        for (int start = 0; start < n; start++) {
            for (int length = 1; start + length <= n; length += 2) {
                int end = start + length - 1;
                totalSum += prefixSum[end + 1] - prefixSum[start];
            }
        }

        return totalSum;
    }
}
