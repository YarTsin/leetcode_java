package org.example.g1301_1400.s1360_number_of_days_between_two_dates;

// #Easy #String #Math #Date


/**
 * 1360. Number of Days Between Two Dates
 *
 * Даны две строки date1 и date2 в формате YYYY-MM-DD.
 * Нужно вычислить количество дней между этими двумя датами.
 *
 * Цель: Вернуть абсолютную разницу в днях между двумя датами.
 *
 * Пример 1
 * Вход: date1 = "2019-06-29", date2 = "2019-06-30"
 * Выход: 1
 *
 * Пример 2
 * Вход: date1 = "2020-01-15", date2 = "2019-12-31"
 * Выход: 15
 * Объяснение: 15 дней между 31 декабря 2019 и 15 января 2020
 *
 * Пример 3
 * Вход: date1 = "1971-01-01", date2 = "2100-12-31"
 * Выход: 47482
 *
 * Решение: Преобразование дат в количество дней с фиксированной начальной точки
 * 2-е по скорости решение - 1 ms
 *
 */
class Solution {
    public int daysBetweenDates(String date1, String date2) {
        // Вычисляем количество дней для каждой даты от фиксированной точки
        int days1 = calculateDays(date1);
        int days2 = calculateDays(date2);

        // Возвращаем абсолютную разницу
        return Math.abs(days1 - days2);
    }

    private int calculateDays(String date) {
        // Разбираем строку даты на компоненты
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        // Вычисляем общее количество дней от 1970-01-01 (или другой фиксированной точки)
        int totalDays = 0;

        // Добавляем дни за все предыдущие годы
        for (int y = 1970; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        // Добавляем дни за все предыдущие месяцы в текущем году
        for (int m = 1; m < month; m++) {
            totalDays += getDaysInMonth(m, year);
        }

        // Добавляем дни в текущем месяце
        totalDays += day - 1; // -1 потому что день 1 это 0 дней от начала месяца

        return totalDays;
    }

    private boolean isLeapYear(int year) {
        // Високосный год если:
        // 1. Делится на 4
        // 2. Но не делится на 100, кроме случаев когда делится на 400
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: return 31;  // Январь
            case 2: return isLeapYear(year) ? 29 : 28;  // Февраль
            case 3: return 31;  // Март
            case 4: return 30;  // Апрель
            case 5: return 31;  // Май
            case 6: return 30;  // Июнь
            case 7: return 31;  // Июль
            case 8: return 31;  // Август
            case 9: return 30;  // Сентябрь
            case 10: return 31; // Октябрь
            case 11: return 30; // Ноябрь
            case 12: return 31; // Декабрь
            default: return 0;
        }
    }
}