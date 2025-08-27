package org.example.g0201_0300.s0278_first_bad_version;

/**
 * Альтернативное решение - линейный поиск - не оптимально
 * Простой линейный поиск
 * Временная сложность: O(n) - не оптимально
 * Пространственная сложность: O(1)
 * Не удовлетворяет требованию минимального количества вызовов API
 *
 */
public class Solution3 extends VersionControl {
    public Solution3 (int bad) {
        super(bad);
    }

    public int firstBadVersion(int n) {
        for (int i = 1; i <= n; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }
        return n; // Все версии плохие
    }
}
