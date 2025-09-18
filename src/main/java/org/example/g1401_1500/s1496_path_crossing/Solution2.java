package org.example.g1401_1500.s1496_path_crossing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Альтернативное Решение с использованием HashMap
 * Подход: Можно использовать HashMap, где ключ — это координата x,
 * а значение — это множество координат y, которые были посещены
 * для этого x. Это менее прямое решение, но оно также работает.
 *
 * Объяснение: Это решение может быть немного менее эффективным
 * по памяти из-за вложенной структуры данных, но его сложность также O(n).
 */
class Solution2 {
    public boolean isPathCrossing(String path) {
        // Текущие координаты
        int x = 0;
        int y = 0;

        // Map для отслеживания посещенных Y для каждого X
        Map<Integer, Set<Integer>> visitedMap = new HashMap<>();
        // Добавляем начальную точку
        visitedMap.computeIfAbsent(x, k -> new HashSet<>()).add(y);

        for (char direction : path.toCharArray()) {
            // Обновляем координаты
            switch (direction) {
                case 'N': y++; break;
                case 'S': y--; break;
                case 'E': x++; break;
                case 'W': x--; break;
            }

            // Проверяем, существует ли запись для этого X
            if (visitedMap.containsKey(x)) {
                // Если запись существует, проверяем, содержится ли Y в множестве для этого X
                Set<Integer> yCoordinates = visitedMap.get(x);
                if (yCoordinates.contains(y)) {
                    return true;
                }
                // Если Y не найден, добавляем его
                yCoordinates.add(y);
            } else {
                // Если записи для X нет, создаем новое множество для Y и добавляем текущий Y
                Set<Integer> newSet = new HashSet<>();
                newSet.add(y);
                visitedMap.put(x, newSet);
            }
        }
        return false;
    }
}
