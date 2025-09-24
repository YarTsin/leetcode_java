package org.example.g1701_1800.s1758_minimum_changes_to_make_alternating_binary_string;

/**
 *  Использование одного цикла с проверкой относительной позиции
 *
 *  Этот подход основан на наблюдении: для шаблона, начинающегося с '0',
 *  символ должен совпадать с четностью своего индекса (т.е., '0'
 *  на четной позиции и '1' на нечетной). Если символ '1' находится
 *  на четной позиции или '0' на нечетной — это ошибка для этого шаблона.
 *  Количество ошибок для второго шаблона можно найти как
 *  длина_строки - ошибки_первого_шаблона.
 */
class Solution2 {
    public int minOperations(String s) {
        int changesForPatternStartWithZero = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // Для шаблона "0101...":
            // На четных индексах (i % 2 == 0) ожидается '0'. Если у нас '1' -> ошибка.
            // На нечетных индексах (i % 2 == 1) ожидается '1'. Если у нас '0' -> ошибка.
            // Оба условия можно компактно записать:
            if (s.charAt(i) - '0' != i % 2) {
                changesForPatternStartWithZero++;
            }
        }
        // changesForPatternStartWithZero - это количество ошибок для шаблона "0101..."
        // Количество ошибок для шаблона "1010..." будет n - changesForPatternStartWithZero
        // (потому что если символ неправильный для одного шаблона, он правильный для другого)
        return Math.min(changesForPatternStartWithZero, n - changesForPatternStartWithZero);
    }
}
