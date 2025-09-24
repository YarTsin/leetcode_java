package org.example.g1601_1700.s1678_goal_parser_interpretation;

/**
 * Альтернативное решение (более простое)
 */
class Solution2 {
    public String interpret(String command) {
        // Сначала заменяем (al) на al, затем () на o
        return command.replace("(al)", "al").replace("()", "o");
    }
}
