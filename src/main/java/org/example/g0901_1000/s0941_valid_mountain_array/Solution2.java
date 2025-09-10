package org.example.g0901_1000.s0941_valid_mountain_array;

/**
 * Проходим по массиву один раз, отслеживая фазу подъема и спуска.
 */
class Solution2 {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;

        if (n < 3) {
            return false;
        }

        int i = 0;

        // Фаза подъема
        while (i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        // Проверяем, что пик не на начале или конце
        if (i == 0 || i == n - 1) {
            return false;
        }

        // Фаза спуска
        while (i < n - 1 && arr[i] > arr[i + 1]) {
            i++;
        }

        // Если дошли до конца - массив горный
        return i == n - 1;
    }
}
