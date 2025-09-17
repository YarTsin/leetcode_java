package org.example.g1401_1500.s1436_destination_city;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Решение с двумя Set
 * Объяснение подхода:
 * Два множества: Одно для всех городов, другое только для городов отправления
 * Разность множеств: Город назначения = все города - города отправления
 * Более общий подход: Может быть полезен для более сложных сценариев
 *
 * Временная сложность: O(n)
 * Пространственная сложность: O(n)
 */
class Solution2 {
    public String destCity(List<List<String>> paths) {
        Set<String> allCities = new HashSet<>();
        Set<String> departureCities = new HashSet<>();

        // Собираем все города и отдельно города отправления
        for (List<String> path : paths) {
            String from = path.get(0);
            String to = path.get(1);

            allCities.add(from);
            allCities.add(to);
            departureCities.add(from);
        }

        // Город назначения - тот, который есть в allCities но нет в departureCities
        for (String city : allCities) {
            if (!departureCities.contains(city)) {
                return city;
            }
        }

        return "";
    }
}
