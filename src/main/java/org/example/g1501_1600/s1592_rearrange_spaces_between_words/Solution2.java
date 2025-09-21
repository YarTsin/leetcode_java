package org.example.g1501_1600.s1592_rearrange_spaces_between_words;

import java.util.Arrays;

/**
 * С использованием Arrays.fill()
 */
class Solution2 {
    public String reorderSpaces(String text) {
        int spaceCount = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') spaceCount++;
        }

        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;

        if (wordCount == 1) {
            return words[0] + createSpacesArray(spaceCount);
        }

        int spacesBetween = spaceCount / (wordCount - 1);
        int extraSpaces = spaceCount % (wordCount - 1);

        StringBuilder result = new StringBuilder();
        String gap = createSpacesArray(spacesBetween);

        for (int i = 0; i < wordCount; i++) {
            result.append(words[i]);
            if (i < wordCount - 1) {
                result.append(gap);
            }
        }

        if (extraSpaces > 0) {
            result.append(createSpacesArray(extraSpaces));
        }

        return result.toString();
    }

    private String createSpacesArray(int count) {
        if (count <= 0) return "";
        char[] spaces = new char[count];
        Arrays.fill(spaces, ' ');
        return new String(spaces);
    }
}
