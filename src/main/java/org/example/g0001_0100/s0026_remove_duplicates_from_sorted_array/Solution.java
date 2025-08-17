package org.example.g0001_0100.s0026_remove_duplicates_from_sorted_array;

/**
 * LeetCode #Easy #Array
 * Задача требует удалить дубликаты из отсортированного массива на месте
 * (без использования дополнительной памяти) и вернуть новую длину массива без дубликатов.
 *
 * Вход: nums = [0,0,1,1,1,2,2,3,3,4]
 * Выход: 5 (и первые 5 элементов массива должны быть [0,1,2,3,4])
 *
 * Используем 2 указателя
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) { //пограничные условия
            return n;
        }

        int uniquePointer = 0; // отслеживает последний уникальный элемент
        int currentPointer = 1; // сканирует массив


        while (currentPointer < n) {
            // если найден новый уникальный элемент - сдвигаем его вперед
            if (nums[uniquePointer] != nums[currentPointer]) {
                uniquePointer++;
                nums[uniquePointer] = nums[currentPointer];
            }
            currentPointer++;
        }
        return uniquePointer + 1;
    }
}