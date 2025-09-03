package org.example.g0401_0500.s0434_number_of_segments_in_a_string;

/**
 * Решение с использованием встроенных методов
 * Объяснение:
 * trim(): Удаляет пробелы в начале и конце строки
 * split("\s+"): Разделяет строку по одному или более пробелам
 * Подсчет элементов: Возвращает количество элементов в массиве
 */
class Solution2 {
    public int countSegments(String s) {
        // Удаляем ведущие и trailing пробелы
        String trimmed = s.trim();

        // Если строка пустая после trim, возвращаем 0
        if (trimmed.isEmpty()) {
            return 0;
        }

        // Разделяем по одному или более пробелам
        String[] segments = trimmed.split("\\s+");

        return segments.length;
    }
}
