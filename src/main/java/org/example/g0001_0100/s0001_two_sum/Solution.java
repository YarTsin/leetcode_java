package org.example.g0001_0100.s0001_two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode #Easy #Array
 * Задача "Two Sum" (Две суммы) с LeetCode требует найти в массиве два числа,
 * которые в сумме дают заданное целевое значение.
 * Нужно вернуть индексы этих двух чисел.
 *
 * Можно предположить, что каждый входной параметр имеет
 * ровно одно решение, и нельзя использовать один и тот же элемент дважды.
 *
 * Вход: nums = [2,7,11,15], target = 9
 * Выход: [0,1]
 * Объяснение: nums[0] + nums[1] = 2 + 7 = 9
 *
 * todo не до конца понятно
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Создаем хеш-таблицу для хранения чисел и их индексов
        Map<Integer, Integer> numToIndex = new HashMap<>();

        // Проходим по всем элементам массива
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            int currentNumber = nums[currentIndex];
            // Вычисляем число, которое в сумме с текущим даст target
            int complement = target - currentNumber;

            // Проверяем, есть ли complement в нашей хеш-таблице
            if (numToIndex.containsKey(complement)) {
                // Если есть, возвращаем индексы
                return new int[] {numToIndex.get(complement), currentIndex};
            }

            // Добавляем текущее число и его индекс в хеш-таблицу
            numToIndex.put(currentNumber, currentIndex);
        }

        // В задаче гарантируется, что решение есть, поэтому сюда не дойдем
        throw new IllegalArgumentException("No two sum solution");
    }
}