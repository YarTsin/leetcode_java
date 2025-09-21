package org.example.g1501_1600.s1534_count_good_triplets;

/**
 * Полный перебор (Brute Force) - Базовый вариант
 */
class Solution2 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int n = arr.length;

        // Полный перебор всех возможных троек
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Проверяем все три условия
                    boolean condition1 = Math.abs(arr[i] - arr[j]) <= a;
                    boolean condition2 = Math.abs(arr[j] - arr[k]) <= b;
                    boolean condition3 = Math.abs(arr[i] - arr[k]) <= c;

                    // Если все условия выполняются, увеличиваем счетчик
                    if (condition1 && condition2 && condition3) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}