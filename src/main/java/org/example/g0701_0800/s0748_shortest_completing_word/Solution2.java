package org.example.g0701_0800.s0748_shortest_completing_word;

/**
 * Решение с досрочным прекращением подсчета частот слова
 * Это небольшая оптимизация основного решения.
 * Мы можем проверять условие wordFrequency[i] >= licenseFrequency[i]
 * прямо во время подсчета частот для слова.
 * Если для какой-то буквы условие уже не выполняется,
 * можно досрочно прекратить обработку этого слова.
 *
 * Сравнение: Эта версия не дает значительного выигрыша
 * по времени в худшем случае, но может быть немного быстрее
 * на больших данных, так как избегает полного подсчета частот
 * для заведомо неподходящих слов. Логика становится чуть
 * сложнее для восприятия.
 *
 */
class Solution2 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licenseFrequency = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                licenseFrequency[Character.toLowerCase(c) - 'a']++;
            }
        }

        String result = null;

        for (String word : words) {
            int[] wordFrequency = new int[26];
            boolean isCompleting = true; // Предположим, что слово подходит

            for (char c : word.toCharArray()) {
                wordFrequency[c - 'a']++;
            }

            // Проверяем условие для всех букв
            for (int i = 0; i < 26; i++) {
                if (wordFrequency[i] < licenseFrequency[i]) {
                    isCompleting = false;
                    break;
                }
            }

            if (isCompleting) {
                if (result == null || word.length() < result.length()) {
                    result = word;
                }
            }
        }
        return result;
    }
}
