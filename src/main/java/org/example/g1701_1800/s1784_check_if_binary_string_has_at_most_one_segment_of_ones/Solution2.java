package org.example.g1701_1800.s1784_check_if_binary_string_has_at_most_one_segment_of_ones;

/**
 * Поиск перехода от 0 к 1
 * Это решение явно проходит по строке и ищет переход от '0' к '1'.
 *  *
 * Подход:
 * Проходим по строке от первого символа до предпоследнего,
 * ищем ситуацию, когда текущий символ '0', а следующий '1'.
 */
class Solution2 {
    public boolean checkOnesSegment(String s) {
        // Проходим по строке, начиная с индекса 0 до предпоследнего символа
        for (int i = 0; i < s.length() - 1; i++) {
            char currentChar = s.charAt(i);
            char nextChar = s.charAt(i + 1);

            // Если нашли переход "0" -> "1", значит есть второй сегмент
            if (currentChar == '0' && nextChar == '1') {
                return false;
            }
        }

        // Если не нашли ни одного перехода "0" -> "1", значит сегмент только один
        return true;
    }
}