package org.example.g0501_0600.s0557_reverse_words_in_a_string_iii;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Решение с использованием встроенных средств
 *
 * Преимущества:
 * Очень лаконичный код
 * Функциональный стиль программирования
 *
 * Недостатки:
 * Наименее эффективен по производительности
 * Создает много временных объектов
 */
class Solution3 {
    public String reverseWords(String s) {
        return Arrays.stream(s.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }
}
