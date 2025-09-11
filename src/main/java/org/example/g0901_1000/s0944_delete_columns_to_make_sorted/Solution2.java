package org.example.g0901_1000.s0944_delete_columns_to_make_sorted;

/**
 * Решение с использованием StringBuilder (менее эффективное)
 * Требуется дополнительная память O(n * m) для хранения столбцов
 * Двойной проход по данным
 */
class Solution2 {
    public int minDeletionSize(String[] strs) {
        int rowCount = strs.length;
        int columnCount = strs[0].length();
        int columnsToDelete = 0;

        // Создаем массив StringBuilder для каждого столбца
        StringBuilder[] columns = new StringBuilder[columnCount];
        for (int i = 0; i < columnCount; i++) {
            columns[i] = new StringBuilder();
        }

        // Заполняем каждый StringBuilder символами из соответствующего столбца
        for (String str : strs) {
            for (int j = 0; j < columnCount; j++) {
                columns[j].append(str.charAt(j));
            }
        }

        // Проверяем каждый столбец на отсортированность
        for (StringBuilder column : columns) {
            String columnString = column.toString();
            if (!isSorted(columnString)) {
                columnsToDelete++;
            }
        }

        return columnsToDelete;
    }

    // Вспомогательный метод для проверки отсортированности строки
    private boolean isSorted(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
