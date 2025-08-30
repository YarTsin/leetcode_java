package org.example.g2901_3000.s2970_count_the_number_of_incremovable_subarrays_i;

/**
 * Альтернативное решение - Two Pointers
 * Сложность: O(n³) - время, O(1) - дополнительная память
 */
class Solution2 {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int count = 0;

        // Перебираем все возможные начальные точки подмассивов
        for (int i = 0; i < n; i++) {
            // Для каждого начала, находим максимальный конец
            for (int j = i; j < n; j++) {
                if (isValidAfterRemoval(nums, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isValidAfterRemoval(int[] nums, int start, int end) {
        int n = nums.length;
        int prev = Integer.MIN_VALUE;

        // Проверяем оставшийся массив на строгое возрастание
        for (int i = 0; i < n; i++) {
            // Пропускаем удаляемый подмассив
            if (i >= start && i <= end) {
                continue;
            }

            // Проверяем строгое возрастание
            if (nums[i] <= prev) {
                return false;
            }
            prev = nums[i];
        }

        return true;
    }
}
