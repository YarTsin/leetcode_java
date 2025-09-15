package org.example.g1301_1400.s1365_how_many_numbers_are_smaller_than_the_current_number;

/**
 * Подсчет с использованием частотного массива
 */
class Solution2 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // Находим максимальное значение в массиве
        int max = 0;
        for (int num : nums) {
            if (num > max) max = num;
        }

        // Создаем массив частот
        int[] freq = new int[max + 1];
        for (int num : nums) {
            freq[num]++;
        }

        // Создаем массив префиксных сумм (количество чисел <= i)
        int[] prefixSum = new int[max + 1];
        prefixSum[0] = freq[0];
        for (int i = 1; i <= max; i++) {
            prefixSum[i] = prefixSum[i - 1] + freq[i];
        }

        // Создаем результат
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                result[i] = 0;
            } else {
                // Количество чисел меньше num = prefixSum[num - 1]
                result[i] = prefixSum[num - 1];
            }
        }

        return result;
    }
}
