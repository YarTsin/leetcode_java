package org.example.g0201_0300.s0283_move_zeroes;

// #Easy #Top_100_Liked_Questions #Array #Two_Pointers #LeetCode_75_Two_Pointers

/**
 * 283. Move Zeroes
 * Дан целочисленный массив nums. Необходимо переместить все нули
 * в конец массива, сохраняя относительный порядок ненулевых элементов.
 * Операция должна быть выполнена на месте (in-place),
 * без создания копии массива.
 *
 * Пример 1
 * Вход: [0,1,0,3,12]
 * Выход: [1,3,12,0,0]
 * Объяснение: Ненулевые элементы сохраняют порядок, нули перемещены в конец
 *
 * Пример 2
 * Вход: [0]
 * Выход: [0]
 * Объяснение: Массив из одного нуля остается без изменений
 *
 * Ограничения:
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 *  Решение с указателем в 2 прохода
 *
 *  2 по скорости решение = 1 ms
 *
 */
class Solution {
    public void moveZeroes(int[] nums) {
        // Указатель для отслеживания позиции следующего ненулевого элемента
        int nonZeroPointer = 0;

        // Первый проход: перемещаем все ненулевые элементы в начало
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            // Если текущий элемент не ноль, перемещаем его на позицию nonZeroPointer
            if (nums[currentIndex] != 0) {
                nums[nonZeroPointer] = nums[currentIndex];
                nonZeroPointer++;
            }
        }

        // Второй проход: заполняем оставшуюся часть массива нулями
        for (int zeroIndex = nonZeroPointer; zeroIndex < nums.length; zeroIndex++) {
            nums[zeroIndex] = 0;
        }
    }
}
