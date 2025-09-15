package org.example.g1201_1300.s1281_subtract_the_product_and_sum_of_digits_of_an_integer;

/**
 * Решение С использованием Stream API - Функциональный подход
 */
import java.util.stream.IntStream;

public class Solution3 {
    public int subtractProductAndSum(int n) {
        // Преобразуем число в поток цифр
        IntStream digitsStream = String.valueOf(n)
                .chars()
                .map(Character::getNumericValue);

        // Вычисляем произведение цифр
        int product = digitsStream.reduce(1, (a, b) -> a * b);

        // Создаем новый поток для суммы (поток нельзя использовать дважды)
        IntStream sumStream = String.valueOf(n)
                .chars()
                .map(Character::getNumericValue);

        // Вычисляем сумму цифр
        int sum = sumStream.sum();

        return product - sum;
    }
}