package org.example.g1401_1500.s1470_shuffle_the_array;

/**
 * Решение с двумя указателями
 *
 * Подход:
 * Альтернативный вариант с явным использованием двух указателей для x и y элементов.
 */
class Solution3 {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int xPointer = 0;      // Указатель на x-элементы (первая половина)
        int yPointer = n;      // Указатель на y-элементы (вторая половина)

        for (int i = 0; i < 2 * n; i += 2) {
            result[i] = nums[xPointer++];     // Берем x-элемент
            result[i + 1] = nums[yPointer++]; // Берем y-элемент
        }

        return result;
    }
}
