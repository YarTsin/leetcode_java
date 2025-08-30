package org.example.g0001_0100.s0066_plus_one;
// #Easy #Top_Interview_Questions #Array #Math #Udemy_Arrays
// #Top_Interview_150_Math


/**
 * 66. Plus One
 *
 * Нужно вернуть массив увеличенный на 1
 * [1, 2, 3] → [1, 2, 4] (123 + 1 = 124)
 * или добавить 1 и вернуть новый массив
 * [9, 9, 9] → [1, 0, 0, 0] (999 + 1 = 1000)
 * todo переделать
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        //идем от конца массива к началу
        for (int i = n - 1; i >= 0; i--) {
            // если цифры обычные, увеличиваем на 1
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        // Если последняя (первая) цифра была 9 - попадаем сюда
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
