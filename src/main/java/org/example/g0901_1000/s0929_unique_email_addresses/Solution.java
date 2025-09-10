package org.example.g0901_1000.s0929_unique_email_addresses;

// #Easy #Array #String #Hash_Table #HashSet

import java.util.HashSet;
import java.util.Set;

/**
 * 929. Unique Email Addresses
 *
 * Каждый email-адрес состоит из локального
 * имени и доменного имени, разделенных символом '@'.
 *
 * Правила обработки email-адресов:
 * Если в локальном имени встречается знак '+', то все после него (до '@') игнорируется
 * Если в локальном имени встречается точка '.', то они игнорируются
 * Определите количество уникальных email-адресов после применения этих правил.
 *
 * Пример 1
 * Input: emails = ["test.email+alex@leetcode.com",
 * "test.e.mail+bob.cathy@leetcode.com",
 * "testemail+david@lee.tcode.com"]
 *  Output: 2
 * Объяснение: Оба email преобразуются в "testemail@leetcode.com"
 *
 * Пример 2
 * Input: emails = ["a@leetcode.com",
 * "b@leetcode.com","c@leetcode.com"]
 * Output: 3
 *
 * Пример 3
 * Input: emails = ["test.email+alex@leetcode.com",
 * "test.email@leetcode.com"]
 * Output: 1
 * Объяснение: Оба преобразуются в "testemail@leetcode.com"
 *
 * Решение: HashSet + String Processing
 * Небыстрое решение - 17 ms
 *
 * Сложность:
 * Время: O(n * m), где n - количество email, m - средняя длина email
 * Память: O(n * m) для хранения уникальных адресов
 *
 */
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            // Разделяем email на локальную часть и домен
            String[] parts = email.split("@");
            String localPart = parts[0];
            String domain = parts[1];

            // Обрабатываем локальную часть
            StringBuilder processedLocal = new StringBuilder();

            for (char c : localPart.toCharArray()) {
                if (c == '+') {
                    break; // Игнорируем все после '+'
                }
                if (c != '.') {
                    processedLocal.append(c); // Игнорируем точки
                }
            }

            // Собираем обработанный email
            String normalizedEmail = processedLocal.toString() + "@" + domain;
            uniqueEmails.add(normalizedEmail);
        }

        return uniqueEmails.size();
    }
}
/*
Подход:
Для каждого email-адреса:
Разделяем на локальную часть и домен по символу '@'
Обрабатываем локальную часть: удаляем все после '+' и все точки
Объединяем обработанную локальную часть с доменом
Добавляем в HashSet для автоматического определения уникальности
 */