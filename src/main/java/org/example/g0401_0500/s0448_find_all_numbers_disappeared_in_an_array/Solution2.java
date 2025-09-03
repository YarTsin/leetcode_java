package org.example.g0401_0500.s0448_find_all_numbers_disappeared_in_an_array;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с использованием дополнительной памяти
 *
 * Объяснение:
 * Булев массив: Создаем массив для отметки присутствующих чисел
 * Отметка присутствия: Проходим по исходному массиву и отмечаем присутствующие числа
 * Поиск отсутствующих: Проверяем, какие числа не были отмечены
 *
 * Недостатки:
 * Использует O(n) дополнительной памяти
 * Не соответствует требованию O(1) дополнительной памяти
 */
class Solution2 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[] present = new boolean[nums.length + 1];

        // Отмечаем присутствующие числа
        for (int num : nums) {
            present[num] = true;
        }

        // Находим отсутствующие числа
        for (int i = 1; i <= nums.length; i++) {
            if (!present[i]) {
                result.add(i);
            }
        }

        return result;
    }
}
