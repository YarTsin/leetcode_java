package org.example.g0901_1000.s0941_valid_mountain_array;

/**
 * Находим пик, затем проверяем обе стороны от него.
 */
class Solution3 {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;

        if (n < 3) {
            return false;
        }

        // Находим индекс максимального элемента (пика)
        int peakIndex = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[peakIndex]) {
                peakIndex = i;
            }
        }

        // Пик не может быть на краях
        if (peakIndex == 0 || peakIndex == n - 1) {
            return false;
        }

        // Проверяем левую сторону (строгое возрастание)
        for (int i = 0; i < peakIndex; i++) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
        }

        // Проверяем правую сторону (строгое убывание)
        for (int i = peakIndex; i < n - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
