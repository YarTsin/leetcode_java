package org.example.g2901_3000.s2970_count_the_number_of_incremovable_subarrays_i;

// #Easy #Array #Binary_Search #Two_Pointers #Enumeration

/**
 * 2970. Count the Number of Incremovable Subarrays I
 * Условие: Дан массив целых чисел nums (с индексацией 0).
 * Подмассив nums[i..j] называется incremovable, если удаление этого
 * подмассива из nums делает оставшийся массив строго возрастающим.
 *
 * Необходимо вернуть количество incremovable подмассивов.
 *
 * Примечание: Подмассив - это contiguous последовательность
 * элементов в массиве. После удаления подмассива оставшиеся
 * элементы должны образовывать строго возрастающую
 * последовательность (каждый элемент строго больше предыдущего).
 * (примеры внизу)
 *
 * todo запутанное условие
 * todo что такое Prefix/Suffix Arrays
 *
 * эффективное решение Two Pointers + Prefix/Suffix Arrays
 * Сложность: O(n²) - время, O(n) - дополнительная память
 *
 * Это третье по скорости решение - 2 ms
 *
 */
class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        // Создаем префиксный массив: prefix[i] = true, если nums[0..i] строго возрастающий
        boolean[] prefix = new boolean[n];
        prefix[0] = true;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] && (nums[i] > nums[i - 1]);
        }

        // Создаем суффиксный массив: suffix[i] = true, если nums[i..n-1] строго возрастающий
        boolean[] suffix = new boolean[n];
        suffix[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] && (nums[i] < nums[i + 1]);
        }

        int count = 0;

        // Перебираем все возможные подмассивы [i, j]
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Проверяем, является ли подмассив [i, j] incremovable
                if (isIncremovable(nums, i, j, prefix, suffix)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isIncremovable(int[] nums, int start, int end,
                                   boolean[] prefix, boolean[] suffix) {
        int n = nums.length;

        // Если удаляем весь массив - оставшийся массив пустой, что считается строго возрастающим
        if (start == 0 && end == n - 1) {
            return true;
        }

        // Если удаляем подмассив с начала
        if (start == 0) {
            return suffix[end + 1];
        }

        // Если удаляем подмассив с конца
        if (end == n - 1) {
            return prefix[start - 1];
        }

        // Если удаляем подмассив из середины, проверяем соединение частей
        return prefix[start - 1] && suffix[end + 1] && (nums[start - 1] < nums[end + 1]);
    }
}

/*
Пример 1
Вход: nums = [1,2,3,4]
Выход: 10
Пояснение: 10 неудалимых подмассивов:
[1], [2], [3], [4], [1,2], [2,3], [3,4], [1,2,3], [2,3,4] и [1,2,3,4],
поскольку при удалении любого из этих подмассивов число nums становится
строго возрастающим (?).
Обратите внимание, что нельзя выбрать пустой подмассив.

Пример 2
Вход: nums = [6,5,7,8]
Выход: 7
Объяснение: Подмассив [5,7] НЕ является incremovable, так как
после его удаления получим [6,8], где 6 < 8, но это не строго
возрастающая последовательность из оставшихся элементов.

 */