package org.example.g0001_0100.s0067_add_binary;
// #Easy #String #Math #Bit_Manipulation #Simulation
// #Top_Interview_150_Bit_Manipulation
/**
 * 67. Add Binary
 *
 * Задача требует сложить две двоичные строки и вернуть
 * их сумму также в виде двоичной строки. Например:
 * Ввод: a = "11", b = "1"
 * Вывод: "100"
 *
 * todo надо ещё над материалом поработать
 * todo переделать
 *
 */
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1; // Указатель для строки a (начинаем с конца)
        int j = b.length() - 1; // Указатель для строки b (начинаем с конца)
        int carry = 0; // Перенос разряда

        // Пока есть биты для сложения или есть перенос
        while (i >= 0 || j >= 0 || carry > 0) {
            // Получаем текущие биты (или 0, если строка закончилась)
            int digitA = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int digitB = (j >= 0) ? b.charAt(j--) - '0' : 0;

            // Суммируем биты и перенос
            int sum = digitA + digitB + carry;

            // Определяем новый бит и перенос
            result.append(sum % 2); // Добавляем младший бит суммы
            carry = sum / 2; // Вычисляем перенос для следующего разряда
        }

        // Разворачиваем результат, так как добавляли биты от младших к старшим
        return result.reverse().toString();
    }
}