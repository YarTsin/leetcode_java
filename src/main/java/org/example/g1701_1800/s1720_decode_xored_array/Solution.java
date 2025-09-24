package org.example.g1701_1800.s1720_decode_xored_array;

// #Easy #Array #Bit_Manipulation #XOR

/**
 * 1720. Decode XORed Array
 *
 * Дан массив encoded длины n, который представляет собой
 * XOR-кодированную версию исходного массива arr длины n + 1.
 *
 * Известно, что:
 * encoded[i] = arr[i] XOR arr[i + 1] для всех i от 0 до n - 1
 * Дан первый элемент исходного массива: first = arr[0]
 * Нужно восстановить и вернуть исходный массив arr.
 *
 * Свойство XOR:
 * a XOR b = c ⇒ a XOR c = b и b XOR c = a
 * a XOR a = 0
 * a XOR 0 = a
 * (примеры внизу)
 *
 * Решение прямое - 2-е по скорости - 1 ms
 *
 * Сложность
 * Время: O(n) - один проход по массиву
 * Память: O(n) - создаем массив результата
 */
class Solution {
    public int[] decode(int[] encoded, int first) {
        // Длина закодированного массива
        int encodedLength = encoded.length;
        // Длина исходного массива на 1 больше
        int originalLength = encodedLength + 1;

        // Создаем массив для исходных данных
        int[] originalArray = new int[originalLength];

        // Устанавливаем первый элемент
        originalArray[0] = first;

        // Восстанавливаем остальные элементы
        for (int i = 0; i < encodedLength; i++) {
            // encoded[i] = originalArray[i] XOR originalArray[i + 1]
            // Следовательно: originalArray[i + 1] = originalArray[i] XOR encoded[i]
            originalArray[i + 1] = originalArray[i] ^ encoded[i];
        }

        return originalArray;
    }
}
/*
Пример 1
Input: encoded = [1,2,3], first = 1
Output: [1,0,2,1]
Объяснение:
arr[0] = first = 1
arr[1] = arr[0] XOR encoded[0] = 1 XOR 1 = 0
arr[2] = arr[1] XOR encoded[1] = 0 XOR 2 = 2
arr[3] = arr[2] XOR encoded[2] = 2 XOR 3 = 1

Пример 2
Input: encoded = [6,2,7,3], first = 4
Output: [4,2,0,7,4]
Объяснение:
arr[0] = 4
arr[1] = 4 XOR 6 = 2
arr[2] = 2 XOR 2 = 0
arr[3] = 0 XOR 7 = 7
arr[4] = 7 XOR 3 = 4
 */