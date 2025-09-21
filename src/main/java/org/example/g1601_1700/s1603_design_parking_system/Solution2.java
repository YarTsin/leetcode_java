package org.example.g1601_1700.s1603_design_parking_system;

/**
 * Решение с отдельными переменными
 * Используем отдельные переменные для каждого типа
 * парковочных мест вместо массива.
 */
class Solution2 {
    private int bigSlots;
    private int mediumSlots;
    private int smallSlots;

    public Solution2(int big, int medium, int small) {
        this.bigSlots = big;
        this.mediumSlots = medium;
        this.smallSlots = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1: // Big car
                if (bigSlots > 0) {
                    bigSlots--;
                    return true;
                }
                break;
            case 2: // Medium car
                if (mediumSlots > 0) {
                    mediumSlots--;
                    return true;
                }
                break;
            case 3: // Small car
                if (smallSlots > 0) {
                    smallSlots--;
                    return true;
                }
                break;
        }
        return false;
    }
}
