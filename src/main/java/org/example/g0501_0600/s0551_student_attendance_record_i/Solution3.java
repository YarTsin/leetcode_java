package org.example.g0501_0600.s0551_student_attendance_record_i;

/**
 * Решение с использованием простого подсчета
 *
 * Подход:
 * Проходим по строке, подсчитываем общее количество отсутствий
 * и максимальную серию опозданий, затем проверяем условия.
 */
class Solution3 {
    public boolean checkRecord(String s) {
        int totalAbsences = 0;
        int maxConsecutiveLates = 0;
        int currentConsecutiveLates = 0;

        for (char record : s.toCharArray()) {
            if (record == 'A') {
                totalAbsences++;
                currentConsecutiveLates = 0; // Сбрасываем счетчик опозданий
            } else if (record == 'L') {
                currentConsecutiveLates++;
                maxConsecutiveLates = Math.max(maxConsecutiveLates, currentConsecutiveLates);
            } else { // record == 'P'
                currentConsecutiveLates = 0; // Сбрасываем счетчик опозданий
            }
        }

        // Проверяем оба условия
        return totalAbsences <= 1 && maxConsecutiveLates <= 2;
    }
}
