package org.example.g0701_0800.s0709_to_lower_case;

/**
 * Решение с использованием побитовых операций
 * Преимущества:
 * Более "низкоуровневый" подход
 * Демонстрирует понимание битовых операций
 * Такая же эффективность как у первого решения
 *
 */
class Solution2 {
    public String toLowerCase(String str) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            // Используем побитовую операцию OR с 32 (0x20)
            // Заглавные буквы: 65-90 (A-Z)
            // Установка 6-го бита преобразует в нижний регистр
            if (currentChar >= 'A' && currentChar <= 'Z') {
                char lowerCaseChar = (char)(currentChar | 32);
                result.append(lowerCaseChar);
            } else {
                result.append(currentChar);
            }
        }

        return result.toString();
    }
}
