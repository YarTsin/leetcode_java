package org.example.g1601_1700.s1603_design_parking_system;

// #Easy #Design #Simulation #Counting

/**
 * 1603. Design Parking System
 *
 * Нужно спроектировать парковочную систему для парковки с тремя
 * типами парковочных мест:
 * Big - для больших автомобилей
 * Medium - для средних автомобилей
 * Small - для маленьких автомобилей
 *
 * Парковочная система инициализируется с определенным
 * количеством мест для каждого типа:
 * big - количество больших мест
 * medium - количество средних мест
 * small - количество маленьких мест
 *
 * Реализуйте класс ParkingSystem с методом addCar(carType), который
 * проверяет, есть ли доступное парковочное место для данного
 * типа автомобиля. Метод должен:
 * Возвращать true, если место есть и автомобиль может припарковаться
 * Возвращать false, если места нет и автомобиль не может припарковаться
 * (примеры внизу)
 *
 * Важно
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 *
 * Решение - с использованием массива - самое быстрое 7 ms
 *
 * Сложность:
 * Время: O(1) для каждого вызова addCar()
 * Память: O(1) - используем фиксированный массив из 3 элементов
 *
 */
class Solution { // Если сдавать на проверку класс должен быть ParkingSystem
    private int[] parkingSlots; // Массив для хранения количества доступных мест

    public Solution(int big, int medium, int small) {
        // Инициализируем массив: [big, medium, small]
        parkingSlots = new int[3];
        parkingSlots[0] = big;    // Тип 1 - big
        parkingSlots[1] = medium; // Тип 2 - medium
        parkingSlots[2] = small;  // Тип 3 - small
    }

    public boolean addCar(int carType) {
        // Преобразуем тип автомобиля в индекс массива (1->0, 2->1, 3->2)
        int index = carType - 1;

        // Проверяем, есть ли доступные места для данного типа
        if (parkingSlots[index] > 0) {
            parkingSlots[index]--; // Занимаем одно место
            return true;
        }
        return false;
    }
}
/*
Пример
Ввод:
["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
[[1, 1, 0], [1], [2], [3], [1]]
Вывод:
[null, true, true, false, false]
Объяснение:
ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
parkingSystem.addCar(1); // return true (есть 1 большое место)
parkingSystem.addCar(2); // return true (есть 1 среднее место)
parkingSystem.addCar(3); // return false (нет маленьких мест)
parkingSystem.addCar(1); // return false (большое место уже занято)
 */