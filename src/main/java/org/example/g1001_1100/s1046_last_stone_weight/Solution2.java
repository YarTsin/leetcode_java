package org.example.g1001_1100.s1046_last_stone_weight;

import java.util.ArrayList;
import java.util.List;

/**
 * Альтернативное решение (сортировка и симуляция)
 * Основной подход:
 * Можно многократно сортировать массив и симулировать
 * процесс столкновения камней.
 *
 * Почему это решение хуже:
 * Многократная сортировка менее эффективна
 * В худшем случае требуется O(n² log n) времени
 */
class Solution2 {
    public int lastStoneWeight(int[] stones) {
        List<Integer> stoneList = new ArrayList<>();
        for (int stone : stones) {
            stoneList.add(stone);
        }

        while (stoneList.size() > 1) {
            // Сортируем в порядке убывания
            stoneList.sort((a, b) -> b - a);

            int first = stoneList.get(0);
            int second = stoneList.get(1);

            stoneList.remove(0);
            stoneList.remove(0);

            if (first != second) {
                stoneList.add(first - second);
            }
        }

        return stoneList.isEmpty() ? 0 : stoneList.get(0);
    }
}
