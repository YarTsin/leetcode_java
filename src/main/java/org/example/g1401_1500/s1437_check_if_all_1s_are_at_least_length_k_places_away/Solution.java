package org.example.g1401_1500.s1437_check_if_all_1s_are_at_least_length_k_places_away;

// #Easy #Array #Points

/**
 * 1437. Check If All 1's Are at Least Length K Places Away
 *
 * Дан массив двоичных чисел nums и целое число k. Нужно проверить,
 * что все единицы в массиве находятся на расстоянии не менее k мест друг от друга.
 * Другими словами, между любыми двумя соседними единицами
 * должно быть не менее k нулей.
 * (примеры внизу)
 *
 * Ограничения:
 * 1 <= nums.length <= 10^5
 * 0 <= k <= nums.length
 * nums[i] равно 0 или 1
 *
 * Решение - в один проход - 2-е по скорости - 1 ms
 *
 * Временная сложность: O(n)
 * Пространственная сложность: O(1)
 *
 */
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int lastOneIndex = -1; // Индекс последней встреченной единицы

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastOneIndex != -1 && i - lastOneIndex - 1 < k) {
                    return false; // Нашли две единицы слишком близко
                }
                lastOneIndex = i; // Обновляем индекс последней единицы
            }
        }

        return true; // Все единицы на достаточном расстоянии
    }
}

/*
Пример 1
Input: nums = [1,0,0,0,1,0,0,1], k = 2
Output: true
Объяснение:
Первая и вторая единицы разделены 3 нулями (> k)
Вторая и третья единицы разделены 2 нулями (= k)

Пример 2
Input: nums = [1,0,0,1,0,1], k = 2
Output: false
Объяснение:
Вторая и третья единицы разделены только 1 нулем (< k)

 */