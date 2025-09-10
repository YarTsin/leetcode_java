package org.example.g0901_1000.s0929_unique_email_addresses;

import java.util.HashSet;
import java.util.Set;

/**
 * Решение (с использованием Regex)
 */
class Solution3 {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            // Разделяем email на части
            String[] parts = email.split("@");
            String localPart = parts[0];
            String domain = parts[1];

            // Удаляем все после '+' и все точки с помощью regex
            localPart = localPart.split("\\+")[0].replace(".", "");

            uniqueEmails.add(localPart + "@" + domain);
        }

        return uniqueEmails.size();
    }
}
