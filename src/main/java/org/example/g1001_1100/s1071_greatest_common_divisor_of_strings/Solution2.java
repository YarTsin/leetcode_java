package org.example.g1001_1100.s1071_greatest_common_divisor_of_strings;

/**
 * Поиск с проверкой делителей
 * Объяснение:
 * Перебираем возможные длины: От минимальной длины строки до 1
 * Проверяем делимость длин: Длина кандидата должна делить длины обеих строк
 * Проверяем делимость содержимого: Кандидат должен повторяться
 * нужное количество раз, чтобы составить исходные строки
 * Сложность: Время O(min(m,n) × (m+n)), пространство O(m+n)
 */
class Solution2 {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        // Проверяем все возможные длины делителей
        // Начинаем с минимальной длины из двух строк
        for (int i = Math.min(len1, len2); i > 0; i--) {
            // Длина должна делить обе длины строк
            if (len1 % i == 0 && len2 % i == 0) {
                String candidate = str1.substring(0, i);

                // Проверяем, делит ли candidate обе строки
                if (isDivisor(str1, candidate) && isDivisor(str2, candidate)) {
                    return candidate;
                }
            }
        }

        return "";
    }

    // Проверяет, делится ли строка s на делитель divisor
    private boolean isDivisor(String s, String divisor) {
        int len = s.length();
        int divLen = divisor.length();

        // Количество повторений делителя
        int repetitions = len / divLen;

        // Собираем строку из повторений делителя
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repetitions; i++) {
            sb.append(divisor);
        }

        // Проверяем, равна ли собранная строка исходной
        return sb.toString().equals(s);
    }
}
