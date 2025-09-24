package org.example.g1701_1800.s1736_latest_time_by_replacing_hidden_digits;

/**
 * Решение на основе StringBuilder()
 */
class Solution2 {
    public String maximumTime(String time) {
        StringBuilder result = new StringBuilder();

        // Обрабатываем каждый символ отдельно
        for (int i = 0; i < 5; i++) {
            if (time.charAt(i) != '?') {
                result.append(time.charAt(i));
            } else {
                switch (i) {
                    case 0: // Первая цифра часов
                        if (time.charAt(1) == '?' || time.charAt(1) <= '3') {
                            result.append('2');
                        } else {
                            result.append('1');
                        }
                        break;
                    case 1: // Вторая цифра часов
                        if (result.charAt(0) == '2') {
                            result.append('3');
                        } else {
                            result.append('9');
                        }
                        break;
                    case 3: // Первая цифра минут
                        result.append('5');
                        break;
                    case 4: // Вторая цифра минут
                        result.append('9');
                        break;
                    default: // Двоеточие (i=2)
                        result.append(':');
                        break;
                }
            }
        }

        return result.toString();
    }
}
