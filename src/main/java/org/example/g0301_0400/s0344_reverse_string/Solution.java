package org.example.g0301_0400.s0344_reverse_string;

// #Easy #String #Two_Pointers #Recursion

/**
 * 344. Reverse String
 *  Дан массив символов s. Необходимо развернуть массив на месте (in-place),
 *  изменив исходный массив без использования дополнительной памяти.
 *
 * Пример 1
 * Вход: s = ["h","e","l","l","o"]
 * Выход: ["o","l","l","e","h"]
 *
 * Решение с 2 указателями - самое быстрое - 0 ms
 *
 */
class Solution {
    public void reverseString(char[] s) {
        int leftIndex = 0;
        int rightIndex = s.length - 1;

        // Меняем местами символы, двигаясь от краев к центру
        while (leftIndex < rightIndex) {
            // Меняем местами символы на позициях leftIndex и rightIndex
            char temp = s[leftIndex];
            s[leftIndex] = s[rightIndex];
            s[rightIndex] = temp;

            // Перемещаем указатели к центру
            leftIndex++;
            rightIndex--;
        }
    }
}