package org.example.g0301_0400.s0303_range_sum_query_immutable;

// #Easy #Array #Design #Prefix_Sum

/**
 * 303. Range Sum Query - Immutable
 * Необходимо реализовать класс, который обрабатывает запросы суммы
 * элементов массива в заданном диапазоне [i, j] включительно.
 * Массив является неизменяемым (immutable), поэтому его элементы
 * не будут меняться после инициализации.
 *
 * todo запутанное условие
 * Пример
 * Вход:
 * ["NumArray",           "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 *
 * Выход:
 * [null, 1, -1, -3]
 *
 * Объяснение:
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
 * numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
 * numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 *
 * Ограничения:
 * 1 <= nums.length <= 10^4
 * -10^5 <= nums[i] <= 10^5
 * 0 <= left <= right < nums.length
 * Максимум 10^4 вызовов метода sumRange
 *
 *
 * Ваш объект NumArray будет создан и вызван следующим образом:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left, right);
 *
 *
 * Решение - префиксные суммы это самое быстрое решение 7 ms
 * Префиксные суммы: Оптимально для частых запросов, O(1) на запрос
 *
 */
class Solution {  //ЕСЛИ СДАЕТЕ НА ПРОВЕРКУ КЛАСС ДОЛЖЕН БЫТЬ NumArray
    // Массив для хранения префиксных сумм
    private int[] prefixSums;

    public Solution(int[] nums) {
        // Инициализируем массив префиксных сумм
        prefixSums = new int[nums.length + 1];

        // Вычисляем префиксные суммы: prefixSums[i] = сумма элементов от 0 до i-1
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) { // этот метод будет вызван проверкой
        // Сумма диапазона [left, right] = prefixSums[right + 1] - prefixSums[left]
        return prefixSums[right + 1] - prefixSums[left];
    }
}