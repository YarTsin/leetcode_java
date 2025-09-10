package org.example.g0801_0900.s0896_monotonic_array;

/**
 * Сначала определяем направление, затем проверяем соответствие
 */
class Solution2 {
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }

        // Определяем направление по первым двум различным элементам
        int direction = 0; // 0 - неизвестно, 1 - возрастание, -1 - убывание

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (direction == 0) {
                    // Устанавливаем направление
                    direction = nums[i] > nums[i - 1] ? 1 : -1;
                } else {
                    // Проверяем соответствие направлению
                    if ((direction == 1 && nums[i] < nums[i - 1]) ||
                            (direction == -1 && nums[i] > nums[i - 1])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}