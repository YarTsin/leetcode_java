package org.example.g0501_0600.s0521_longest_uncommon_subsequence_i;


/**
 * Альтернативное решение (более явная логика)
 */
class Solution2 {
    public int findLUSlength(String a, String b) {
        // Получаем длины обеих строк
        int lengthA = a.length();
        int lengthB = b.length();

        // Если строки одинаковые, возвращаем -1
        if (a.equals(b)) {
            return -1;
        }

        // Если длины разные, возвращаем длину более длинной строки
        if (lengthA != lengthB) {
            return Math.max(lengthA, lengthB);
        }

        // Если длины равны, но строки разные,
        // вся любая строка является необычной подпоследовательностью
        return lengthA; // можно вернуть lengthB - результат тот же
    }
}