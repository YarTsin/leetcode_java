package org.example.g1301_1400.s1346_check_if_n_and_its_double_exist;

import java.util.HashMap;
import java.util.Map;

/**
 * Альтернативное решение: Два прохода с хэш-таблицей
 */
class Solution2 {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // Первый проход: подсчитываем количество каждого числа
        for (int number : arr) {
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }

        // Второй проход: проверяем условия
        for (int number : arr) {
            if (number == 0) {
                // Особый случай для нуля: нужно как минимум два нуля
                if (countMap.getOrDefault(0, 0) > 1) {
                    return true;
                }
            } else {
                // Проверяем наличие удвоенного значения
                if (countMap.containsKey(2 * number)) {
                    return true;
                }
                // Проверяем наличие половинного значения (только для четных)
                if (number % 2 == 0 && countMap.containsKey(number / 2)) {
                    return true;
                }
            }
        }

        return false;
    }
}
