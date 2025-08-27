package org.example.g1301_1400.s1385_find_the_distance_value_between_two_arrays;

/**
 * Простое решение - двойной цикл
 */
class Solution3 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;

        for (int num1 : arr1) {
            boolean valid = true;
            for (int num2 : arr2) {
                if (Math.abs(num1 - num2) <= d) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                count++;
            }
        }

        return count;
    }
}
