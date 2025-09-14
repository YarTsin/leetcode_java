package org.example.g1001_1100.s1089_duplicate_zeros;

/**
 *  Подход с дополнительным массивом (проще для понимания)
 *  НАРУШАЕТ in-place
 */
class Solution2 {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        int index = 0;

        // Заполняем временный массив
        for (int i = 0; i < n && index < n; i++) {
            if (arr[i] == 0) {
                temp[index++] = 0;
                if (index < n) {
                    temp[index++] = 0;
                }
            } else {
                temp[index++] = arr[i];
            }
        }

        // Копируем обратно в исходный массив
        System.arraycopy(temp, 0, arr, 0, n);
    }
}
