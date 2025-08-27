package org.example.g1301_1400.s1346_check_if_n_and_its_double_exist;

import java.util.HashSet;
import java.util.Set;

/**
 * #Easy #Array #HashMap #Sort #Pointers
 *
 * 1346. Check If N and Its Double Exist
 *
 * Условие задачи:
 * Дан массив целых чисел arr. Необходимо проверить, существуют
 * ли два различных индекса i и j таких, что:
 * arr[i] == 2 * arr[j] (удвоенное значение)
 * ИЛИ arr[j] == 2 * arr[i] (половинное значение)
 *
 * Важные условия:
 * Индексы i и j должны быть различными (i != j)
 * Ноль считается удвоенным/половинным значением самого себя (0 = 2 * 0)
 * Массив может содержать отрицательные числа
 *
 * Пример 1
 * Вход: arr = [10,2,5,3] * Выход: true
 * Объяснение: 10 = 2 * 5, поэтому arr[0] = 10 и arr[2] = 5
 *
 * Пример 2
 * Вход: arr = [3,1,7,11] * Выход: false
 * Объяснение: Нет таких пар, где одно число равно удвоенному другому
 *
 * Оптимальное решение: Хэш-таблица
 *
 * 3 по скорости решение - 2 ms
 *
 */
class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> seenNumbers = new HashSet<>();

        for (int number : arr) {
            // Проверяем, есть ли уже удвоенное или половинное значение
            if (seenNumbers.contains(2 * number) ||
                    (number % 2 == 0 && seenNumbers.contains(number / 2))) {
                return true;
            }
            seenNumbers.add(number);
        }

        return false;
    }
}

/*
Примечания:
Непонятно почему в разделе BinarySearch
 */