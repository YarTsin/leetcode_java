package org.example.g0401_0500.s0434_number_of_segments_in_a_string;

/**
 * Решение с двумя указателями
 * Объяснение:
 * Пропуск пробелов: Первый цикл пропускает все пробелы
 * Обнаружение сегмента: Когда находим непробельный символ - это начало сегмента
 * Проход по сегменту: Второй цикл проходит до конца сегмента
 * Подсчет: Увеличиваем счетчик после обработки каждого сегмента
 */
class Solution4 {
    public int countSegments(String s) {
        int segmentCount = 0;
        int left = 0;
        int right = 0;
        int n = s.length();

        while (right < n) {
            // Пропускаем пробелы
            while (right < n && s.charAt(right) == ' ') {
                right++;
            }

            // Если дошли до конца строки
            if (right >= n) {
                break;
            }

            // Нашли начало сегмента
            left = right;

            // Проходим весь сегмент
            while (right < n && s.charAt(right) != ' ') {
                right++;
            }

            segmentCount++;
        }

        return segmentCount;
    }
}
