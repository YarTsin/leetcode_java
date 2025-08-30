package org.example.g0201_0300.s0278_first_bad_version;

// #Easy #Binary_Search #Interactive


/**
 *
 * 278. First Bad Version
 *
 * Задача: Найти первую плохую версию в последовательности версий.
 * Условия:
 * Дано n версий [1, 2, ..., n]
 * (можно ли сказать что это упорядоченная последовательность?)
 * Существует функция isBadVersion(version), которая возвращает:
 * - true если версия плохая
 * - false если версия хорошая
 * Все версии после первой плохой также являются плохими
 * Нужно найти первую плохую версию
 * Количество вызовов функции isBadVersion() должно быть минимальным
 *
 * Формат ввода:
 * int n - количество версий
 * Функция isBadVersion(int version) предоставляется API
 * Формат вывода: Целое число - первая плохая версия
 * примеры внизу
 *
 * Это небыстрое решение - 25 ms
 *
 */
public class Solution extends VersionControl {
    public Solution(int bad) { //УДАЛЯЕМ ЭТИ СТРОКИ ПРИ ОТПРАВКЕ РЕШЕНИЯ
        super(bad);  //УДАЛЯЕМ ЭТИ СТРОКИ ПРИ ОТПРАВКЕ РЕШЕНИЯ
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2; // Предотвращение переполнения

            if (isBadVersion(mid)) {
                // mid - плохая версия, но может быть не первая
                right = mid; // Ищем в левой половине включая mid
            } else {
                // mid - хорошая версия, первая плохая должна быть справа
                left = mid + 1;
            }
        }

        // left указывает на первую плохую версию
        return left;
    }
}
/*
Пример 1
Вход: n = 5, bad = 4
Выход: 4
Объяснение:
isBadVersion(3) → false
isBadVersion(4) → true
isBadVersion(5) → true

Пример 2
Вход: n = 1, bad = 1
Выход: 1

Пример 3
Вход: n = 100, bad = 57
Выход: 57
 */

