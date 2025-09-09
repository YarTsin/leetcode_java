package org.example.g0801_0900.s0832_flipping_an_image;

// #Easy #Array #Matrix #Two_Pointers #Simulation #Bit

/**
 * 832. Flipping an Image
 * Дана бинарная матрица image размером n × n. Необходимо:
 * Перевернуть каждую строку матрицы горизонтально (то есть в обратном порядке)
 * Инвертировать каждый элемент матрицы (заменить 0 на 1 и 1 на 0)
 * (примеры внизу)
 *
 * Решение - однопроходный алгоритм с двумя указателями
 * Самое быстрое 0 ms
 *
 * Сложность: O(n²) по времени, O(1) по дополнительной памяти
 */
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int matrixSize = image.length;

        // Проходим по каждой строке матрицы
        for (int row = 0; row < matrixSize; row++) {
            int leftPointer = 0;
            int rightPointer = matrixSize - 1;

            // Переворачиваем строку с одновременной инверсией
            while (leftPointer <= rightPointer) {
                // Меняем местами и инвертируем элементы
                int temp = image[row][leftPointer];
                image[row][leftPointer] = 1 - image[row][rightPointer];
                image[row][rightPointer] = 1 - temp;

                leftPointer++;
                rightPointer--;
            }
        }

        return image;
    }
}
/*
Пример 1
Вход: image = [[1,1,0],[1,0,1],[0,0,0]]
Процесс:
Переворачиваем каждую строку: [[0,1,1],[1,0,1],[0,0,0]]
Инвертируем: [[1,0,0],[0,1,0],[1,1,1]]
Выход: [[1,0,0],[0,1,0],[1,1,1]]

Пример 2
Вход: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Процесс:
Переворачиваем: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]
Инвертируем: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Выход: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 */