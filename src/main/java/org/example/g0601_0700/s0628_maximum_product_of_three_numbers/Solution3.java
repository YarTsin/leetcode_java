package org.example.g0601_0700.s0628_maximum_product_of_three_numbers;

import java.util.Arrays;

/**
 * Экспериментальное решение с применением модуля числа
 *
 * (!!!) Не прошло тестов на литкоде
 * Судя по примерам мне показалось что надо
 * переделать в массив по модулю, отсортировать
 * и взять три самых больших числа
 * Возможно я неправильно понял условие
 *
 */
public class Solution3 {
    public int maximumProduct(int[] nums) {
        // Сортируем по убыванию модулей
        Integer[] numsObj = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsObj, (a, b) -> Integer.compare(Math.abs(b), Math.abs(a)));

        // Берем первые три числа (с наибольшими модулями)
        return numsObj[0] * numsObj[1] * numsObj[2];
    }
}
