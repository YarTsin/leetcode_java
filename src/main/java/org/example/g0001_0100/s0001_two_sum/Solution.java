package org.example.g0001_0100.s0001_two_sum;
// #Easy #Top_100_Liked_Questions #Top_Interview_Questions #Array #Hash_Table
// #Udemy_Arrays #Top_Interview_150_Hashmap

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * Требуется найти в массиве два числа,
 * которые в сумме дают заданное целевое значение.
 * Нужно вернуть индексы этих двух чисел.
 *
 * Важные моменты:
 * Каждый входной массив имеет ровно одно решение
 * Нельзя использовать один и тот же элемент дважды
 * Можно возвращать ответ в любом порядке
 *
 * Эфективный подход Hash таблица
 *
 * todo не до конца понятно
 *
 * Объяснение:
 * Сложность: O(n) времени, O(n) дополнительной памяти
 * Подход: Используем хэш-таблицу для хранения чисел и их индексов.
 * Для каждого числа вычисляем complement (target - current) и проверяем,
 * есть ли он уже в таблице
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Создаем хэш-таблицу для хранения чисел и их индексов
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Проверяем, есть ли complement в хэш-таблице
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i};
            }

            // Добавляем текущее число и его индекс в хэш-таблицу
            numToIndex.put(nums[i], i);
        }

        // По условию задачи решение всегда существует
        return new int[]{};
    }
}
/*
Пример 1
Вход: nums = [2,7,11,15], target = 9
Выход: [0,1]
Объяснение: nums[0] + nums[1] = 2 + 7 = 9

Пример 2
Вход: nums = [3,2,4], target = 6
Выход: [1,2]
Объяснение: nums[1] + nums[2] = 2 + 4 = 6

Пример 3
Вход: nums = [3,3], target = 6
Выход: [0,1]
Объяснение: nums[0] + nums[1] = 3 + 3 = 6
*/