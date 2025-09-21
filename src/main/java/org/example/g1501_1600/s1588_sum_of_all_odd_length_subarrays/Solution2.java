package org.example.g1501_1600.s1588_sum_of_all_odd_length_subarrays;

/**
 *  Полный перебор всех подмассивов
 */
class Solution2 {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int totalSum = 0;

        // Перебираем все возможные начальные индексы
        for (int start = 0; start < n; start++) {
            // Перебираем все возможные длины нечетных подмассивов
            for (int length = 1; start + length <= n; length += 2) {
                // Суммируем элементы текущего подмассива
                for (int i = start; i < start + length; i++) {
                    totalSum += arr[i];
                }
            }
        }

        return totalSum;
    }
}
