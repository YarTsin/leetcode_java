package org.example.g0001_0100.s0027_remove_element;
// #Easy #Array #Two_Pointers #Top_Interview_150_Array/String

/**
 * 27. Remove Element
 * Нужно удалить все вхождения числа val из массива на месте
 * (без создания нового массива) и вернуть новую длину.
 *
 * Пример: nums = [3, 2, 2, 3], val = 3 → Должно остаться [2, 2, _, _], вернуть 2.
 *
 * Используем 2 указателя (Two Pointers)
 * todo переделать
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0; // указатель для записи правильных элементов
        int fast; // указатель пробегает по массиву

        for (fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast]; // записываем элемент, если он не равен val
                slow++;
            }
        }
        return slow;
    }
}