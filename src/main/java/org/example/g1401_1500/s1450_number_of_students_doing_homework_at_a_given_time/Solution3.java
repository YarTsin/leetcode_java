package org.example.g1401_1500.s1450_number_of_students_doing_homework_at_a_given_time;

/**
 * Решение с предварительной сортировкой (менее эффективное)
 * Сложность: O(n log n) по времени из-за сортировки, что хуже чем O(n)
 */
class Solution3 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        // Это решение НЕ рекомендуется к использованию,
        // так как сортировка избыточна и ухудшает производительность
        int countBusyStudents = 0;
        int numberOfStudents = startTime.length;

        // Создаем массив индексов для сортировки (избыточно для данной задачи)
        Integer[] indices = new Integer[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            indices[i] = i;
        }

        // Сортируем по времени начала (бесполезная операция для этой задачи)
        java.util.Arrays.sort(indices, (a, b) -> Integer.compare(startTime[a], startTime[b]));

        // Все равно приходится проверять все интервалы
        for (int index : indices) {
            if (startTime[index] <= queryTime && queryTime <= endTime[index]) {
                countBusyStudents++;
            }
        }

        return countBusyStudents;
    }
}