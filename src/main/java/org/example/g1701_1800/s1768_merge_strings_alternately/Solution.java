package org.example.g1701_1800.s1768_merge_strings_alternately;

// #Easy #String #Two_Pointers #LeetCode_75_Array/String

/**
 * 1768. Merge Strings Alternately
 *
 * Даны две строки, word1 и word2. Необходимо объединить эти строки,
 * добавляя буквы поочередно, начиная с word1. Если одна из строк
 * окажется длиннее другой, дополнительные буквы этой более длинной
 * строки нужно добавить в конец результирующей строки.
 *
 * Процесс "чередования" означает, что мы берем первую букву из word1,
 * затем первую букву из word2, затем вторую букву из word1, затем
 * вторую букву из word2, и так далее.
 * (примеры внизу)
 *
 * Решение - подход с 2 указателями и StringBuilder
 * Самое быстрое 0 ms
 *
 * Это решение имеет временную сложность O(n + m) и пространственную
 * сложность O(n + m), где n и m - длины строк word1 и word2
 *
 */
class Solution {
    public String mergeAlternately(String word1, String word2) {
        // Получаем длины обеих строк для дальнейших проверок
        int lengthWord1 = word1.length();
        int lengthWord2 = word2.length();

        // Создаем StringBuilder для эффективного построения результирующей строки
        StringBuilder mergedResult = new StringBuilder();

        // Находим длину более короткой строки
        // Это нужно, чтобы определить, сколько пар символов мы можем добавить поочередно
        int minLength = Math.min(lengthWord1, lengthWord2);

        // Проходим по индексам от 0 до minLength - 1
        for (int index = 0; index < minLength; index++) {
            // Добавляем символ из word1 с текущим индексом
            mergedResult.append(word1.charAt(index));
            // Добавляем символ из word2 с текущим индексом
            mergedResult.append(word2.charAt(index));
        }

        // После обработки общей части, добавляем оставшийся суффикс более длинной строки
        // Если word1 длиннее, добавляем все символы, начиная с индекса minLength
        if (lengthWord1 > lengthWord2) {
            mergedResult.append(word1.substring(minLength));
        }
        // Иначе, если word2 длиннее, добавляем ее суффикс
        else if (lengthWord2 > lengthWord1) {
            mergedResult.append(word2.substring(minLength));
        }
        // Если строки были одинаковой длины, этот блок пропускается.

        // Преобразуем StringBuilder в итоговую строку и возвращаем ее
        return mergedResult.toString();
    }
}
/*
Пример 1:
Вход: word1 = "abc", word2 = "pqr"
Результат: "apbqcr"
Объяснение:
Объединение начинается с word1: берется 'a'.
Затем чередование на word2: берется 'p'.
Возврат к word1: берется 'b'.
Возврат к word2: берется 'q'.
Возврат к word1: берется 'c'.
Возврат к word2: берется 'r'.
Строки одинаковой длины, процесс завершен.

Пример 2:
Вход: word1 = "ab", word2 = "pqrs"
Результат: "apbqrs"
Объяснение:
word1 = "ab", word2 = "pqrs".
После чередования букв из обеих строк ('a' + 'p' + 'b' + 'q')
строка word1 закончилась.
Все оставшиеся символы из более длинной строки word2 ('r' и 's')
добавляются в конец результата.

Пример 3:
Вход: word1 = "abcd", word2 = "pq"
Результат: "apbqcd"
Объяснение:
Аналогично примеру 2, но здесь word1 длиннее.
После чередования ('a' + 'p' + 'b' + 'q') строка word2 закончилась.
Все оставшиеся символы из word1 ('c' и 'd') добавляются в конец результата.
 */