package org.example.g1701_1800.s1790_check_if_one_string_swap_can_make_strings_equal;

/**
 * Проверка всех возможных обменов (неэффективно)
 * Это решение пытается выполнить все возможные обмены и проверить равенство.
 * Чрезвычайно неэффективное решение O(n³), приведено только для демонстрации.
 */
class Solution3 {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;

        char[] arr = s1.toCharArray();

        // Пробуем все возможные обмены
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                // Выполняем обмен
                swap(arr, i, j);
                // Проверяем равенство
                if (new String(arr).equals(s2)) {
                    return true;
                }
                // Возвращаем обратно
                swap(arr, i, j);
            }
        }

        return false;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
