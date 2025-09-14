package org.example.g1101_1200.s1185_day_of_the_week;

// #Easy #Math #Date #Интересно

/**
 * 1185. Day of the Week
 * Дана дата в формате день-месяц-год. Необходимо определить,
 * какой это день недели. Гарантируется, что дата является корректной
 * датой в григорианском календаре.
 *
 * Пример 1
 * Ввод: day = 31, month = 8, year = 2019 * Вывод: "Saturday"
 *
 * Пример 2
 * Ввод: day = 18, month = 7, year = 1999 * Вывод: "Sunday"
 *
 * Ограничения:
 * Даны три целых числа: day, month, year
 * Дата гарантированно существует в григорианском календаре
 * Год в диапазоне [1971, 2100]
 *
 * Решение: использование формулы Зеллера
 * Это самое быстрое решение - 0 ms
 */
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        // Массив с названиями дней недели
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        // Корректируем месяц и год для формулы Зеллера
        int m = month;
        int y = year;

        // Январь и февраль считаются 13 и 14 месяцем предыдущего года
        if (m < 3) {
            m += 12;
            y -= 1;
        }

        int q = day;
        int K = y % 100;  // год века
        int J = y / 100;  // нулевое столетие

        // Вычисляем день недели по формуле Зеллера
        int h = (q + 13*(m+1)/5 + K + K/4 + J/4 + 5*J) % 7;

        // Формула Зеллера возвращает: 0 = Saturday, 1 = Sunday, ..., 6 = Friday
        // Нам нужно преобразовать к: 0 = Sunday, 1 = Monday, ..., 6 = Saturday
        int dayIndex = (h + 6) % 7;

        return daysOfWeek[dayIndex];
    }
}
