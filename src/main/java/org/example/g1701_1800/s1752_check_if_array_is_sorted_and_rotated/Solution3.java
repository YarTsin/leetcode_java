package org.example.g1701_1800.s1752_check_if_array_is_sorted_and_rotated;

import java.util.Arrays;

/**
 * Решение с конкатенацией и проверкой сортировки
 * Подход: Создаем удвоенный массив и проверяем,
 * содержится ли отсортированный массив в нем.
 *
 */
class Solution3 {
    public boolean check(int[] nums) {
        int n = nums.length;

        // Создаем копию массива и сортируем ее
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        // Создаем удвоенный массив для поиска повернутой версии
        int[] doubled = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            doubled[i] = nums[i % n];
        }

        // Ищем отсортированный массив в удвоенном массиве
        for (int i = 0; i <= n; i++) {
            boolean found = true;
            for (int j = 0; j < n; j++) {
                if (doubled[i + j] != sorted[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return true;
            }
        }

        return false;
    }
}
