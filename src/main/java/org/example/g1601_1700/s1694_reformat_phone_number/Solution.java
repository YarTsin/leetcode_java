package org.example.g1601_1700.s1694_reformat_phone_number;

// #Easy #String #Интересно #Регулярки

/**
 * 1694. Reformat Phone Number
 *
 * Вам дана строка number, представляющая телефонный номер. Строка содержит:
 * Цифры (0-9)
 * Дефисы (-)
 * Пробелы ( )
 * Необходимо отформатировать номер по следующим правилам:
 * Удалить все нецифровые символы (дефисы и пробелы)
 * Группировать цифры в блоки по 3, пока не останется 4 или меньше цифр
 * Для оставшихся цифр:
 * Если осталось 2 цифры → один блок из 2 цифр
 * Если осталось 3 цифры → один блок из 3 цифр
 * Если осталось 4 цифры → два блока по 2 цифры
 *
 * Ключевые моменты:
 * Нужно сохранить исходный порядок цифр
 * Блоки разделяются дефисами
 * Последние блоки обрабатываются особым образом
 * (примеры внизу)
 *
 * Решение 1 - самое быстрое - 0 ms
 *
 * Временная сложность: O(n) где n - длина строки
 * Пространственная сложность: O(n) для хранения результата
 */
class Solution {
    public String reformatNumber(String number) {
        // Шаг 1: Удаляем все нецифровые символы
        StringBuilder digits = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            }
        }

        int n = digits.length();
        StringBuilder result = new StringBuilder();
        int index = 0;

        // Шаг 2: Обрабатываем цифры блоками
        while (index < n) {
            int remaining = n - index;

            if (remaining == 4) {
                // Особый случай: 4 цифры → 2 блока по 2
                result.append(digits.charAt(index++));
                result.append(digits.charAt(index++));
                result.append('-');
                result.append(digits.charAt(index++));
                result.append(digits.charAt(index++));
            } else if (remaining == 2) {
                // 2 цифры → один блок
                result.append(digits.charAt(index++));
                result.append(digits.charAt(index++));
            } else if (remaining == 3) {
                // 3 цифры → один блок
                result.append(digits.charAt(index++));
                result.append(digits.charAt(index++));
                result.append(digits.charAt(index++));
            } else {
                // Более 4 цифр → блок из 3 цифр
                result.append(digits.charAt(index++));
                result.append(digits.charAt(index++));
                result.append(digits.charAt(index++));
                if (index < n) {
                    result.append('-');
                }
            }
        }

        return result.toString();
    }
}
/*
Пример 1
Вход: number = "1-23-45 6"
Выход: "123-456"
Объяснение:
Цифры: "123456"
Группировка: "123" + "-" + "456"

Пример 2
Вход: number = "123 4-567"
Выход: "123-45-67"
Объяснение:
Цифры: "1234567"
Группировка: "123" + "-" + "45" + "-" + "67"
 */