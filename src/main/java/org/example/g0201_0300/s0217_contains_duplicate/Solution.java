package org.example.g0201_0300.s0217_contains_duplicate;

// #Easy #Top_Interview_Questions #Array #Hash_Table #Sorting

import java.util.HashSet;
import java.util.Set;


/**
 * 217. Contains Duplicate
 *
 * Дан массив целых чисел. Нужно определить, содержит ли массив дубликаты
 * - то есть есть ли хотя бы одно значение, которое встречается
 * в массиве два или более раз
 *
 * todo доделать
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Создаем множество для хранения уникальных элементов
        Set<Integer> uniqueNumbers = new HashSet<>();

        // Проверяем каждый элемент массива
        for (int num : nums) {
            // Если элемент уже есть в множестве - дубликат найден
            if (uniqueNumbers.contains(num)) {
                return true;
            }
            // Добавляем элемент в множество
            uniqueNumbers.add(num);
        }

        // Если дошли до конца - дубликатов нет
        return false;
    }
}