package org.example.g0901_1000.s0944_delete_columns_to_make_sorted;

// #Easy #Array #String

/**
 * 944. Delete Columns to Make Sorted
 */
public class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
