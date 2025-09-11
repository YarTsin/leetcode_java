package org.example.g0901_1000.s0989_add_to_array_form_of_integer;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с использованием StringBuilder
 */
class Solution3 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        String kStr = String.valueOf(k);
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        int i = num.length - 1;
        int j = kStr.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num[i] : 0;
            int digit2 = (j >= 0) ? kStr.charAt(j) - '0' : 0;

            int total = digit1 + digit2 + carry;
            result.add(0, total % 10);
            carry = total / 10;

            i--;
            j--;
        }

        return result;
    }
}
