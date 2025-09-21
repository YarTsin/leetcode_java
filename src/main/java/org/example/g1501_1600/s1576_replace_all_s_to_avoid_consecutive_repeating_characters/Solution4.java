package org.example.g1501_1600.s1576_replace_all_s_to_avoid_consecutive_repeating_characters;

/**
 * С предварительной проверкой соседей
 */
class Solution4 {
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] == '?') {
                char left = (i > 0) ? arr[i - 1] : '\0';
                char right = (i < n - 1) ? arr[i + 1] : '\0';

                // Ищем букву, отличную от левого и правого соседа
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != left && c != right) {
                        arr[i] = c;
                        break;
                    }
                }
            }
        }

        return new String(arr);
    }
}
