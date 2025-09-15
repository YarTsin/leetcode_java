package org.example.g1101_1200.s1200_minimum_absolute_difference;

// #Easy #Array #Sorting

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. Minimum Absolute Difference
 *
 * Условие: Дан массив целых чисел arr. Необходимо найти все
 * пары элементов, у которых абсолютная разница минимальна
 * среди всех возможных пар различных элементов. Вернуть список
 * всех таких пар в порядке возрастания.
 *
 * Требования:
 * Возвращаемые пары должны быть отсортированы в порядке возрастания
 * Каждая пара [a, b] должна удовлетворять условию a < b
 * Все пары должны быть уникальными
 *
 * Constraints:
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 *
 * Пример 1
 * Input: arr = [4,2,1,3] * Output: [[1,2],[2,3],[3,4]]
 * Объяснение: Минимальная абсолютная разница равна 1.
 * Пары с разницей 1: [1,2], [2,3], [3,4]
 *
 * Пример 2
 * Input: arr = [1,3,6,10,15]  * Output: [[1,3]]
 * Объяснение: Минимальная абсолютная разница равна 2.
 * Единственная пара с разницей 2: [1,3]
 *
 * Пример 3
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 * Объяснение: Минимальная абсолютная разница равна 4.
 *
 * Решение с сортировкой и 2 прохода - не быстрое 17 ms
 *
 */
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // Сортируем массив для нахождения минимальной разницы между соседними элементами
        Arrays.sort(arr);

        // Инициализируем минимальную разницу максимально возможным значением
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();

        // Первый проход: находим минимальную разницу между соседними элементами
        for (int i = 1; i < arr.length; i++) {
            int currentDiff = arr[i] - arr[i - 1];
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
            }
        }

        // Второй проход: собираем все пары с минимальной разницей
        for (int i = 1; i < arr.length; i++) {
            int currentDiff = arr[i] - arr[i - 1];
            if (currentDiff == minDiff) {
                // Создаем пару и добавляем в результат
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i - 1]);
                pair.add(arr[i]);
                result.add(pair);
            }
        }

        return result;
    }
}
