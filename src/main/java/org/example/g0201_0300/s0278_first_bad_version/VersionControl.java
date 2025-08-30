package org.example.g0201_0300.s0278_first_bad_version;

/**
 * The isBadVersion API is defined in the parent class VersionControl.
 * boolean isBadVersion(int version)
 *
 * вспомогательный класс для Solution
 *
 * Класс предоставляется платформой Leetcode
 * Реализация скрыта от пользователя
 *
 */
public class VersionControl {
    private int bad;

    public VersionControl(int bad) {
        this.bad = bad;
    }

    public boolean isBadVersion(int version) {
        return version >= bad;
    }
}