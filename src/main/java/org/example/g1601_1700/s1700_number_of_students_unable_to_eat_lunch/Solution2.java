package org.example.g1601_1700.s1700_number_of_students_unable_to_eat_lunch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Решение с использованием очереди (имитация процесса)
 */
class Solution2 {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>();

        // Добавляем всех студентов в очередь
        for (int student : students) {
            studentQueue.offer(student);
        }

        int sandwichIndex = 0;
        int unsuccessfulAttempts = 0; // Счетчик неудачных попыток подряд

        // Пока есть студенты в очереди и бутерброды
        while (!studentQueue.isEmpty() && sandwichIndex < sandwiches.length) {
            int currentStudent = studentQueue.poll();

            if (currentStudent == sandwiches[sandwichIndex]) {
                // Студент берет бутерброд
                sandwichIndex++;
                unsuccessfulAttempts = 0; // Сбрасываем счетчик неудач
            } else {
                // Студент не берет бутерброд, идет в конец очереди
                studentQueue.offer(currentStudent);
                unsuccessfulAttempts++;

                // Если все студенты прошли и никто не взял бутерброд
                if (unsuccessfulAttempts == studentQueue.size()) {
                    break;
                }
            }
        }

        return studentQueue.size();
    }
}
