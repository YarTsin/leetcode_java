package org.example.g0401_0500.s0401_binary_watch;

// #Easy #Bit_Manipulation #Backtracking

import java.util.ArrayList;
import java.util.List;

/**
 * 401. Binary Watch
 * У бинарных часов есть 4 светодиода (0-3) для часов (0-11)
 * и 6 светодиодов (0-5) для минут (0-59). Каждый светодиод
 * представляет собой двоичный бит. Дано целое число turnedOn,
 * которое представляет количество горящих светодиодов.
 * Необходимо вернуть все возможные времена, которые могут
 * отображаться на часах.
 *
 * todo запутанное условие
 *
 * Пример 1
 * Вход: turnedOn = 1
 * Выход: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 *
 * Пример 2
 * Вход: turnedOn = 9
 * Выход: []
 *
 * Ограничения:
 * 0 <= turnedOn <= 10
 *
 * Решение - Bit Counting, O(1) время, O(1) память
 * Не самое быстрое решение - 11 ms
 *
 */
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        // Перебираем все возможные комбинации часов и минут
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                // Подсчитываем количество единичных битов в часах и минутах
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    // Форматируем время в нужный вид
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }

        return result;
    }
}
/*
Пример
Часы: 0 (0 битов), 1 (1 бит), 2 (1 бит), 4 (1 бит), 8 (1 бит)
Минуты: 1,2,4,8,16,32 (все по 1 биту)

Комбинации:
0:01, 0:02, 0:04, 0:08, 0:16, 0:32,
1:00, 2:00, 4:00, 8:00
 */