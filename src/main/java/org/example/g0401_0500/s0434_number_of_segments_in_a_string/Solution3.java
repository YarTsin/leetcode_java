package org.example.g0401_0500.s0434_number_of_segments_in_a_string;

/**
 * Решение с использованием флагов
 * Объяснение:
 * Флаг inSegment: Отслеживает, находимся ли мы внутри сегмента
 * Переключение флага:
 * При переходе от пробела к непробелу - увеличиваем счетчик и устанавливаем флаг
 * При нахождении пробела - сбрасываем флаг
 */
class Solution3 {
    public int countSegments(String s) {
        int segmentCount = 0;
        boolean inSegment = false; // Флаг, указывающий, что мы внутри сегмента

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar != ' ') {
                // Если нашли непробельный символ и мы не в сегменте
                if (!inSegment) {
                    segmentCount++;
                    inSegment = true; // Входим в сегмент
                }
            } else {
                // Нашли пробел - выходим из сегмента
                inSegment = false;
            }
        }

        return segmentCount;
    }
}
