package org.example.g0901_1000.s0914_x_of_a_kind_in_a_deck_of_cards;

// #Easy #Array #Hash_Table #Math #Counting #Number_Theory

import java.util.HashMap;
import java.util.Map;

/**
 * 914. X of a Kind in a Deck of Cards
 * Условие задачи:
 * Дан массив целых чисел deck, где deck[i] представляет значение карты.
 * Необходимо определить, можно ли разбить все карты на одну или несколько
 * групп так, чтобы:
 * - Каждая группа содержала ровно X карт
 * - Все карты в одной группе имели одинаковое значение
 * - X ≥ 2
 *
 * Проще говоря: Можно ли перетасовать колоду так, чтобы карты
 * с одинаковыми значениями были сгруппированы в группы одинакового
 * размера (не менее 2 карт в группе).
 * (примеры внизу)
 *
 * Решение
 * Нахождение наибольшего общего делителя частот
 * Не быстрое - 10 ms
 *
 * Сложность:
 * Временная: O(N log N), где N - количество карт
 * Пространственная: O(N) для хранения частот
 *
 */
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        // Если в колоде меньше 2 карт, невозможно создать группы размером ≥ 2
        if (deck.length < 2) {
            return false;
        }

        // Создаем HashMap для подсчета частоты каждой карты
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int card : deck) {
            frequencyMap.put(card, frequencyMap.getOrDefault(card, 0) + 1);
        }

        // Находим НОД всех частот
        int gcdValue = -1;
        for (int frequency : frequencyMap.values()) {
            if (gcdValue == -1) {
                gcdValue = frequency;
            } else {
                gcdValue = gcd(gcdValue, frequency);
            }

            // Если НОД стал 1, можно сразу вернуть false
            if (gcdValue == 1) {
                return false;
            }
        }

        // Если НОД ≥ 2, можно создать группы
        return gcdValue >= 2;
    }

    // Вспомогательная функция для вычисления НОД (алгоритм Евклида)
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
/*
Пример 1
Вход: deck = [1,2,3,4,4,3,2,1]
Выход: true
Объяснение:
- Группа 1: [1,1], [2,2], [3,3], [4,4]
- Размер группы X = 2

Пример 2
Вход: deck = [1,1,1,2,2,2,3,3]
Выход: false
Объяснение:
- Нельзя создать группы одинакового размера
- Можно [1,1], [2,2], [3,3] но остаются лишние карты
- Или [1,1,1], [2,2,2] но для 3 осталась только одна карта

Пример 3
Вход: deck = [1,1,1,1,2,2,2,2,2,2]
Выход: true
Объяснение:
- Группы по 2 карты: [1,1] × 2, [2,2] × 3
- Или группы по 1 карте, но X должен быть ≥ 2

 */
