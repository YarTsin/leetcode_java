package org.example.g0401_0500.s0448_find_all_numbers_disappeared_in_an_array;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с циклической сортировкой
 * Объяснение:
 * Циклическая сортировка: Размещаем каждое число на его правильной позиции (nums[i] должно быть на позиции i-1)
 * Поиск несоответствий: После сортировки ищем индексы, где nums[i] ≠ i + 1
 * Особенности:
 * Не использует дополнительную память
 * Модифицирует исходный массив
 * В худшем случае временная сложность O(n)
 */
class Solution3 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // Циклическая сортировка - размещаем числа на правильных позициях
        int i = 0;
        while (i < nums.length) {
            int correctPosition = nums[i] - 1;

            // Если число не на своем месте и целевая позиция содержит другое число
            if (nums[i] != nums[correctPosition]) {
                // Меняем местами
                int temp = nums[i];
                nums[i] = nums[correctPosition];
                nums[correctPosition] = temp;
            } else {
                i++;
            }
        }

        // Находим числа, которые отсутствуют
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
