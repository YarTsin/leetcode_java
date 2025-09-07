package org.example.g0601_0700.s0693_binary_number_with_alternating_bits;

/**
 * Альтернативное решение (С использованием строк)
 * Сложность:
 * Временная: O(log n) - преобразование в строку + проверка
 * Пространственная: O(log n) - для хранения строки
 */
class Solution3 {
    public boolean hasAlternatingBits(int n) {
        String binary = Integer.toBinaryString(n);
        for (int i = 1; i < binary.length(); i++) {
            if (binary.charAt(i) == binary.charAt(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
