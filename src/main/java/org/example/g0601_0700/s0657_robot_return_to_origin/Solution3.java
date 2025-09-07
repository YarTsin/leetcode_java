package org.example.g0601_0700.s0657_robot_return_to_origin;

/**
 * Альтернативное решение (Использование массивов)
 * Сложность:
 * Временная: O(n)
 * Пространственная: O(1) - массив фиксированного размера
 */
class Solution3 {
    public boolean judgeCircle(String moves) {
        int[] counts = new int[4]; // [R, L, U, D]

        for (char move : moves.toCharArray()) {
            if (move == 'R') counts[0]++;
            else if (move == 'L') counts[1]++;
            else if (move == 'U') counts[2]++;
            else if (move == 'D') counts[3]++;
        }

        // Количество движений вправо должно равняться количеству влево
        // Количество движений вверх должно равняться количеству вниз
        return counts[0] == counts[1] && counts[2] == counts[3];
    }
}