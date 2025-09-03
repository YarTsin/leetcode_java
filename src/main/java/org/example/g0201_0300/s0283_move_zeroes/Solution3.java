package org.example.g0201_0300.s0283_move_zeroes;

/**
 * Решение с использованием дополнительного массива (не in-place)
 * нарушает условие
 */
class Solution3 {
    public void moveZeroes(int[] nums) {
        // Создаем временный массив для ненулевых элементов
        int[] tempArray = new int[nums.length];
        int tempIndex = 0;

        // Копируем все ненулевые элементы во временный массив
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                tempArray[tempIndex] = nums[i];
                tempIndex++;
            }
        }

        // Копируем обратно в исходный массив (ненулевые + нули)
        for (int i = 0; i < nums.length; i++) {
            if (i < tempIndex) {
                nums[i] = tempArray[i];
            } else {
                nums[i] = 0;
            }
        }
    }
}

