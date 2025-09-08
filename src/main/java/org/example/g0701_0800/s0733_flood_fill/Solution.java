package org.example.g0701_0800.s0733_flood_fill;

// #Easy #Array #Depth_First_Search #Breadth_First_Search #Matrix

/**
 * 733. Flood Fill
 * Задача имитирует алгоритм "заливки" из
 * графических редакторов. Дан изображение в виде 2D матрицы,
 * где каждый элемент представляет цвет пикселя. Также даны координаты
 * начального пикселя и новый цвет. Необходимо выполнить заливку области,
 * содержащей начальный пиксель, новым цветом.
 *
 * Заливка должна распространяться на все пиксели, соединенные
 * 4-направленно (вверх, вниз, влево, вправо) с начальным пикселем
 * и имеющие тот же исходный цвет.
 *
 * Особенности реализации
 * Изображение представлено как int[][] image
 * Размер изображения: m × n, где 1 ≤ m, n ≤ 50
 * Цвета: целые числа 0 ≤ color ≤ 65535
 * Начальные координаты: (sr, sc)
 * Необходимо изменить цвет только connected компоненты
 * (примеры внизу)
 *
 *  Решение с DFS (рекурсия) - самое быстрое решение - 0 ms
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        // Если новый цвет совпадает с исходным, ничего не делаем
        if (originalColor != newColor) {
            dfsFill(image, sr, sc, originalColor, newColor);
        }
        return image;
    }

    private void dfsFill(int[][] image, int row, int col, int originalColor, int newColor) {
        // Проверяем границы и соответствие исходному цвету
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length
                || image[row][col] != originalColor) {
            return;
        }

        // Меняем цвет текущего пикселя
        image[row][col] = newColor;

        // Рекурсивно обрабатываем 4 соседних направления
        dfsFill(image, row - 1, col, originalColor, newColor); // вверх
        dfsFill(image, row + 1, col, originalColor, newColor); // вниз
        dfsFill(image, row, col - 1, originalColor, newColor); // влево
        dfsFill(image, row, col + 1, originalColor, newColor); // вправо
    }
}
/*
Пример 1
Input:
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Объяснение:
Из центра (1,1) с цветом 1 заливается область цветом 2.
Правый нижний угол не меняется, т.к. имеет другой цвет.

Пример 2
Input:
image = [[0,0,0],[0,0,0]]
sr = 0, sc = 0, newColor = 2
Output: [[2,2,2],[2,2,2]]



 */
