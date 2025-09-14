package org.example.g1101_1200.s1108_defanging_an_ip_address;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Использование streams (Java 8)
 */
class Solution5 {
    public String defangIPaddr(String address) {
        return Arrays.stream(address.split("\\."))
                .collect(Collectors.joining("[.]"));
    }
}
