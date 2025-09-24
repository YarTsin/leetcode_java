package org.example.g1701_1800.s1720_decode_xored_array;

/**
 * Решение с проверкой граничных условий
 */
class Solution2 {
    public int[] decode(int[] encoded, int first) {
        if (encoded == null || encoded.length == 0) {
            return new int[]{first};
        }

        int n = encoded.length;
        int[] result = new int[n + 1];
        result[0] = first;

        for (int i = 0; i < n; i++) {
            result[i + 1] = result[i] ^ encoded[i];
        }

        return result;
    }
}
