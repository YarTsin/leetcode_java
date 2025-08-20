package org.example.g0801_0900.s0860_lemonade_change;

/**
 * Похожее решение с case
 */
public class Solution2 {
    public boolean lemonadeChange(int[] bills) {
        int fiveDollarBills = 0;
        int tenDollarBills = 0;

        for (int currentBill : bills) {
            switch (currentBill) {
                case 5:
                    // Просто принимаем 5$ без сдачи
                    fiveDollarBills++;
                    break;

                case 10:
                    // Нужно дать сдачу 5$
                    if (fiveDollarBills < 1) {
                        return false; // Не можем дать сдачу
                    }
                    fiveDollarBills--;
                    tenDollarBills++;
                    break;

                case 20:
                    // Нужно дать сдачу 15$
                    // Вариант 1: 10$ + 5$ (предпочтительный)
                    if (tenDollarBills >= 1 && fiveDollarBills >= 1) {
                        tenDollarBills--;
                        fiveDollarBills--;
                    }
                    // Вариант 2: 5$ + 5$ + 5$
                    else if (fiveDollarBills >= 3) {
                        fiveDollarBills -= 3;
                    }
                    // Не можем дать сдачу
                    else {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }
}
