package org.example.g2501_2600.s2529_maximum_count_of_positive_integer_and_negative_integer;

// #Easy #Array #Binary_Search #Counting

/**
 * 2529. Maximum Count of Positive Integer and Negative Integer
 *
 * Дан массив целых чисел nums, который отсортирован
 * в неубывающем порядке. Необходимо найти максимальное
 * значение между количеством положительных чисел
 * и количеством отрицательных чисел в массиве.
 *
 * Важные моменты:
 * Массив уже отсортирован
 * Ноль не считается ни положительным, ни отрицательным числом
 * Нужно вернуть максимум из двух значений: count(positive) и count(negative)
 * примеры внизу
 *
 * Эффективный подход - бинарный поиск
 * Объяснение:
 * Сложность: O(log n) времени, O(1) дополнительной памяти
 * Подход: Используем два бинарных поиска:
 * findFirstNonNegative - находит первый индекс, где число ≥ 0
 * findFirstPositive - находит первый индекс, где число > 0
 * Количество отрицательных чисел = индекс первого неотрицательного числа
 * Количество положительных чисел = общая длина - индекс первого положительного числа
 *
 * Самое быстрое решение - 0 ms
 */
class Solution {
    public int maximumCount(int[] nums) {
        // Находим индекс первого неотрицательного числа (>= 0)
        int firstNonNegativeIndex = findFirstNonNegative(nums);

        // Находим индекс первого положительного числа (> 0)
        int firstPositiveIndex = findFirstPositive(nums);

        // Количество отрицательных чисел = индекс первого неотрицательного числа
        int negativeCount = firstNonNegativeIndex;

        // Количество положительных чисел = общая длина - индекс первого положительного числа
        int positiveCount = nums.length - firstPositiveIndex;

        return Math.max(negativeCount, positiveCount);
    }

    private int findFirstNonNegative(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = nums.length; // если все числа отрицательные

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= 0) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private int findFirstPositive(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int result = nums.length; // если все числа неположительные

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > 0) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
/*
Пример 1
Вход: nums = [-2,-1,-1,1,2,3]
Выход: 3
Объяснение:
Отрицательных чисел: 3 (-2,-1,-1)
Положительных чисел: 3 (1,2,3)
Максимум(3, 3) = 3

Пример 2
Вход: nums = [-3,-2,-1,0,0,1,2]
Выход: 3
Объяснение:
Отрицательных чисел: 3 (-3,-2,-1)
Положительных чисел: 2 (1,2)
Максимум(3, 2) = 3

Пример 3
Вход: nums = [5,20,66,1314]
Выход: 4
Объяснение:
Отрицательных чисел: 0
Положительных чисел: 4
Максимум(0, 4) = 4

 */
