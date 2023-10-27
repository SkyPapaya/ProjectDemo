package com.youkeda.p2.test;

public class Test {
    public static void main(String[] args) {
        int[] smallMoney = {186, 419, 83, 408};
        int amount = 6249;
        int start = 0;
        int thisTime;
        int sumTime = 0;
        sort(smallMoney);

        while (start < smallMoney.length) {
            thisTime = amount / smallMoney[start];
            amount = amount - thisTime * smallMoney[start];
            sumTime = sumTime + thisTime;
            start++;
        }
        if(sumTime == 0){
            System.out.println(0);
            return;
        }
        if(amount != 0){
            System.out.println(-1);
            return;
        }
        System.out.println(sumTime);

    }

    private static int[] sort(int[] smallMoney) {
        for (int i = 0; i < smallMoney.length; i++) {
            for (int j = 0; j < smallMoney.length - 1 - i; j++) {

                if (smallMoney[j] < smallMoney[j + 1]) {
                    int temp = smallMoney[j];
                    smallMoney[j] = smallMoney[j + 1];
                    smallMoney[j + 1] = temp;
                }
            }
        }
        return smallMoney;

    }

}
