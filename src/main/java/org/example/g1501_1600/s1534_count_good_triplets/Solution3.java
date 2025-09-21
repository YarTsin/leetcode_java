package org.example.g1501_1600.s1534_count_good_triplets;

/**
 *  Оптимизированный перебор с ранним выходом
 */
class Solution3 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int goodTripletsCount = 0;
        int arrayLength = arr.length;

        // Перебираем все возможные индексы i
        for (int firstIndex = 0; firstIndex < arrayLength - 2; firstIndex++) {
            int firstValue = arr[firstIndex];

            // Перебираем все возможные индексы j (больше i)
            for (int secondIndex = firstIndex + 1; secondIndex < arrayLength - 1; secondIndex++) {
                int secondValue = arr[secondIndex];

                // Проверяем условие между первым и вторым элементом
                if (Math.abs(firstValue - secondValue) <= a) {

                    // Перебираем все возможные индексы k (больше j)
                    for (int thirdIndex = secondIndex + 1; thirdIndex < arrayLength; thirdIndex++) {
                        int thirdValue = arr[thirdIndex];

                        // Проверяем оставшиеся два условия
                        boolean secondCondition = Math.abs(secondValue - thirdValue) <= b;
                        boolean thirdCondition = Math.abs(firstValue - thirdValue) <= c;

                        if (secondCondition && thirdCondition) {
                            goodTripletsCount++;
                        }
                    }
                }
            }
        }

        return goodTripletsCount;
    }
}
