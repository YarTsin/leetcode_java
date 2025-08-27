package org.example.g0201_0300.s0278_first_bad_version;

/**
 * Альтернативное решение - бинарный поиск с другим условием
 * Объяснение:
 * Используем дополнительную переменную firstBad
 * Когда находим плохую версию, запоминаем ее и ищем левее
 * Всегда возвращаем последнюю найденную плохую версию
 */
public class Solution2 extends VersionControl {
    public Solution2(int bad) {
        super(bad);
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int firstBad = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                firstBad = mid;      // Запоминаем текущую плохую версию
                right = mid - 1;     // Ищем левее
            } else {
                left = mid + 1;      // Ищем правее
            }
        }

        return firstBad;
    }
}
