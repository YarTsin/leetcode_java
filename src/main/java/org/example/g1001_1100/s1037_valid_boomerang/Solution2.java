package org.example.g1001_1100.s1037_valid_boomerang;

/**
 * Короткая форма математического решения
 * Проверяем коллинеарность через площадь треугольника
 * Если площадь равна 0, точки лежат на одной прямой
 */
public class Solution2 {
    public boolean isBoomerang(int[][] points) {
        return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0])
                != (points[2][1] - points[0][1]) * (points[1][0] - points[0][0]);
    }
}
