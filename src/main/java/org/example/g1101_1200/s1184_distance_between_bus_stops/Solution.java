package org.example.g1101_1200.s1184_distance_between_bus_stops;

// #Easy #Array #Circle

/**
 * 1184. Distance Between Bus Stops
 *
 * Автобусный маршрут состоит из n остановок, расположенных по кругу.
 * Расстояния между соседними остановками заданы массивом distance,
 * где distance[i] - расстояние между остановками i и (i + 1) % n.
 * (примеры внизу)
 *
 * Ограничения:
 * 1 <= n <= 10^4
 * distance.length == n
 * 0 <= start, destination < n
 * 0 <= distance[i] <= 10^4
 *
 * Решение - последовательное - самое быстрое - 0 ms
 *
 * Подход:
 * Вычислить общее расстояние всего кругового маршрута
 * Вычислить расстояние прямого направления от start до destination
 * Расстояние обратного направления = общее расстояние - прямое расстояние
 * Вернуть минимум из прямого и обратного расстояний
 *
 * Сложность: O(n) - один проход по массиву
 * Память: O(1) - постоянное использование памяти
 */
class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // Если начальная и конечная остановки совпадают
        if (start == destination) {
            return 0;
        }

        // Убедимся, что start всегда меньше destination для упрощения расчета
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }

        int totalDistance = 0;
        int forwardDistance = 0;

        // Вычисляем общее расстояние и прямое расстояние
        for (int i = 0; i < distance.length; i++) {
            totalDistance += distance[i];

            // Добавляем к прямому расстоянию, если находимся между start и destination
            if (i >= start && i < destination) {
                forwardDistance += distance[i];
            }
        }

        // Обратное расстояние = общее расстояние - прямое расстояние
        int backwardDistance = totalDistance - forwardDistance;

        // Возвращаем минимальное из двух расстояний
        return Math.min(forwardDistance, backwardDistance);
    }
}
/*
Пример 1
Ввод: distance = [1,2,3,4], start = 0, destination = 1
Вывод: 1
Объяснение:
Расстояние между остановками 0 и 1 составляет 1 (прямое движение)

Пример 2
Ввод: distance = [1,2,3,4], start = 0, destination = 2
Вывод: 3
Объяснение:
Прямое движение: 0→1→2 = 1 + 2 = 3
Обратное движение: 0→3→2 = 4 + 3 = 7
Минимальное расстояние: 3

Пример 3
Ввод: distance = [1,2,3,4], start = 0, destination = 3
Вывод: 4
Объяснение:
Прямое движение: 0→3 = 4 (через последний элемент)
Обратное движение: 0→1→2→3 = 1 + 2 + 3 = 6
Минимальное расстояние: 4


 */