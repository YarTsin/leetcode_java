package org.example.g1301_1400.s1385_find_the_distance_value_between_two_arrays;

// #Easy #Array #Sorting #Binary_Search #Two_Pointers

import java.util.Arrays;

/**
 * 1385. Find the Distance Value Between Two Arrays
 *
 * Даны два целочисленных массива arr1 и arr2,
 * а также целое число d. Необходимо найти "значение расстояния"
 * между массивами.
 *
 * Определение:
 * Значение расстояния - это количество элементов arr1[i] таких,
 * что для всех элементов arr2[j] выполняется:
 * |arr1[i] - arr2[j]| > d
 *
 * Другими словами: элемент из arr1 считается валидным,
 * если он не находится ближе чем d к ЛЮБОМУ элементу из arr2.
 * примеры внизу
 *
 * todo запутанное условие
 *
 * оптимальное решение - сортировка + Бинарный поиск
 *
 * это третье по скорости решение - 3 ms
 */
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;

        for (int num : arr1) {
            if (isValid(num, arr2, d)) {
                count++;
            }
        }

        return count;
    }

    private boolean isValid(int num, int[] arr2, int d) {
        int left = 0;
        int right = arr2.length - 1;

        // Бинарный поиск ближайшего элемента к num в arr2
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (Math.abs(num - arr2[mid]) <= d) {
                return false; // Нашли элемент, который слишком близко
            }

            if (arr2[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return true;
    }
}
/*
Вход: arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
Выход: 2
Объяснение:
Для arr1[0]=4:
|4-10|=6>2, |4-9|=5>2, |4-1|=3>2, |4-8|=4>2 → валиден

Для arr1[1]=5:
|5-10|=5>2, |5-9|=4>2, |5-1|=4>2, |5-8|=3>2 → валиден

Для arr1[2]=8:
|8-10|=2, |8-9|=1, |8-1|=7>2, |8-8|=0 → невалиден (есть элементы ≤2)
 */
