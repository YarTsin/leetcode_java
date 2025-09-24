package org.example.g1701_1800.s1752_check_if_array_is_sorted_and_rotated;

/**
 * Решение с поиском точки поворота
 * Подход: Находим точку поворота и проверяем, отсортированы ли обе части.
 */
class Solution2 {
    public boolean check(int[] nums) {
        int n = nums.length;
        int pivotIndex = -1;

        // Находим точку поворота (где происходит убывание)
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                pivotIndex = i + 1;
                break;
            }
        }

        // Если точка поворота не найдена, массив уже отсортирован
        if (pivotIndex == -1) {
            return true;
        }

        // Проверяем, что обе части отсортированы и все элементы после поворота
        // не больше элементов до поворота
        for (int i = pivotIndex; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }

        // Проверяем, что последний элемент не больше первого
        return nums[n - 1] <= nums[0];
    }
}
