package org.example.g0901_1000.s0922_sort_array_by_parity_ii;

/**
 * Альтернативное решение (in-place модификация)
 * Подход: Модификация исходного массива с двумя указателями
 */
class Solution2 {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int oddIndex = 1; // начинаем с первой нечетной позиции

        // Проходим только по четным позициям
        for (int evenIndex = 0; evenIndex < n; evenIndex += 2) {
            // Если на четной позиции нечетное число
            if (nums[evenIndex] % 2 != 0) {
                // Ищем нечетную позицию с четным числом
                while (nums[oddIndex] % 2 != 0) {
                    oddIndex += 2;
                }

                // Меняем местами
                int temp = nums[evenIndex];
                nums[evenIndex] = nums[oddIndex];
                nums[oddIndex] = temp;
            }
        }

        return nums;
    }
}
