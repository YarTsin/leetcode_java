package org.example.g1201_1300.s1299_replace_elements_with_greatest_element_on_right_side;

/**
 * Решение с двойным циклом (наивное)
 * Подход: Для каждого элемента искать максимум в правой части.
 * Сложность: O(n²) по времени, O(1) по памяти.
 */
class Solution3 {
    public int[] replaceElements(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            int maxRight = arr[i + 1];

            // Находим максимум в правой части
            for (int j = i + 2; j < length; j++) {
                if (arr[j] > maxRight) {
                    maxRight = arr[j];
                }
            }

            arr[i] = maxRight;
        }

        // Последний элемент заменяем на -1
        arr[length - 1] = -1;

        return arr;
    }
}
