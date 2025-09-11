package org.example.g1001_1100.s1018_binary_prefix_divisible_by_5;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Альтернативное решение (прямое вычисление
 * с переполнением - НЕ РЕКОМЕНДУЕТСЯ)
 *
 * Почему это плохое решение:
 * Число, представленное префиксом из 100 000 бит, астрономически
 * велико (порядка 2^100000). Попытка хранить его в примитивных типах
 * данных (например, int или long) приведет к переполнению и некорректным
 * результатам. Даже использование BigInteger будет крайне неэффективным
 * по памяти и времени для таких больших чисел и не пройдет
 * по времени на LeetCode.
 */
class Solution2 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> answer = new ArrayList<>();
        // Инициализируем BigInteger для представления текущего числа
        BigInteger currentNumber = BigInteger.ZERO;

        for (int bit : nums) {
            // Сдвигаем текущее число влево (умножаем на 2) и добавляем текущий бит
            currentNumber = currentNumber.multiply(BigInteger.valueOf(2))
                    .add(BigInteger.valueOf(bit));

            // Проверяем делимость на 5
            // Сравниваем остаток от деления с нулем
            boolean isDivisible = currentNumber.mod(BigInteger.valueOf(5))
                    .equals(BigInteger.ZERO);
            answer.add(isDivisible);
        }

        return answer;
    }
}