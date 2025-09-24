package org.example.g1701_1800.s1800_maximum_ascending_subarray_sum;

/**
 * Явное определение границ подмассивов
 * Подход:
 * Используем два указателя для обозначения начала
 * и конца текущего возрастающего подмассива.
 */
class Solution2 {
    public int maxAscendingSum(int[] nums) {
        if (nums.length == 0) return 0;

        int maxSum = nums[0];
        int left = 0; // Начало текущего возрастающего подмассива

        for (int right = 1; right < nums.length; right++) {
            // Если последовательность перестала быть возрастающей
            if (nums[right] <= nums[right - 1]) {
                // Вычисляем сумму текущего подмассива
                int currentSum = calculateSum(nums, left, right - 1);
                maxSum = Math.max(maxSum, currentSum);

                // Начинаем новый подмассив с текущей позиции
                left = right;
            }

            // Если дошли до конца массива
            if (right == nums.length - 1) {
                int currentSum = calculateSum(nums, left, right);
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    private int calculateSum(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}