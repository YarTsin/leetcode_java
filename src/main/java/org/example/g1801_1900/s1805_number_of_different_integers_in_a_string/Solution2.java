package org.example.g1801_1900.s1805_number_of_different_integers_in_a_string;

import java.util.HashSet;
import java.util.Set;

/**
 * Альтернативное решение с использованием регулярных выражений
 */
class Solution2 {
    public int numDifferentIntegers(String word) {
        // Заменяем все буквы на пробелы
        String processedString = word.replaceAll("[a-z]+", " ");
        // Разделяем по пробелам (может быть несколько пробелов подряд)
        String[] numberStrings = processedString.split("\\s+");

        Set<String> uniqueNumbers = new HashSet<>();

        for (String numStr : numberStrings) {
            // Пропускаем пустые строки
            if (numStr.isEmpty()) {
                continue;
            }

            // Убираем ведущие нули
            int startIndex = 0;
            while (startIndex < numStr.length() - 1 && numStr.charAt(startIndex) == '0') {
                startIndex++;
            }

            uniqueNumbers.add(numStr.substring(startIndex));
        }

        return uniqueNumbers.size();
    }
}
