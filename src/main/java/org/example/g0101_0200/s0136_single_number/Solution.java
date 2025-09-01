package org.example.g0101_0200.s0136_single_number;

// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Array #Bit_Manipulation
// #LeetCode_75_Bit_Manipulation #XOR
// #Top_Interview_150_Bit_Manipulation

/**
 * 136. Single Number
 *
 * Условие задачи: Дан непустой массив целых чисел nums,
 * в котором каждый элемент встречается дважды, кроме одного элемента,
 * который встречается ровно один раз.
 * Необходимо найти этот единственный элемент.
 *
 * Требование: Реализовать алгоритм с линейной сложностью времени
 * выполнения (O(n)) и использовать только константную
 * дополнительную память (O(1)).
 *
 * Пример 1
 * Input: nums = [2,2,1]
 * Output: 1
 *
 * Пример 2
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 *
 * Решение - с использованием XOR
 *
 * Сложность:
 * Время: O(n), где n - количество элементов в массиве
 * Память: O(1) - используем только константную дополнительную память
 *
 * Не самое быстрое решение - 125 ms
 */
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        // Применяем операцию XOR ко всем элементам массива
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}