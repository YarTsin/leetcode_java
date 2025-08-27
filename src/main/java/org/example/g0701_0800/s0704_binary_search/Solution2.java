package org.example.g0701_0800.s0704_binary_search;

/**
 * Альтернативное решение: Рекурсивный подход
 */
class Solution2 {
    public int search(int[] nums, int target) {
        // Запускаем рекурсивный поиск по всему массиву
        return binarySearchRecursive(nums, target, 0, nums.length - 1);
    }

    private int binarySearchRecursive(int[] nums, int target, int left, int right) {
        // Базовый случай: границы пересеклись
        if (left > right) {
            return -1;
        }

        // Находим средний индекс
        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            // Рекурсивно ищем в правой половине
            return binarySearchRecursive(nums, target, mid + 1, right);
        } else {
            // Рекурсивно ищем в левой половине
            return binarySearchRecursive(nums, target, left, mid - 1);
        }
    }
}