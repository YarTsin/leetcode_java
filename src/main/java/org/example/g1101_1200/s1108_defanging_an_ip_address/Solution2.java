package org.example.g1101_1200.s1108_defanging_an_ip_address;

/**
 * Решение: Использование replaceAll()
 *
 * replaceAll() заменяет все вхождения паттерна
 * Точка в регулярных выражениях - специальный символ,
 * поэтому экранируем ее \\.
 * Простое и читаемое решение
 *
 * Сложность: Время O(n), пространство O(n)
 */
class Solution2 {
    public String defangIPaddr(String address) {
        // Заменяем все вхождения точки на [.]
        return address.replaceAll("\\.", "[.]");
    }
}
