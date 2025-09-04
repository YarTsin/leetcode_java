package org.example.g0501_0600.s0551_student_attendance_record_i;

/**
 *  Альтернативное решение с использованием встроенных методов
 *
 *  Подход:
 * Используем встроенные методы String для проверки условий:
 * indexOf и lastIndexOf для проверки количества отсутствий
 * contains для проверки трех опозданий подряд
 *
 * Преимущества:
 * Более лаконичный код
 * Легче для чтения и понимания
 *
 * Недостатки:
 * Может быть менее эффективным из-за многократного сканирования строки
 * В худшем случае требует 3 прохода по строке
 */
class Solution2 {
    public boolean checkRecord(String s) {
        // Проверяем количество отсутствий: не более одного
        // indexOf('A') != lastIndexOf('A') означает, что есть как минимум два 'A'
        boolean hasMultipleAbsences = s.indexOf('A') != s.lastIndexOf('A');

        // Проверяем наличие трех опозданий подряд
        boolean hasThreeConsecutiveLates = s.contains("LLL");

        // Награждаем если нет множественных отсутствий И нет трех опозданий подряд
        return !hasMultipleAbsences && !hasThreeConsecutiveLates;
    }
}
