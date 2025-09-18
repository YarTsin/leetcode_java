package org.example.g1501_1600.s1507_reformat_date;

// #Easy #String #Date #Интересно

import java.util.HashMap;
import java.util.Map;

/**
 * 1507. Reformat Date
 *
 * Дана строка date, представляющая дату в формате "Day Month Year", где:
 * Day находится в множестве {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
 * Month находится в множестве {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}
 * Year находится в диапазоне [1900, 2100].
 *
 * Примеры:
 *
 * Ввод: date = "20th Oct 2052"  * Вывод: "2052-10-20"
 *
 * Ввод: date = "6th Jun 1933" * Вывод: "1933-06-06"
 * Пояснение: День "6th" преобразуется в "06".
 *
 * Ввод: date = "26th May 1960" * Вывод: "1960-05-26"
 *
 * Основные моменты: Корректно обработать день (удалить суффиксы
 * "st", "nd", "rd", "th" и добавить ведущий ноль при необходимости)
 * и преобразовать буквенное представление месяца в его числовой эквивалент.
 *
 * Решение - Использование HashMap для месяцев
 * Не быстрое решение - 6 ms
 *
 * Это решение выполняется за время O(1) и использует O(1) дополнительной памяти.
 */
class Solution {
    public String reformatDate(String date) {
        // Создаем и заполняем Map для преобразования месяца
        Map<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");

        // Разбиваем строку по пробелу на части: [day, month, year]
        String[] parts = date.split(" ");
        String dayPart = parts[0];
        String monthPart = parts[1];
        String yearPart = parts[2];

        // Обрабатываем день: удаляем суффикс (2 последних символа)
        // Если после удаления длина строки = 1, добавляем ведущий ноль
        String dayNumber = dayPart.substring(0, dayPart.length() - 2);
        if (dayNumber.length() == 1) {
            dayNumber = "0" + dayNumber;
        }

        // Достаем числовое значение месяца из Map
        String monthNumber = monthMap.get(monthPart);

        // Собираем результат в формате YYYY-MM-DD
        return yearPart + "-" + monthNumber + "-" + dayNumber;
    }
}