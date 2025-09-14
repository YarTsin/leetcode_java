package org.example.g1101_1200.s1122_relative_sort_array;

import java.util.*;

/**
 * Подход с Custom Comparator (используя сортировку)
 *
 * Объяснение:
 * Создание порядка: Сохраняем порядок элементов из arr2 в Map
 * Custom сортировка: Сортируем arr1 используя компаратор, который учитывает:
 * Порядок из arr2 для общих элементов
 * Элементы только из arr1 идут после и сортируются по возрастанию
 * Преобразование: Возвращаем отсортированный массив
 * Сложность: Время O(n log n), пространство O(n)
 */
class Solution2 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Создаем Map для хранения порядка элементов из arr2
        Map<Integer, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            orderMap.put(arr2[i], i);
        }

        // Преобразуем в List для сортировки
        List<Integer> list = new ArrayList<>();
        for (int num : arr1) {
            list.add(num);
        }

        // Сортируем с custom comparator
        Collections.sort(list, (a, b) -> {
            if (orderMap.containsKey(a) && orderMap.containsKey(b)) {
                // Оба элемента в arr2 - сохраняем порядок из arr2
                return Integer.compare(orderMap.get(a), orderMap.get(b));
            } else if (orderMap.containsKey(a)) {
                // Только a в arr2 - a идет первым
                return -1;
            } else if (orderMap.containsKey(b)) {
                // Только b в arr2 - b идет первым
                return 1;
            } else {
                // Оба не в arr2 - сортируем по возрастанию
                return Integer.compare(a, b);
            }
        });

        // Преобразуем обратно в массив
        int[] result = new int[arr1.length];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}