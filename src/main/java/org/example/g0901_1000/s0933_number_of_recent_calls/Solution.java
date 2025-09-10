package org.example.g0901_1000.s0933_number_of_recent_calls;

// #Easy #Design #Queue #Data_Stream #LeetCode_75_Queue
// #SpecialClassName


import java.util.LinkedList;
import java.util.Queue;

/**
 * 933. Number of Recent Calls
 *
 * Важно
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 *
 * Нужно реализовать класс RecentCounter, который подсчитывает количество
 * запросов за последние 3000 миллисекунд (включая текущий запрос).
 *
 * Класс должен иметь:
 * Конструктор RecentCounter() - инициализирует счетчик
 * Метод int ping(int t) - добавляет запрос в момент времени t
 * (в миллисекундах) и возвращает количество запросов за последние 3000 мс
 *
 * Важные особенности:
 * Гарантируется, что каждый вызов ping использует строго большее значение t,
 * чем предыдущий
 * Запросы приходят в хронологическом порядке
 * Временной интервал [t-3000, t] включительно
 * (примеры внизу)
 *
 * Решение - queue - самое быстрое - 22 ms
 *
 * Подход:
 * Используем очередь (Queue) для хранения временных меток запросов.
 * При каждом вызове ping():
 * Добавляем текущее время в очередь
 * Удаляем из начала очереди все запросы, которые вышли за пределы 3000 мс
 * Возвращаем размер очереди
 *
 * Сложность:
 * Время: O(n) в худшем случае, но амортизированно O(1)
 * Память: O(n) для хранения запросов
 */
class Solution { //ЕСЛИ СДАЕТЕ НА ПРОВЕРКУ КЛАСС ДОЛЖЕН НАЗЫВАТЬСЯ RecentCounter
    private Queue<Integer> requests;

    public Solution() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        // Добавляем текущий запрос в очередь
        requests.offer(t);

        // Удаляем все запросы, которые старше чем t - 3000
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }

        // Возвращаем количество запросов в актуальном временном окне
        return requests.size();
    }
}

/*
Пример
Input:
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]

Output: [null, 1, 2, 3, 3]

Объяснение:
RecentCounter recentCounter = new RecentCounter();
recentCounter.ping(1);     // запросы = [1], диапазон [-2999,1] → 1 запрос
recentCounter.ping(100);   // запросы = [1, 100], диапазон [-2900,100] → 2 запроса
recentCounter.ping(3001);  // запросы = [1, 100, 3001], диапазон [1,3001] → 3 запроса
recentCounter.ping(3002);  // запросы = [1, 100, 3001, 3002], диапазон [2,3002] → 3 запроса

 */
