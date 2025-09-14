package org.example.g1001_1100.s1051_height_checker;

// #Easy #Array #Sorting #Counting_Sort

/**
 * 1051. Height Checker
 * Школа пытается составить очередь студентов по росту.
 * Они ожидают, что очередь будет неубывающей по росту.
 * Однако когда студенты выстроились, некоторые из них
 * стоят не на своих местах.
 *
 * Вам дан целочисленный массив heights, представляющий
 * текущий порядок студентов, где heights[i] - рост i-го
 * студента в очереди.
 *
 * Вам нужно вернуть количество индексов, где студенты не стоят
 * на правильных позициях, если очередь должна быть упорядочена по неубыванию.
 * (примеры внизу)
 *
 * Решение - Counting Sort - не быстрое решние - 109 ms
 *
 */
class Solution {
    public int heightChecker(int[] heights) {
        // Находим максимальное значение в массиве для создания counting array
        int maxHeight = 0;
        for (int height : heights) {
            if (height > maxHeight) {
                maxHeight = height;
            }
        }

        // Создаем counting array для подсчета частот каждого роста
        int[] heightCounts = new int[maxHeight + 1];
        for (int height : heights) {
            heightCounts[height]++;
        }

        int mismatchCount = 0;
        int currentHeight = 1; // Начинаем с минимального возможного роста

        // Проходим по исходному массиву и сравниваем с ожидаемым порядком
        for (int i = 0; i < heights.length; i++) {
            // Пропускаем heights, которые имеют count = 0
            while (currentHeight <= maxHeight && heightCounts[currentHeight] == 0) {
                currentHeight++;
            }

            // Если текущий элемент не совпадает с ожидаемым в отсортированном порядке
            if (heights[i] != currentHeight) {
                mismatchCount++;
            }

            // Уменьшаем счетчик для текущего роста
            heightCounts[currentHeight]--;
        }

        return mismatchCount;
    }
}
/*
Пример 1
Вход: heights = [1,1,4,2,1,3]
Выход: 3
Объяснение:
Текущий массив: [1,1,4,2,1,3]
Ожидаемый массив: [1,1,1,2,3,4]
Индексы 2, 4, 5 (нумерация с 0) имеют неправильные значения:
- Индекс 2: 4 ≠ 1
- Индекс 4: 1 ≠ 3
- Индекс 5: 3 ≠ 4

Пример 2
Вход: heights = [5,1,2,3,4]
Выход: 4

Пример 3
Вход: heights = [1,2,3,4,5]
Выход: 0
 */
