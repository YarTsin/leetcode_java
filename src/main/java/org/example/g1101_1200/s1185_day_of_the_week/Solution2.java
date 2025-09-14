package org.example.g1101_1200.s1185_day_of_the_week;

/**
 * Альтернативное решение - использование Java Calendar API
 */
import java.util.Calendar;

class Solution2 {
    public String dayOfTheWeek(int day, int month, int year) {
        // Массив с названиями дней недели
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        // Создаем объект Calendar и устанавливаем дату
        Calendar calendar = Calendar.getInstance();
        // Месяц в Calendar начинается с 0 (январь = 0)
        calendar.set(year, month - 1, day);

        // Получаем день недели (воскресенье = 1, понедельник = 2, ..., суббота = 7)
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // Преобразуем к индексу массива (0 = Sunday, 1 = Monday, ..., 6 = Saturday)
        return daysOfWeek[dayOfWeek - 1];
    }
}