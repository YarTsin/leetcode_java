package org.example.g1101_1200.s1108_defanging_an_ip_address;

/**
 * Ручное построение строки с StringBuilder
 *
 * Проходим по каждому символу исходной строки
 * Если символ - точка, добавляем "[.]"
 * Иначе добавляем исходный символ
 * Используем StringBuilder для эффективного построения строки
 * Сложность: Время O(n), пространство O(n)
 */
class Solution3 {
    public String defangIPaddr(String address) {
        StringBuilder result = new StringBuilder();

        for (char c : address.toCharArray()) {
            if (c == '.') {
                result.append("[.]");
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
