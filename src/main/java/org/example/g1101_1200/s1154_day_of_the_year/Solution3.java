package org.example.g1101_1200.s1154_day_of_the_year;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Решение с использованием Calendar API
 */
class Solution3 {
    public int dayOfYear(String date) {
        try {
            // Парсим дату из строки
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = format.parse(date);

            // Создаем календарь и устанавливаем дату
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parsedDate);

            // Получаем день года
            return calendar.get(Calendar.DAY_OF_YEAR);
        } catch (Exception e) {
            return -1; // В реальной задаче исключение нужно обрабатывать properly
        }
    }
}