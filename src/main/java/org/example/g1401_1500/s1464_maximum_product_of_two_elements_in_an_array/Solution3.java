package org.example.g1401_1500.s1464_maximum_product_of_two_elements_in_an_array;

/**
 * Решение с одним проходом и обновлением максимумов
 * Подход:
 * Более явная версия решения с четким обновлением максимумов.
 */
class Solution3 {
    public int maxProduct(int[] nums) {
        int firstMax = 0;
        int secondMax = 0;

        for (int number : nums) {
            if (number > firstMax) {
                secondMax = firstMax;
                firstMax = number;
            } else if (number > secondMax) {
                secondMax = number;
            }
        }

        return (firstMax - 1) * (secondMax - 1);
    }
}
