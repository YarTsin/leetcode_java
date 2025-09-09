package org.example.g0801_0900.s0844_backspace_string_compare;

// #Easy #String #Two_Pointers #Stack #Simulation #Интересно

/**
 * 844. Backspace String Compare
 * Даны две строки s и t. Строки могут содержать строчные английские
 * буквы и символ '#', который представляет собой backspace (клавишу backspace).
 * Необходимо определить, будут ли строки равны после обработки всех
 * backspace-символов. Обработка backspace означает:
 * Когда встречается символ '#', он удаляет предыдущий символ (если такой существует)
 * (примеры внизу)
 *
 * Решение - Два указателя с обработкой с конца строк
 * Самое быстрое - 0 ms
 *
 *
 * Сложность: O(n + m) по времени, O(1) по дополнительной памяти
 */
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sPointer = s.length() - 1;
        int tPointer = t.length() - 1;

        while (sPointer >= 0 || tPointer >= 0) {
            // Обрабатываем backspace в строке s
            sPointer = getNextValidCharIndex(s, sPointer);

            // Обрабатываем backspace в строке t
            tPointer = getNextValidCharIndex(t, tPointer);

            // Если обе строки закончились - они равны
            if (sPointer < 0 && tPointer < 0) {
                return true;
            }

            // Если одна строка закончилась, а другая нет - не равны
            if (sPointer < 0 || tPointer < 0) {
                return false;
            }

            // Сравниваем текущие символы
            if (s.charAt(sPointer) != t.charAt(tPointer)) {
                return false;
            }

            sPointer--;
            tPointer--;
        }

        return true;
    }

    private int getNextValidCharIndex(String str, int currentIndex) {
        int backspaceCount = 0;

        while (currentIndex >= 0) {
            if (str.charAt(currentIndex) == '#') {
                backspaceCount++;
                currentIndex--;
            } else if (backspaceCount > 0) {
                backspaceCount--;
                currentIndex--;
            } else {
                break;
            }
        }

        return currentIndex;
    }
}
/*
Пример 1:
Вход: s = "ab#c", t = "ad#c"
Выход: true
Объяснение:
Обработка s: "ab#c" → "a" (b удаляется) → "ac" → "ac"
Обработка t: "ad#c" → "a" (d удаляется) → "ac" → "ac"
Обе строки становятся "ac"

Пример 2:
Вход: s = "ab##", t = "c#d#"
Выход: true
Объяснение:
Обработка s: "ab##" → "a" (b удаляется) → "" (a удаляется) → ""
Обработка t: "c#d#" → "" (c удаляется) → "d" → "" (d удаляется) → ""
Обе строки становятся пустыми

Пример 3:
Вход: s = "a#c", t = "b"
Выход: false
Объяснение:
Обработка s: "a#c" → "" (a удаляется) → "c" → "c"
Обработка t: "b" → "b"
"c" ≠ "b"
 */