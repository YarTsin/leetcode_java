package org.example.g0401_0500.s0482_license_key_formatting;

/**
 * Решение с предварительной очисткой
 *
 * Объяснение:
 * Предварительная очистка: Удаляем дефисы и приводим к верхнему регистру
 * Определение первой группы: Вычисляем длину первой группы
 * Построение результата: Добавляем группы с дефисами
 *
 * Недостатки:
 * Создает промежуточную строку
 * Использует регулярное выражение (может быть медленнее)
 */
class Solution2 {
    public String licenseKeyFormatting(String s, int k) {
        // Удаляем все дефисы и преобразуем к верхнему регистру
        String cleaned = s.replaceAll("-", "").toUpperCase();
        int n = cleaned.length();

        // Определяем длину первой группы
        int firstGroupLength = n % k;
        if (firstGroupLength == 0) {
            firstGroupLength = k;
        }

        StringBuilder result = new StringBuilder();

        // Добавляем первую группу
        result.append(cleaned.substring(0, firstGroupLength));

        // Добавляем остальные группы
        for (int i = firstGroupLength; i < n; i += k) {
            result.append('-');
            result.append(cleaned.substring(i, i + k));
        }

        return result.toString();
    }
}