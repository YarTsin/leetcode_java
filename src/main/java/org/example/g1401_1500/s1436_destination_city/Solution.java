package org.example.g1401_1500.s1436_destination_city;

// #Easy #String #Hash_Table #HashSet

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1436. Destination City
 *
 * Дан список путей paths, где paths[i] = [cityA, cityB]
 * означает, что существует прямой путь из города A в город B.
 * Нужно найти город назначения (destination city), то есть город,
 * который не имеет исходящего пути ни в какой другой город.
 *
 * Город назначения - это город, который появляется только как город
 * назначения в списке путей и никогда как город отправления.
 * (примеры внизу)
 *
 * Ограничения
 * 1 <= paths.length <= 100
 * paths[i].length == 2
 * 1 <= cityA.length, cityB.length <= 10
 * cityA != cityB
 * Все строки состоят из английских букв
 *
 * Решение - использование HashSet - 2-e по скорости - 2 ms
 *
 */
class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> departureCities = new HashSet<>();

        // Собираем все города отправления
        for (List<String> path : paths) {
            departureCities.add(path.get(0));
        }

        // Ищем город, который не является городом отправления
        for (List<String> path : paths) {
            String destinationCity = path.get(1);
            if (!departureCities.contains(destinationCity)) {
                return destinationCity;
            }
        }

        return ""; // По условию всегда будет найден город назначения
    }
}
/*
Пример 1
Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo"
Объяснение:
Путь 1: London → New York
Путь 2: New York → Lima
Путь 3: Lima → Sao Paulo
Sao Paulo - конечный пункт назначения

Пример 2
Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Объяснение:
Путь 1: B → C
Путь 2: D → B
Путь 3: C → A
A - конечный пункт назначения
 */