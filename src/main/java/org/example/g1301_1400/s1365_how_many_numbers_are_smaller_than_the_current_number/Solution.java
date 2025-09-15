package org.example.g1301_1400.s1365_how_many_numbers_are_smaller_than_the_current_number;

// #Easy #Array #Hash_Table #Sorting #Counting

import java.util.Arrays;

/**
 * 1365. How Many Numbers Are Smaller Than the Current Number
 *
 * Задача: Дан массив целых чисел nums. Для каждого элемента nums[i] нужно
 * посчитать, сколько элементов в массиве меньше чем nums[i].
 *
 * Цель: Вернуть массив answer, где answer[i] равно количеству
 * элементов nums[j] таких что j != i и nums[j] < nums[i].
 * (примеры внизу)
 *
 * Решение - Сортировка с сохранением индексов + подсчет
 * Не быстрое - 6 ms
 *
 * Создаем копию массива с сохранением исходных индексов
 * Сортируем массив
 * Используем тот факт, что в отсортированном массиве количество
 * меньших элементов равно индексу
 * Обрабатываем повторяющиеся значения
 *
 */
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[][] indexedNums = new int[n][2]; // [value, original index]

        // Создаем массив с значениями и исходными индексами
        for (int i = 0; i < n; i++) {
            indexedNums[i][0] = nums[i];
            indexedNums[i][1] = i;
        }

        // Сортируем по значению
        Arrays.sort(indexedNums, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[n];
        int prevCount = 0;

        // Обрабатываем первый элемент
        result[indexedNums[0][1]] = 0;

        // Обрабатываем остальные элементы
        for (int i = 1; i < n; i++) {
            // Если текущее значение равно предыдущему, используем тот же счетчик
            if (indexedNums[i][0] == indexedNums[i - 1][0]) {
                result[indexedNums[i][1]] = prevCount;
            } else {
                // Иначе количество меньших элементов равно текущему индексу
                prevCount = i;
                result[indexedNums[i][1]] = i;
            }
        }

        return result;
    }
}
/*
Пример 1
Вход: nums = [8,1,2,2,3]
Выход: [4,0,1,1,3]
Объяснение:
Для nums[0]=8: есть 4 числа меньше (1,2,2,3)
Для nums[1]=1: нет чисел меньше
Для nums[2]=2: есть 1 число меньше (1)
Для nums[3]=2: есть 1 число меньше (1)
Для nums[4]=3: есть 3 числа меньше (1,2,2)

Пример 2
Вход: nums = [6,5,4,8]
Выход: [2,1,0,3]

Пример 3
Вход: nums = [7,7,7,7]
Выход: [0,0,0,0]
Объяснение: Все числа равны, поэтому нет чисел меньше
 */
