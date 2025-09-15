package org.example.g1201_1300.s1287_element_appearing_more_than_25_in_sorted_array;

// #Easy #Array #Бинарный_поиск

/**
 * 1287. Element Appearing More Than 25% In Sorted Array
 *
 * Дан отсортированный целочисленный массив arr.
 * Массив отсортирован в неубывающем порядке.
 * В массиве гарантированно существует ровно один элемент,
 * который встречается более чем 25% раз от общего количества элементов.
 *
 * Цель: Найти и вернуть этот элемент.
 *
 * Условия:
 * Массив отсортирован по возрастанию
 * Все элементы целочисленные
 * Гарантируется, что ровно один элемент встречается > 25% раз
 * Длина массива: 1 ≤ arr.length ≤ 10^4
 * (примеры внизу)
 *
 * Решение - бинарный поиск границ вхождения
 * Это самое быстрое решение - 0 ms
 *
 * Сложность:
 * Время: O(n log n) в худшем случае, но на практике быстрее
 * из-за пропуска элементов
 * Память: O(1)
 */
public class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int threshold = n / 4;

        // Проверяем каждый возможный кандидат с шагом (threshold + 1)
        for (int i = 0; i < n; i += threshold + 1) {
            int candidate = arr[i];

            // Находим первое вхождение кандидата
            int leftIndex = findFirstOccurrence(arr, candidate);

            // Находим последнее вхождение кандидата
            int rightIndex = findLastOccurrence(arr, candidate);

            // Проверяем, превышает ли количество вхождений порог
            if (rightIndex - leftIndex + 1 > threshold) {
                return candidate;
            }
        }

        return -1; // По условию всегда должен находиться элемент
    }

    // Бинарный поиск первого вхождения элемента
    private int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                if (arr[mid] == target) {
                    result = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    // Бинарный поиск последнего вхождения элемента
    private int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                if (arr[mid] == target) {
                    result = mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
/*
Пример 1
Вход: arr = [1,2,2,6,6,6,6,7,10]
Выход: 6
Объяснение:
Длина массива: 9
25% от 9 = 2.25 → элемент должен встречаться минимум 3 раза
6 встречается 4 раза > 3

Пример 2
Вход: arr = [1,1]
Выход: 1
Объяснение:
Длина массива: 2
25% от 2 = 0.5 → элемент должен встречаться минимум 1 раз
1 встречается 2 раза > 1

Пример 3
Вход: arr = [1,2,3,3]
Выход: 3
Объяснение:
Длина массива: 4
25% от 4 = 1 → элемент должен встречаться минимум 2 раза
3 встречается 2 раза > 1

 */
