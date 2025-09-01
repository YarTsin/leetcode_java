package org.example.g0201_0300.s0228_summary_ranges;

// #Easy #Array #Top_Interview_150_Intervals #Two_Pointers

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 * Дан отсортированный уникальный массив целых чисел.
 * Необходимо вернуть кратчайший отсортированный список диапазонов,
 * который точно покрывает все числа в массиве. То есть, каждый элемент
 * массива покрывается ровно одним из диапазонов, и нет таких целых чисел,
 * которые входят в диапазон, но отсутствуют в массиве.
 *
 * Правила формирования диапазонов:
 * Диапазон [a,b] должен быть выведен как:
 * "a->b" если a != b
 * "a" если a == b
 *
 * Пример 1
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Объяснение:
 * Диапазоны: [0,2] → "0->2", [4,5] → "4->5", [7,7] → "7"
 *
 * Пример 2
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Объяснение:
 * Диапазоны: [0,0] → "0", [2,4] → "2->4", [6,6] → "6", [8,9] → "8->9"
 *
 * Ограничения:
 * 0 <= nums.length <= 20
 * -2^31 <= nums[i] <= 2^31 - 1
 * Все числа в nums уникальны
 * nums отсортирован в возрастающем порядке
 *
 * решение в 1 проход - не самое быстрое - 6 ms
 *
 * Сложность:
 * Время: O(n), где n - длина массива
 * Память: O(1) дополнительной памяти (без учета результата)
 */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Если текущее число продолжает последовательность
            if (nums[i] == end + 1) {
                end = nums[i];
            } else {
                // Добавляем текущий диапазон
                addRange(result, start, end);
                // Начинаем новый диапазон
                start = nums[i];
                end = nums[i];
            }
        }

        // Добавляем последний диапазон
        addRange(result, start, end);

        return result;
    }

    private void addRange(List<String> result, int start, int end) {
        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }
    }
}