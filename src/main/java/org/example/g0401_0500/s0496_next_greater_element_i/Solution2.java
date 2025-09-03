package org.example.g0401_0500.s0496_next_greater_element_i;

/**
 * Решение с brute force поиском
 * Объяснение:
 * Линейный поиск: Для каждого элемента nums1 ищем его в nums2
 * Поиск большего элемента: После нахождения ищем первый больший элемент справа
 * Простота: Легко понять, но неэффективно
 *
 * Сложность:
 * Временная сложность: O(n * m) - в худшем случае
 * Пространственная сложность: O(1)
 */
class Solution2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int target = nums1[i];
            int nextGreater = -1;
            boolean found = false;

            // Ищем target в nums2
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == target) {
                    found = true;
                }

                // После нахождения target ищем первый больший элемент
                if (found && nums2[j] > target) {
                    nextGreater = nums2[j];
                    break;
                }
            }

            result[i] = nextGreater;
        }

        return result;
    }
}
