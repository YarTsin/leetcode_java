package org.example.g1001_1100.s1071_greatest_common_divisor_of_strings;

// #Easy #String #Math #LeetCode_75_Array/String


/**
 * 1071. Greatest Common Divisor of Strings
 *
 * Для двух строк str1 и str2 говорят, что строка
 * x делит обе эти строки, если:
 * str1 = x + x + ... + x (повторена n раз)
 * str2 = x + x + ... + x (повторена m раз)
 * Где n и m - целые неотрицательные числа.
 * Задача: Найти наибольшую строку x, которая делит как str1, так и str2.
 *
 * Пример 1
 * Ввод: str1 = "ABCABC", str2 = "ABC"  * Вывод: "ABC"
 *
 * Пример 2
 * Ввод: str1 = "ABABAB", str2 = "ABAB"  * Вывод: "AB"
 *
 * Эта задача аналогична нахождению наибольшего общего делителя (НОД)
 * для чисел, но для строк. Если существует строка-делитель x, то:
 * Длина str1 должна делиться на длину x
 * Длина str2 должна делиться на длину x
 * x должен быть префиксом обеих строк
 *
 * Решение - математический подход - самое быстрое - 0 ms
 *
 */
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Проверяем, имеют ли строки общий делитель
        // Это ключевое условие: если str1 + str2 != str2 + str1,
        // то у них нет общего делителя
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Если общий делитель существует, его длина должна быть
        // равна НОД длин обеих строк
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    // Вспомогательная функция для вычисления НОД двух чисел
    // Используем алгоритм Евклида
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
