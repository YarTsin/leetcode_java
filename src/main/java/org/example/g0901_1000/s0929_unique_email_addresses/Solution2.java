package org.example.g0901_1000.s0929_unique_email_addresses;

import java.util.HashSet;
import java.util.Set;

/**
 * Альтернативное решение (String.indexOf и substring)
 * Используем методы String для более эффективного поиска символов.
 */
class Solution2 {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            // Находим позицию символа '@'
            int atIndex = email.indexOf('@');

            // Извлекаем локальную часть и домен
            String localPart = email.substring(0, atIndex);
            String domain = email.substring(atIndex + 1);

            // Находим позицию '+' в локальной части
            int plusIndex = localPart.indexOf('+');

            // Если '+' найден, берем часть до него
            if (plusIndex != -1) {
                localPart = localPart.substring(0, plusIndex);
            }

            // Удаляем все точки из локальной части
            localPart = localPart.replace(".", "");

            // Собираем нормализованный email
            String normalizedEmail = localPart + "@" + domain;
            uniqueEmails.add(normalizedEmail);
        }

        return uniqueEmails.size();
    }
}
