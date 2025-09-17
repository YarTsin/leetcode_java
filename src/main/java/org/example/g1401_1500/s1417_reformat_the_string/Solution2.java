package org.example.g1401_1500.s1417_reformat_the_string;

/**
 * Решение с двумя указателями
 * Объяснение подхода:
 * Подсчет: Считаем количество букв и цифр
 * Проверка: Убеждаемся, что чередование возможно
 * Распределение: Используем два указателя с шагом 2 для размещения символов
 * Заполнение: Буквы и цифры размещаются на четных/нечетных позициях
 * в зависимости от того, с чего начинаем
 *
 * Временная сложность: O(n)
 * Пространственная сложность: O(n)
 */
class Solution2 {
    public String reformat(String s) {
        int letterCount = 0;
        int digitCount = 0;

        // Считаем количество букв и цифр
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                letterCount++;
            } else {
                digitCount++;
            }
        }

        // Проверяем возможность чередования
        if (Math.abs(letterCount - digitCount) > 1) {
            return "";
        }

        char[] result = new char[s.length()];
        int letterIndex = 0;
        int digitIndex = 1;

        // Определяем, с какой группы начинать
        if (letterCount > digitCount) {
            // Начинаем с букв
            letterIndex = 0;
            digitIndex = 1;
        } else {
            // Начинаем с цифр
            letterIndex = 1;
            digitIndex = 0;
        }

        // Заполняем массив результата
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                if (letterIndex < s.length()) {
                    result[letterIndex] = c;
                    letterIndex += 2;
                }
            } else {
                if (digitIndex < s.length()) {
                    result[digitIndex] = c;
                    digitIndex += 2;
                }
            }
        }

        return new String(result);
    }
}
