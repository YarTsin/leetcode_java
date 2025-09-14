package org.example.g1101_1200.s1122_relative_sort_array;

/**
 * Решение с 2 списками
 *
 * Объяснение:
 * Подсчет частот: Считаем вхождения элементов arr1
 * Добавление по порядку: Добавляем элементы в порядке arr2
 * Обработка остатка: Собираем и сортируем оставшиеся элементы
 * Объединение: Объединяем результаты
 * Сложность: Время O(n log n), пространство O(n)
 *
 */
import java.util.*;

class Solution3 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Создаем Map для подсчета элементов arr1
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Список для элементов из arr2
        List<Integer> resultList = new ArrayList<>();

        // Добавляем элементы в порядке arr2
        for (int num : arr2) {
            int count = countMap.get(num);
            for (int i = 0; i < count; i++) {
                resultList.add(num);
            }
            countMap.remove(num); // Удаляем обработанные элементы
        }

        // Собираем оставшиеся элементы и сортируем их
        List<Integer> remaining = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                remaining.add(entry.getKey());
            }
        }
        Collections.sort(remaining);

        // Добавляем отсортированные оставшиеся элементы
        resultList.addAll(remaining);

        // Преобразуем в массив
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
