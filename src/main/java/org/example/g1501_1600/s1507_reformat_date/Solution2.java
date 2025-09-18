package org.example.g1501_1600.s1507_reformat_date;

/**
 * Альтернативное решение (Использование массива для месяцев)
 */
class Solution2 {
    public String reformatDate(String date) {
        // Массив всех месяцев в правильном порядке
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        // Разбиваем строку по пробелу на части: [day, month, year]
        String[] parts = date.split(" ");
        String dayPart = parts[0];
        String monthPart = parts[1];
        String yearPart = parts[2];

        // Обрабатываем день
        String dayNumber = dayPart.substring(0, dayPart.length() - 2);
        if (dayNumber.length() == 1) {
            dayNumber = "0" + dayNumber;
        }

        // Обрабатываем месяц: ищем его позицию в массиве
        String monthNumber = "";
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(monthPart)) {
                // Месяцы нумеруются с 1, поэтому i + 1
                int monthNum = i + 1;
                // Добавляем ведущий ноль, если месяц с 1 по 9
                monthNumber = (monthNum < 10) ? ("0" + monthNum) : (String.valueOf(monthNum));
                break; // Прерываем цикл, как только нашли
            }
        }

        // Собираем результат
        return yearPart + "-" + monthNumber + "-" + dayNumber;
    }
}