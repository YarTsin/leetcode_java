package org.example.g0601_0700.s0682_baseball_game;

/**
 * Альтернативное решение (Без дополнительных структур)
 */
class Solution3 {
    public int calPoints(String[] operations) {
        int[] scores = new int[operations.length];
        int index = 0;

        for (String op : operations) {
            switch (op) {
                case "+":
                    int sum = scores[index - 1] + scores[index - 2];
                    scores[index++] = sum;
                    break;
                case "D":
                    int doubleScore = scores[index - 1] * 2;
                    scores[index++] = doubleScore;
                    break;
                case "C":
                    index--; // "Удаляем" последний элемент
                    break;
                default:
                    scores[index++] = Integer.parseInt(op);
                    break;
            }
        }

        int total = 0;
        for (int i = 0; i < index; i++) {
            total += scores[i];
        }

        return total;
    }
}
