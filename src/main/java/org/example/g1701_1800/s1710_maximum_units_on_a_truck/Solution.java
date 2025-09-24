package org.example.g1701_1800.s1710_maximum_units_on_a_truck;

// #Easy #Array #Sorting #Greedy #Компаратор

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1710. Maximum Units on a Truck
 *
 * Нужно загрузить максимальное количество единиц товара в грузовик. Даны:
 * Массив boxTypes, где boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]
 * numberOfBoxesi - количество ящиков типа i
 * numberOfUnitsPerBoxi - количество единиц товара в каждом ящике типа i
 * Целое число truckSize - максимальное количество ящиков, которые
 * можно загрузить в грузовик
 * Цель: максимизировать общее количество единиц товара, которое можно перевезти.
 * (примеры внизу)
 *
 * Решение - Greedy + Sorting - не быстрое - 9 ms
 *
 * Подход:
 * Сначала сортируем ящики по убыванию количества единиц товара в ящике.
 * Затем берем ящики с наибольшим количеством единиц,
 * пока не заполним грузовик.
 *
 * Время: O(n log n) - из-за сортировки
 * Память: O(1) - не используем дополнительную память
 */
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Сортируем массив по количеству единиц в ящике в порядке убывания
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1]; // Сравниваем по количеству единиц (второй элемент)
            }
        });

        int totalUnits = 0;
        int boxesLoaded = 0;

        // Проходим по всем типам ящиков
        for (int[] boxType : boxTypes) {
            int numberOfBoxes = boxType[0];
            int unitsPerBox = boxType[1];

            // Сколько ящиков этого типа можем взять
            int boxesToTake = Math.min(numberOfBoxes, truckSize - boxesLoaded);

            // Добавляем единицы товара
            totalUnits += boxesToTake * unitsPerBox;
            boxesLoaded += boxesToTake;

            // Если грузовик заполнен, выходим
            if (boxesLoaded >= truckSize) {
                break;
            }
        }

        return totalUnits;
    }
}
/*
Пример 1
Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
Output: 8
Объяснение:
1 ящик типа 0 (3 единицы) = 3 единицы
2 ящика типа 1 (2 единицы) = 4 единицы
1 ящик типа 2 (1 единица) = 1 единица
Итого: 3 + 4 + 1 = 8 единиц

Пример 2
Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
Output: 91
Объяснение:
5 ящиков типа 0 (10 единиц) = 50 единиц
3 ящика типа 3 (9 единиц) = 27 единиц
2 ящика типа 2 (7 единиц) = 14 единиц
Итого: 50 + 27 + 14 = 91 единица

 */