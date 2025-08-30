package org.example.g2501_2600.s2540_minimum_common_value;

/**
 * Оптимизированный подход с двумя указателями (ранний выход)
 * Объяснение:
 * Сложность: O(n + m) времени, O(1) дополнительной памяти
 * Подход: Аналогичен первому подходу, но с более компактной записью
 * Преимущество: Максимально использует отсортированность массивов
 */
class Solution4 {
    public int getCommon(int[] nums1, int[] nums2) {
        int pointer1 = 0;
        int pointer2 = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;

        while (pointer1 < length1 && pointer2 < length2) {
            // Если значения равны - нашли результат
            if (nums1[pointer1] == nums2[pointer2]) {
                return nums1[pointer1];
            }

            // Если значение в первом массиве меньше, двигаем его указатель
            if (nums1[pointer1] < nums2[pointer2]) {
                pointer1++;
            } else {
                pointer2++;
            }
        }

        return -1;
    }
}
