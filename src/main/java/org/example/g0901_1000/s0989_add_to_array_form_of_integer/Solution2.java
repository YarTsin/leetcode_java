package org.example.g0901_1000.s0989_add_to_array_form_of_integer;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с преобразованием в число (не подходит для больших чисел)
 * Подход: Преобразуем массив в число, складываем с k,
 * затем преобразуем обратно в массив.
 */
class Solution2 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        // Преобразуем массив в число
        long number = 0;
        for (int digit : num) {
            number = number * 10 + digit;
        }

        // Складываем числа
        long sum = number + k;

        // Преобразуем сумму обратно в массив
        List<Integer> result = new ArrayList<>();
        if (sum == 0) {
            result.add(0);
            return result;
        }

        while (sum > 0) {
            result.add(0, (int)(sum % 10));
            sum /= 10;
        }

        return result;
    }
}
