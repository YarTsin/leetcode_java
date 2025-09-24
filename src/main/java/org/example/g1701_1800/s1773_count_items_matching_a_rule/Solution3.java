package org.example.g1701_1800.s1773_count_items_matching_a_rule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Использование Map для хранения индексов (более гибкое, но с overhead)
 * Это решение демонстрирует подход, который может быть полезен, если
 * бы атрибутов было очень много. Мы заранее создаем Map, которая
 * сопоставляет название атрибута (ruleKey) с его индексом.
 *
 * Подход:
 * Создается и инициализируется HashMap для хранения пар ("type", 0),
 * ("color", 1), ("name", 2).
 * Индекс для сравнения извлекается из Map по ключу ruleKey.
 *
 */
class Solution3 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int matchingCount = 0;

        // Создаем и инициализируем Map для связи ruleKey с индексом
        Map<String, Integer> ruleKeyToIndexMap = new HashMap<>();
        ruleKeyToIndexMap.put("type", 0);
        ruleKeyToIndexMap.put("color", 1);
        ruleKeyToIndexMap.put("name", 2);

        // Получаем индекс из Map. getOrDefault не нужен, так как по условию ruleKey корректен.
        int attributeIndexToCheck = ruleKeyToIndexMap.get(ruleKey);

        for (List<String> singleItem : items) {
            if (singleItem.get(attributeIndexToCheck).equals(ruleValue)) {
                matchingCount++;
            }
        }

        return matchingCount;
    }
}