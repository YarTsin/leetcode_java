package org.example.g0901_1000.s0933_number_of_recent_calls;

import java.util.ArrayList;
import java.util.List;

/**
 * Еще одно решение (Binary Search с ArrayList)
 * Используем ArrayList для хранения всех запросов
 * и бинарный поиск для нахождения границы.
 */
class Solution3 {
    private List<Integer> requests;

    public Solution3() {
        requests = new ArrayList<>();
    }

    public int ping(int t) {
        requests.add(t);

        // Находим минимальное время, которое должно быть включено
        int minTime = t - 3000;

        // Используем бинарный поиск для нахождения индекса первого подходящего элемента
        int left = 0;
        int right = requests.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (requests.get(mid) < minTime) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Количество запросов от left до конца списка
        return requests.size() - left;
    }
}