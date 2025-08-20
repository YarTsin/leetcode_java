package org.example.g0901_1000.s0942_di_string_match;

/**
 * Похожее решение
 */
public class Solution2 {
    public int[] diStringMatch(String s) {
        int stringLength = s.length();
        int[] permutation = new int[stringLength + 1];

        int currentMin = 0;
        int currentMax = stringLength;

        for (int i = 0; i < stringLength; i++) {
            char currentChar = s.charAt(i);

            if (currentChar == 'I') {
                // Increase: используем минимальное доступное число
                // Следующее число будет больше (гарантировано т.к. min увеличивается)
                permutation[i] = currentMin;
                currentMin++;
            } else if (currentChar == 'D') {
                // Decrease: используем максимальное доступное число
                // Следующее число будет меньше (гарантировано т.к. max уменьшается)
                permutation[i] = currentMax;
                currentMax--;
            }
        }

        // Для последней позиции используем оставшееся число
        // currentMin и currentMax будут равны в этот момент
        permutation[stringLength] = currentMin;

        return permutation;
    }
}
