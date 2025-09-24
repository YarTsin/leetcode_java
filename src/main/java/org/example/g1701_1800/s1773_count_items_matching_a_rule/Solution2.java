package org.example.g1701_1800.s1773_count_items_matching_a_rule;

import java.util.List;

/**
 * Прямое сравнение в условии цикла
 *
 * Это решение избегает шага с switch или if-else для определения индекса,
 * помещая все три возможных проверки прямо внутрь цикла if.
 * Это делает код более громоздким и менее эффективным на практике,
 * так как на каждой итерации выполняется несколько строковых сравнений для ruleKey.
 *
 * Подход:
 * На каждой итерации цикла мы проверяем, чему равен ruleKey,
 * и затем сравниваем соответствующее значение предмета с ruleValue.
 */
class Solution2 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int matchingCount = 0;

        for (List<String> item : items) {
            // Проверяем все три возможных ruleKey для каждого элемента
            if (ruleKey.equals("type") && item.get(0).equals(ruleValue)) {
                matchingCount++;
            } else if (ruleKey.equals("color") && item.get(1).equals(ruleValue)) {
                matchingCount++;
            } else if (ruleKey.equals("name") && item.get(2).equals(ruleValue)) {
                matchingCount++;
            }
            // Если ни одно условие не сработало, переходим к следующему предмету
        }
        return matchingCount;
    }
}
