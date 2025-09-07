package org.example.g0601_0700.s0657_robot_return_to_origin;

/**
 * Альтернативное решение (Подсчет пар движений)
 * Сложность:
 * Временная: O(n)
 * Пространственная: O(1)
 */
class Solution2 {
    public boolean judgeCircle(String moves) {
        int rightLeft = 0; // Счетчик движений вправо/влево
        int upDown = 0;    // Счетчик движений вверх/вниз

        for (char move : moves.toCharArray()) {
            if (move == 'R') rightLeft++;
            else if (move == 'L') rightLeft--;
            else if (move == 'U') upDown++;
            else if (move == 'D') upDown--;
        }

        return rightLeft == 0 && upDown == 0;
    }
}
