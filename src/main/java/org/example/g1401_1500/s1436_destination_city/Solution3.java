package org.example.g1401_1500.s1436_destination_city;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Решение с использованием Map
 * Объяснение подхода:
 * Подсчет степени: Используем Map для подсчета "степени" каждого города
 * Логика подсчета: +1 за исходящий путь, -1 за входящий путь
 * Идентификация: Город назначения имеет степень -1 (только входящие пути)
 * Универсальность: Может быть расширено для более сложных графов
 *
 * Временная сложность: O(n)
 * Пространственная сложность: O(n)
 *
 */
class Solution3 {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> cityDegree = new HashMap<>();

        // Для каждого города считаем "степень": +1 за исходящий путь, -1 за входящий
        for (List<String> path : paths) {
            String from = path.get(0);
            String to = path.get(1);

            cityDegree.put(from, cityDegree.getOrDefault(from, 0) + 1);
            cityDegree.put(to, cityDegree.getOrDefault(to, 0) - 1);
        }

        // Город назначения имеет степень -1 (только входящие пути)
        for (Map.Entry<String, Integer> entry : cityDegree.entrySet()) {
            if (entry.getValue() == -1) {
                return entry.getKey();
            }
        }

        return "";
    }
}