package org.example.g0501_0600.s0541_reverse_string_ii;


/**
 * Альтернативное решение (с использованием StringBuilder)
 */
class Solution2 {
    public String reverseStr(String s, int k) {
        StringBuilder result = new StringBuilder();
        int length = s.length();

        for (int i = 0; i < length; i += 2 * k) {
            // Определяем конец текущего блока
            int end = Math.min(i + 2 * k, length);

            // Извлекаем текущий блок
            String chunk = s.substring(i, end);

            if (chunk.length() >= k) {
                // Обращаем первые k символов
                String reversed = new StringBuilder(chunk.substring(0, k)).reverse().toString();
                result.append(reversed);
                // Добавляем оставшиеся символы
                if (chunk.length() > k) {
                    result.append(chunk.substring(k));
                }
            } else {
                // Если меньше k символов, обращаем все
                result.append(new StringBuilder(chunk).reverse().toString());
            }
        }

        return result.toString();
    }
}
