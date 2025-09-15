package org.example.g1201_1300.s1295_find_numbers_with_even_number_of_digits;

/**
 * Подсчет цифр через деление на 10
 */
public class Solution2 {
    public int findNumbers(int[] nums) {
        int evenDigitCount = 0;

        for (int num : nums) {
            int digitCount = countDigits(num);
            if (digitCount % 2 == 0) {
                evenDigitCount++;
            }
        }

        return evenDigitCount;
    }

    private int countDigits(int number) {
        // Обрабатываем случай number = 0
        if (number == 0) {
            return 1;
        }

        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }
}
