package org.example.g0001_0100.s0035_search_insert_position;

/**
 * LeetCode #Easy #Array #BinarySearch
 *
 * Вернуть  индекс целевого числа в отсортированном массиве, если значение найдено
 * или вернуть индекс где элемент должен был бы находиться
 *
 * Примеры
 * Вход: nums = [1,3,5,6], target = 5
 * Выход: 2
 * Вход: nums = [1,3,5,6], target = 2
 * Выход: 1 (число 2 было бы вставлено между 1 и 3)
 *
 * Используем бинарный поиск (Binary Search) (по условию)
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0; // начало массива
        int right = nums.length - 1; // конец массива

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // нашли точное совпадение
            } else if (nums[mid] < target) {
                left = mid + 1;// ищем в правой половине
            } else {
                right = mid - 1; //ищем в левой половине
            }
        }
        return left; // если не нашли возвращаем позицию для вставки
    }
}