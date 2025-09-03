package org.example.g0401_0500.s0482_license_key_formatting;

/**
 * Решение с использованием StringBuilder (прямой проход)
 */
class Solution4 {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder cleaned = new StringBuilder();

        // Удаляем дефисы и преобразуем к верхнему регистру
        for (char c : s.toCharArray()) {
            if (c != '-') {
                cleaned.append(Character.toUpperCase(c));
            }
        }

        int n = cleaned.length();
        int firstGroupLength = n % k;
        if (firstGroupLength == 0) {
            firstGroupLength = k;
        }

        StringBuilder result = new StringBuilder();

        // Добавляем первую группу
        result.append(cleaned.substring(0, firstGroupLength));

        // Добавляем остальные группы с дефисами
        for (int i = firstGroupLength; i < n; i += k) {
            result.append('-');
            result.append(cleaned.substring(i, i + k));
        }

        return result.toString();
    }
}
