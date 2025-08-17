package org.example.g0101_0200.s0121_best_time_to_buy_and_sell_stock;

/**
 * #Easy #Array
 * Задача: дан массив цен на акции, где prices[i] -
 * цена акции в i-й день. Нужно найти максимальную прибыль,
 * которую можно получить, купив акции в один день и продав в
 * другой (более поздний) день. Если прибыль получить невозможно, вернуть 0.
 *
 * Пример:
 * Input: [7,1,5,3,6,4]
 * Output: 5 (купить в день 2 по цене 1, продать в день 5 по цене 6)
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0]; // Начальная минимальная цена
        int maxProfit = 0;        // Начальная максимальная прибыль

        for (int i = 1; i < prices.length; i++) {
            // Если текущая цена меньше минимальной - обновляем минимум
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // Иначе проверяем, не дает ли текущая цена большую прибыль
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}