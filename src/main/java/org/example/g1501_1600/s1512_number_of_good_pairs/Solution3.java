package org.example.g1501_1600.s1512_number_of_good_pairs;

/**
 * Брутфорс решение (Полный перебор)
 *
 * Это наивное решение с временной сложностью O(n²).
 * Оно неэффективно для больших массивов, но просто для понимания.
 */
class Solution3 {
    public int numIdenticalPairs(int[] nums) {
        // Инициализируем счетчик хороших пар
        int goodPairsCount = 0;
        // Получаем длину массива
        int n = nums.length;

        // Внешний цикл: перебираем все индексы i от 0 до n-2
        for (int i = 0; i < n - 1; i++) {
            // Внутренний цикл: для каждого i перебираем все индексы j от i+1 до n-1
            for (int j = i + 1; j < n; j++) {
                // Если элементы равны, это хорошая пара
                if (nums[i] == nums[j]) {
                    goodPairsCount++;
                }
            }
        }

        return goodPairsCount;
    }
}
