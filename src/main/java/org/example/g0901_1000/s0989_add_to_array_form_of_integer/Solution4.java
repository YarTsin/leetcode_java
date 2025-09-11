package org.example.g0901_1000.s0989_add_to_array_form_of_integer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Избегаем добавления в начало списка, а затем разворачиваем результат.
 */
class Solution4 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        int i = num.length - 1;

        while (i >= 0 || k > 0 || carry > 0) {
            int digitFromNum = (i >= 0) ? num[i] : 0;
            int digitFromK = k % 10;

            int total = digitFromNum + digitFromK + carry;
            result.add(total % 10);
            carry = total / 10;

            i--;
            k /= 10;
        }

        // Разворачиваем список, так как добавляли с конца
        Collections.reverse(result);
        return result;
    }
}
