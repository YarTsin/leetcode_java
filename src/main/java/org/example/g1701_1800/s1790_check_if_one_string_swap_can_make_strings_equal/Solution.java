package org.example.g1701_1800.s1790_check_if_one_string_swap_can_make_strings_equal;

// #Easy #String #Hash_Table #Counting

/**
 * 1790. Check if One String Swap Can Make Strings Equal
 *
 * Даны две строки s1 и s2. Необходимо проверить, можно ли сделать
 * строки равными, выполнив ровно одну операцию обмена в одной из строк.
 * Операция обмена означает выбор двух индексов i и j (i ≠ j)
 * в строке и поменять местами символы на этих позициях.
 *
 * Важные уточнения:
 * Можно выполнить обмен только в одной строке (любой), но только один раз
 * Если строки уже равны, это считается успехом (0 обменов = допустимо)
 * Нужно вернуть true, если возможно сделать строки равными с помощью
 * ровно одной операции обмена, и false в противном случае
 * (примеры внизу)
 *
 * Решение - с подсчетом позиций - самое быстрое 0 ms
 *
 */
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        // Если строки уже равны, возвращаем true сразу
        if (s1.equals(s2)) {
            return true;
        }

        // Проверяем, что строки одинаковой длины
        if (s1.length() != s2.length()) {
            return false;
        }

        // Список для хранения индексов, где символы различаются
        // Нам нужно максимум 2 различия для проверки
        int firstDiffIndex = -1;
        int secondDiffIndex = -1;
        int diffCount = 0;

        // Проходим по всем символам строк
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;

                // Если различий больше 2, можно сразу вернуть false
                if (diffCount > 2) {
                    return false;
                }

                // Сохраняем индексы различий
                if (firstDiffIndex == -1) {
                    firstDiffIndex = i;
                } else {
                    secondDiffIndex = i;
                }
            }
        }

        // Проверяем условия для одного обмена
        // Должно быть ровно 2 различия
        if (diffCount != 2) {
            return false;
        }

        // Проверяем, что обмен символов на найденных позициях делает строки равными
        // Должно выполняться:
        // s1[first] == s2[second] AND s1[second] == s2[first]
        return s1.charAt(firstDiffIndex) == s2.charAt(secondDiffIndex) &&
                s1.charAt(secondDiffIndex) == s2.charAt(firstDiffIndex);
    }
}
/*
Пример 1
Вход: s1 = "bank", s2 = "kanb"
Результат: true
Объяснение:
Обменяем 'b' (индекс 0) и 'k' (индекс 2) в
s1: "bank" → "knab" → "kanb" (s1 становится равной s2)

Пример 2
Вход: s1 = "attack", s2 = "defend"
Результат: false
Объяснение: Строки имеют разную длину или слишком много различий

Пример 3
Вход: s1 = "kelb", s2 = "kelb"
Результат: true
Объяснение: Строки уже равны, операция обмена не требуется

Пример 4
Вход: s1 = "abcd", s2 = "dcba"
Результат: false
Объяснение: Нужно более одного обмена для преобразования

 */
