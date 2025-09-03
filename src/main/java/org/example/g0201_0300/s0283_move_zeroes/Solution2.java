package org.example.g0201_0300.s0283_move_zeroes;

/**
 * Альтернативное решение с одним проходом (Two Pointers)
 */
class Solution2 {
    public void moveZeroes(int[] nums) {
        // Указатель для отслеживания позиции следующего ненулевого элемента
        int nonZeroPointer = 0;

        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            // Если текущий элемент не ноль, меняем местами с элементом на nonZeroPointer
            if (nums[currentIndex] != 0) {
                // Меняем местами текущий элемент и элемент на позиции nonZeroPointer
                int temp = nums[nonZeroPointer];
                nums[nonZeroPointer] = nums[currentIndex];
                nums[currentIndex] = temp;

                nonZeroPointer++;
            }
        }
    }
}