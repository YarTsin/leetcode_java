package org.example.g1201_1300.s1295_find_numbers_with_even_number_of_digits;

/**
 * Через преобразование в строку: Самый простой подход
 */
public class Solution3 {
    public int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            String numStr = String.valueOf(num);
            if (numStr.length() % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}
