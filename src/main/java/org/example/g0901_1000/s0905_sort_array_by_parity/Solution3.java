package org.example.g0901_1000.s0905_sort_array_by_parity;

import java.util.Arrays;
import java.util.Comparator;

/**
 * решение с использованием Comparator
 */
class Solution3 {
    public int[] sortArrayByParity(int[] nums) {
        Integer[] boxedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(boxedNums, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                // Четные числа идут перед нечетными
                return Integer.compare(a % 2, b % 2);
            }
        });

        // Конвертируем обратно в int[]
        return Arrays.stream(boxedNums).mapToInt(Integer::intValue).toArray();
    }
}
/*
Объяснение:
Использование Comparator:
Преобразуем int[] в Integer[]
Сортируем с кастомным компаратором
Четные числа (остаток 0) идут перед нечетными (остаток 1)

Особенности:
Сохраняет относительный порядок элементов с одинаковой четностью
Использует встроенную сортировку
Менее эффективно по памяти

Временная сложность: O(n log n) из-за сортировки
Пространственная сложность: O(n)
 */
