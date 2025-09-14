package org.example.g1001_1100.s1047_remove_all_adjacent_duplicates_in_string;

/**
 * Используем два указателя для имитации стека
 * в исходном массиве символов.
 */
class Solution3 {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        int stackPointer = -1; // Указатель на вершину "стека"

        for (int i = 0; i < chars.length; i++) {
            if (stackPointer >= 0 && chars[stackPointer] == chars[i]) {
                // Найден дубликат - уменьшаем указатель стека
                stackPointer--;
            } else {
                // Добавляем символ в "стек"
                stackPointer++;
                chars[stackPointer] = chars[i];
            }
        }

        // Создаем строку из символов от 0 до stackPointer
        return new String(chars, 0, stackPointer + 1);
    }
}
