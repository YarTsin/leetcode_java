package org.example.g0201_0300.s0252_meeting_rooms;

/**
 * Решение перебором
 */
public class Solution2 {
    public boolean canAttendMeetings(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                // Проверяем пересечение интервалов i и j
                if (Math.max(intervals[i][0], intervals[j][0]) < Math.min(intervals[i][1], intervals[j][1])) {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
Плюсы: Простота реализации
Минусы: Сложность O(n²), что неэффективно для больших массивов
 */
