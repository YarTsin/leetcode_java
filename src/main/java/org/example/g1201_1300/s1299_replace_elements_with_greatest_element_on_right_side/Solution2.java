package org.example.g1201_1300.s1299_replace_elements_with_greatest_element_on_right_side;

/**
 * Решение с дополнительным массивом (менее эффективное)
 * Подход: Создание дополнительного массива для хранения результатов.
 * Сложность: O(n) по времени, O(n) по памяти.
 */
class Solution2 {
    public int[] replaceElements(int[] arr) {
        int length = arr.length;
        int[] result = new int[length];

        // Последний элемент всегда -1
        result[length - 1] = -1;

        // Проходим справа налево, заполняя массив результатов
        for (int i = length - 2; i >= 0; i--) {
            // Каждый элемент результата - максимум из следующего элемента
            // исходного массива и следующего элемента результата
            result[i] = Math.max(arr[i + 1], result[i + 1]);
        }

        return result;
    }
}
