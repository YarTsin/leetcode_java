package org.example.g0701_0800.s0748_shortest_completing_word;

// #Easy #Array #String #Hash_Table #Char

/**
 * 748. Shortest Completing Word
 * Дан строковый licensePlate и массив строк words.
 * Нужно найти в массиве words самое короткое слово (shortest word),
 * которое является завершающим словом (completing word)
 * для строки licensePlate.
 *
 * Что такое "completing word"?
 * Слово считается завершающим для licensePlate, если оно
 * содержит все буквы, которые присутствуют в licensePlate.
 *
 * Условия
 * Игнорируем цифры, пробелы и другие не-буквенные символы в licensePlate.
 * Учитываем только буквы, причем регистр не важен (буквы в licensePlate
 * и words могут быть в верхнем или нижнем регистре).
 * Частотность букв: Если какая-то буква встречается в licensePlate n
 * раз, то в завершающем слове она должна встречаться как минимум n раз.
 * Если несколько слов в массиве имеют одинаковую (самую короткую)
 * длину и являются завершающими, нужно вернуть первое из них.
 *
 * todo запутанное условие
 *
 * (примеры внизу)
 *
 * Решение: подсчет частотности букв - 3-t по скорости решение - 3 ms
 */
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        // 1. Приводим licensePlate к нижнему регистру и извлекаем только буквы,
        //    одновременно подсчитывая их частоту.
        int[] licenseFrequency = new int[26];
        // Проходим по всем символам в licensePlate
        for (char c : licensePlate.toCharArray()) {
            // Если символ - буква...
            if (Character.isLetter(c)) {
                // ...приводим к нижнему регистру и вычисляем индекс в массиве (0 для 'a', 25 для 'z')
                char lowerC = Character.toLowerCase(c);
                licenseFrequency[lowerC - 'a']++;
            }
        }

        // 2. Инициализируем переменную для результата.
        //    Пока не нашли ни одного слова, результат null.
        String result = null;

        // 3. Перебираем все слова в массиве words.
        for (String word : words) {
            // Для каждого слова создаем свой массив частотности букв.
            int[] wordFrequency = new int[26];
            for (char c : word.toCharArray()) {
                // Так как слова содержат только буквы в нижнем регистре (по условию),
                // можно просто подсчитать.
                wordFrequency[c - 'a']++;
            }

            // 4. Проверяем, является ли текущее слово завершающим.
            //    Для этого проверяем, что для каждой буквы алфавита частота в слове
            //    НЕ МЕНЬШЕ частоты в licensePlate.
            boolean isCompleting = true;
            for (int i = 0; i < 26; i++) {
                if (wordFrequency[i] < licenseFrequency[i]) {
                    // Если хоть для одной буквы не хватает частоты, слово не подходит.
                    isCompleting = false;
                    break; // Прерываем внутренний цикл досрочно
                }
            }

            // 5. Если слово является завершающим, сравниваем его с текущим результатом.
            if (isCompleting) {
                // Если результат еще не найден (result == null) ИЛИ
                // если текущее слово КОРОЧЕ найденного ранее результата,
                // то обновляем результат.
                if (result == null || word.length() < result.length()) {
                    result = word;
                }
            }
        }

        return result;
    }
}
/*
Пример 1
Ввод:
licensePlate = "1s3 PSt"
words = ["step", "steps", "stripe", "stepple"]
Вывод: "steps"
Объяснение:
Из licensePlate извлекаем буквы: 's', 's', 'p', 's', 't' ->
нам нужны 2 's', 1 'p', 1 't'.

Анализируем words:
"step" -> содержит 1 's', 1 't', 1 'e', 1 'p'. Не хватает одного 's'. ❌
"steps" -> содержит 2 's', 1 't', 1 'e', 1 'p'. ✅ Соответствует требованиям.
Длина = 5.
"stripe" -> содержит 1 's', 2 't', 1 'r', 1 'i', 1 'p', 1 'e'.
Не хватает одного 's'. ❌

Подходящее слово — "steps" (5 < 7).

Пример 2
Ввод:
licensePlate = "1s3 456"
words = ["looks", "pest", "stew", "show"]
Вывод: "pest"
Объяснение:
Из licensePlate извлекаем буквы: 's'. Нужна 1 буква 's'.
Все слова содержат 's', поэтому все являются завершающими.
Самое короткое из них — "pest" и "stew" (длина 4).
Возвращаем первое из самых коротких — "pest".



 */
