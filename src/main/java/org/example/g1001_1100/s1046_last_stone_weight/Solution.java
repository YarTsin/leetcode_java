package org.example.g1001_1100.s1046_last_stone_weight;

// #Easy #Array #Heap_Priority_Queue #Game

import java.util.PriorityQueue;
import java.util.Collections;

/**
 * 1046. Last Stone Weight
 *
 * Дан массив целых чисел stones, где stones[i] -
 * это вес i-го камня. Мы играем в игру с камнями следующим образом:
 * На каждом ходу мы выбираем два самых "тяжелых камня" и сталкиваем
 * их друг с другом. Предположим, что самые тяжелые камни имеют
 * веса x и y, где x <= y.
 *
 * Игра продолжается до тех пор, пока не останется
 * не более одного камня. Необходимо вернуть вес последнего
 * оставшегося камня. Если камней не осталось, вернуть 0.
 *
 * Пример
 * Ввод: stones = [2,7,4,1,8,1]
 * Вывод: 1
 * Объяснение:
 * 1. Выбираем 8 и 7, получаем 8-7=1 → stones = [2,4,1,1,1]
 * 2. Выбираем 2 и 4, получаем 4-2=2 → stones = [2,1,1,1]
 * 3. Выбираем 2 и 1, получаем 2-1=1 → stones = [1,1,1]
 * 4. Выбираем 1 и 1, оба уничтожаются → stones = [1]
 * 5. Остается один камень весом 1
 *
 * Решение - с использованием Max-Heap
 * 2-е по скорости - 1 ms
 *
 * Сложность:
 * Временная сложность: O(n log n) - каждое извлечение и добавление в кучу занимает O(log n)
 * Пространственная сложность: O(n) - для хранения кучи
 *
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        // Создаем max-heap с помощью обратного компаратора
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Добавляем все камни в кучу
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Пока в куче больше одного камня
        while (maxHeap.size() > 1) {
            // Извлекаем два самых тяжелых камня
            int firstStone = maxHeap.poll(); // Самый тяжелый
            int secondStone = maxHeap.poll(); // Второй по тяжести

            // Если камни разного веса, добавляем разницу обратно в кучу
            if (firstStone != secondStone) {
                int newStone = firstStone - secondStone;
                maxHeap.offer(newStone);
            }
            // Если камни одинакового веса, они оба уничтожаются (ничего не добавляем)
        }

        // Если остался один камень, возвращаем его вес, иначе 0
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}