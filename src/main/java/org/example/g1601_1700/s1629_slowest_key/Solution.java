package org.example.g1601_1700.s1629_slowest_key;

// #Easy #Array #String

/**
 * 1629. Slowest Key
 *
 * Дана последовательность нажатий клавиш, представленная в виде:
 * releaseTimes - массив времени отпускания клавиш (в миллисекундах)
 * keysPressed - строка, содержащая символы нажатых клавиш
 * releaseTimes[i] представляет время, когда была отпущена i-я клавиша.
 * Время нажатия i-й клавиши считается временем отпускания предыдущей
 * клавиши (для i=0 время нажатия равно 0).
 *
 * Нужно найти клавишу с наибольшей длительностью нажатия.
 * Если есть несколько клавиш с одинаковой максимальной длительностью,
 * вернуть лексикографически наибольшую (самую "большую" по алфавиту).
 * (примеры внизу)
 *
 * Решение - однопроходный алгоритм - самое быстрое - 1 ms
 *
 * Сложность: O(n) по времени, O(1) по памяти
 */
class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxDuration = releaseTimes[0]; // Длительность первой клавиши
        char resultKey = keysPressed.charAt(0); // Первая клавиша

        for (int i = 1; i < releaseTimes.length; i++) {
            // Вычисляем длительность текущей клавиши
            int currentDuration = releaseTimes[i] - releaseTimes[i - 1];
            char currentKey = keysPressed.charAt(i);

            if (currentDuration > maxDuration) {
                // Новая максимальная длительность
                maxDuration = currentDuration;
                resultKey = currentKey;
            } else if (currentDuration == maxDuration) {
                // Та же длительность, выбираем лексикографически наибольшую
                if (currentKey > resultKey) {
                    resultKey = currentKey;
                }
            }
        }

        return resultKey;
    }
}
/*
Пример 1
Input: releaseTimes = [9,29,49,50], keysPressed = "cbcd"
Output: "c"

Объяснение:
- Клавиша 'c' нажата в time=0 и отпущена в time=9 → длительность = 9
- Клавиша 'b' нажата в time=9 и отпущена в time=29 → длительность = 20
- Клавиша 'c' нажата в time=29 и отпущена в time=49 → длительность = 20
- Клавиша 'd' нажата в time=49 и отпущена в time=50 → длительность = 1

Максимальная длительность = 20, клавиши 'b' и 'c' имеют эту длительность.
Лексикографически наибольшая - 'c'.

Пример 2
Input: releaseTimes = [12,23,36,46,62], keysPressed = "spuda"
Output: "a"
Объяснение:
- 's' → длительность = 12
- 'p' → длительность = 11 (23-12)
- 'u' → длительность = 13 (36-23)
- 'd' → длительность = 10 (46-36)
- 'a' → длительность = 16 (62-46)
Максимальная длительность = 16 у клавиши 'a'.
 */