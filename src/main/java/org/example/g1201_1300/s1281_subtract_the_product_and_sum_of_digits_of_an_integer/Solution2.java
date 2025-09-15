package org.example.g1201_1300.s1281_subtract_the_product_and_sum_of_digits_of_an_integer;

/**
 * Решение - С преобразованием в строку
 */
public class Solution2 {
    public int subtractProductAndSum(int n) {
        // Преобразуем число в строку
        String numberStr = String.valueOf(n);

        int product = 1;
        int sum = 0;

        // Проходим по каждому символу строки
        for (int i = 0; i < numberStr.length(); i++) {
            // Преобразуем символ в цифру
            int digit = Character.getNumericValue(numberStr.charAt(i));

            // Обновляем произведение и сумму
            product *= digit;
            sum += digit;
        }

        return product - sum;
    }
}
