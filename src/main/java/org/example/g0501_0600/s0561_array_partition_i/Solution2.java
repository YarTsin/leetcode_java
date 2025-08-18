package org.example.g0501_0600.s0561_array_partition_i;

/**
 * Альтернативное решение - Решение с подсчетом (Counting Sort)
 * Для небольших диапазонов значений можно использовать сортировку подсчетом:
 * Подходит когда диапазон значений ограничен
 * Временная сложность: O(n + k), где k - диапазон значений
 * Пространственная сложность: O(k)
 */
class Solution2 {
    public int arrayPairSum(int[] nums) {
        // Определяем диапазон значений
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Создаем массив для подсчета
        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }

        int sum = 0;
        boolean odd = true; // Флаг для выбора каждого второго элемента

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                if (odd) {
                    sum += i + min;
                }
                odd = !odd;
                count[i]--;
            }
        }

        return sum;
    }
}
