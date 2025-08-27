package org.example.g1301_1400.s1346_check_if_n_and_its_double_exist;


import java.util.Arrays;

/**
 * Сортировка + Два указателя
 */
class Solution3 {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int pointer = 0;

        for (int i = 0; i < arr.length; i++) {
            int target = 2 * arr[i];

            // Используем бинарный поиск для нахождения target
            int left = 0;
            int right = arr.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (arr[mid] == target && mid != i) {
                    return true;
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}
