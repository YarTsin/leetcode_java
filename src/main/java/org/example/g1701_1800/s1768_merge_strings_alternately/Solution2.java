package org.example.g1701_1800.s1768_merge_strings_alternately;

/**
 * Один указатель с полным циклом
 * Это решение также использует StringBuilder, но обходится одним циклом,
 * который работает до тех пор, пока не будет достигнут конец самой
 * длинной строки. На каждой итерации проверяется, не вышел ли индекс
 * за пределы соответствующей строки.
 *
 * Подход:
 * Определяем длину самой длинной строки.
 * В цикле от 0 до maxLength - 1 на каждой итерации:
 * Если индекс i меньше длины word1, добавляем символ word1[i].
 * Если индекс i меньше длины word2, добавляем символ word2[i].
 */
class Solution2 {
    public String mergeAlternately(String word1, String word2) {
        int lengthWord1 = word1.length();
        int lengthWord2 = word2.length();
        // Находим длину самой длинной строки
        int maxLength = Math.max(lengthWord1, lengthWord2);

        StringBuilder mergedResult = new StringBuilder();

        // Проходим по индексам от 0 до конца самой длинной строки
        for (int index = 0; index < maxLength; index++) {
            // Если текущий индекс не превышает длину word1, добавляем символ из word1
            if (index < lengthWord1) {
                mergedResult.append(word1.charAt(index));
            }
            // Если текущий индекс не превышает длину word2, добавляем символ из word2
            if (index < lengthWord2) {
                mergedResult.append(word2.charAt(index));
            }
        }

        return mergedResult.toString();
    }
}
