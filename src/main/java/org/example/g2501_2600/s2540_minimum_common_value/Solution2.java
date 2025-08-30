package org.example.g2501_2600.s2540_minimum_common_value;

/**
 * Подход с бинарным поиском
 * Объяснение:
 * Сложность: O(n log m) времени, O(1) дополнительной памяти
 * Подход: Для каждого элемента первого массива выполняем
 * бинарный поиск во втором массиве
 * Преимущество: Эффективно, когда один массив значительно меньше другого
 */
class Solution2 {
    public int getCommon(int[] nums1, int[] nums2) {
        // Итерируем по первому массиву и для каждого элемента
        // ищем совпадение во втором массиве с помощью бинарного поиска
        for (int num : nums1) {
            if (binarySearch(nums2, num)) {
                return num; // Нашли минимальное общее значение
            }
        }

        return -1; // Общих значений не найдено
    }

    private boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
