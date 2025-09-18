package org.example.g1401_1500.s1450_number_of_students_doing_homework_at_a_given_time;

// #Easy #Array #Stream

/**
 * 1450. Number of Students Doing Homework at a Given Time
 *
 * Даны два целочисленных массива startTime и endTime одинаковой
 * длины n, а также целое число queryTime.
 *
 * Студент i выполнял домашнюю задачу в интервале времени
 * от startTime[i] до endTime[i] включительно. Необходимо
 * вернуть количество студентов, которые выполняли домашнюю
 * задание в конкретный момент времени queryTime.
 *
 * Более формально: нужно посчитать количество индексов i таких,
 * что queryTime ∈ [startTime[i], endTime[i]].
 * (примеры внизу)
 *
 * Решение - линейный проход - самое быстрое - 0 ms
 *
 * Проходим по всем студентам и для каждого проверяем,
 * попадает ли queryTime в его интервал занятий [startTime[i], endTime[i]].
 * Это может быть хорошим решением, так как нам в любом случае нужно
 * проверить каждого студента
 *
 *
 */
class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        // Инициализируем счетчик студентов, которые занимались в queryTime
        int countBusyStudents = 0;

        // Получаем количество студентов (длину любого из массивов)
        int numberOfStudents = startTime.length;

        // Проходим по всем студентам
        for (int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++) {
            // Для каждого студента проверяем, попадает ли queryTime в его интервал
            boolean isStudentBusy = (startTime[studentIndex] <= queryTime) &&
                    (queryTime <= endTime[studentIndex]);

            // Если студент занимался в queryTime, увеличиваем счетчик
            if (isStudentBusy) {
                countBusyStudents++;
            }
        }

        // Возвращаем общее количество занятых студентов
        return countBusyStudents;
    }
}
/*
Пример 1
Входные данные: startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
Выходные данные: 1
Объяснение:
- Студент 0: [1,3] → 4 не входит в интервал
- Студент 1: [2,2] → 4 не входит в интервал
- Студент 2: [3,7] → 4 входит в интервал
Только студент 2 выполнял задание в момент времени 4.

Пример 2
Входные данные: startTime = [4], endTime = [4], queryTime = 4
Выходные данные: 1
Объяснение:
- Единственный студент выполнял задание в интервале [4,4],
  поэтому в момент времени 4 он определенно занимался.

Пример 3
Входные данные: startTime = [1,1,1,1], endTime = [1,3,2,4], queryTime = 7
Выходные данные: 0
Объяснение:
- Ни один из студентов не занимался в момент времени 7,
  так как все интервалы заканчиваются до этого времени.
 */
