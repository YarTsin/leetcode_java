package org.example.g1301_1400.s1337_the_k_weakest_rows_in_a_matrix;

import java.util.PriorityQueue;

/**
 * Альтернативное решение: Приоритетная очередь
 */
class Solution2 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;

        // Используем приоритетную очередь с компаратором
        // Сначала сравниваем по количеству единиц, потом по индексу
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // для обратного порядка
            }
            return b[0] - a[0]; // для обратного порядка
        });

        for (int i = 0; i < rows; i++) {
            int count = countOnes(mat[i]);
            pq.offer(new int[]{count, i});

            // Поддерживаем размер очереди не больше k
            if (pq.size() > k) {
                pq.poll(); // удаляем самый сильный элемент
            }
        }

        // Извлекаем результаты в обратном порядке
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll()[1];
        }

        return result;
    }

    private int countOnes(int[] row) {
        int left = 0;
        int right = row.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (row[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
