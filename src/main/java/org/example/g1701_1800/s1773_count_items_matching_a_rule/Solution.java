package org.example.g1701_1800.s1773_count_items_matching_a_rule;

// #Easy #Array #String

import java.util.List;

/**
 * 1773. Count Items Matching a Rule
 *
 * Вам дан массив items, где каждый элемент items[i] = [type_i, color_i, name_i]
 * описывает тип, цвет и название предмета. Также вам дана строка ruleKey
 * и строка ruleValue.
 *
 * Задача заключается в том, чтобы подсчитать количество предметов
 * в массиве items, которые удовлетворяют заданному правилу.
 *
 * Правило определяется следующим образом:
 * ruleKey может принимать одно из трех значений: "type", "color" или "name".
 * Предмет удовлетворяет правилу, если значение его соответствующего
 * атрибута (type, color или name) совпадает с заданным ruleValue.
 * (примеры внизу)
 *
 * Решение - прямой перебор - 4-е решение - 4 ms
 *
 * Это решение имеет временную сложность O(n), где n - количество элементов
 * в списке items. Это оптимально, так как в худшем случае необходимо проверить
 * каждый элемент. Пространственная сложность составляет O(1), так как
 * мы используем только несколько переменных для счета и индекса.
 *
 */
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        // Инициализируем счетчик подходящих предметов
        int matchingCount = 0;

        // Определяем индекс атрибута для сравнения на основе ruleKey
        int attributeIndexToCheck;

        // Используем switch для наглядности определения индекса
        switch (ruleKey) {
            case "type":
                attributeIndexToCheck = 0; // type всегда на 0-й позиции
                break;
            case "color":
                attributeIndexToCheck = 1; // color всегда на 1-й позиции
                break;
            case "name":
                attributeIndexToCheck = 2; // name всегда на 2-й позиции
                break;
            default:
                // На случай, если ruleKey будет не из списка (по условию задачи это невозможно)
                return 0; // Возвращаем 0, так как правило не определено
        }

        // Проходим по каждому предмету в списке items
        for (List<String> singleItem : items) {
            // Получаем значение атрибута предмета по заранее определенному индексу
            String itemAttributeValue = singleItem.get(attributeIndexToCheck);

            // Сравниваем значение атрибута предмета с ruleValue
            // ВАЖНО: Используем .equals() для сравнения строк, а не ==
            if (itemAttributeValue.equals(ruleValue)) {
                // Если значения совпали, увеличиваем счетчик
                matchingCount++;
            }
        }

        // Возвращаем общее количество найденных предметов
        return matchingCount;
    }
}
/*
Пример 1
items = [["phone","blue","pixel"], ["computer","silver","lenovo"],
        ["phone","gold","iphone"]]
ruleKey = "color"
ruleValue = "silver"
Результат: 1
Объяснение:
Есть только один предмет, у которого атрибут color равен "silver".
Это предмет: ["computer","silver","lenovo"].

Пример 2
items = [["phone","blue","pixel"],["computer","silver","phone"],
         ["phone","gold","iphone"]]
ruleKey = "type"
ruleValue = "phone"
Результат: 2
Объяснение:
Есть два предмета, у которых атрибут type равен "phone".
Это предметы: ["phone","blue","pixel"] и ["phone","gold","iphone"].
Обратите внимание, что предмет ["computer","silver","phone"]
не подходит, потому что его type - это "computer", а не "phone",
даже несмотря на то, что в name у него есть слово "phone".
 */