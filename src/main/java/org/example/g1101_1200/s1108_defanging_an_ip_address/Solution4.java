package org.example.g1101_1200.s1108_defanging_an_ip_address;

/**
 * Использование String.join() с split()
 *
 * Объяснение:
 * Разбиваем IP-адрес на части по точкам
 * Собираем обратно с разделителем "[.]"
 *
 * Сложность: Время O(n), пространство O(n)
 */
class Solution4 {
    public String defangIPaddr(String address) {
        // Разбиваем строку по точкам
        String[] parts = address.split("\\.");
        // Собираем обратно с разделителем [.]
        return String.join("[.]", parts);
    }
}