package org.example.g1401_1500.s1450_number_of_students_doing_homework_at_a_given_time;

/**
 * Решение с Stream API (Java 8)
 */
class Solution2 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        // Создаем поток индексов от 0 до (длина массива - 1)
        // Фильтруем только тех студентов, у которых queryTime входит в интервал
        // Подсчитываем количество оставшихся студентов в потоке
        return (int) java.util.stream.IntStream
                .range(0, startTime.length)
                .filter(studentIndex -> startTime[studentIndex] <= queryTime &&
                        queryTime <= endTime[studentIndex])
                .count();
    }
}
