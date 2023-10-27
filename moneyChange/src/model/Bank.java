package model;

import java.util.ArrayList;
import java.util.List;

    public class Bank {
        private String name;
        private int[] smallChanges;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int[] getSmallChanges() {
            return smallChanges;
        }

        public void setSmallChanges(int[] smallChanges) {
            this.smallChanges = smallChanges;
        }

        public int change(Human human) {
            int amount = human.getAmount();
            String name = human.getName();
            int[] type = getSmallChanges();
            return sumTime(type, amount, human);
        }

        //获取零钱个数
        private static int sumTime(int[] smallChanges, int amount, Human human) {
            int size = smallChanges.length;
            int start = 0;
            amount = human.getAmount();
            List<Integer> list = new ArrayList<>();

            //对零钱进行升序排列
            sort(smallChanges);
            return getTime(smallChanges, amount);
        }


        //升序零钱排序
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

        //获取得到零钱的个数
        private static int getTime(int[] smallMoney, int amount) {
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
                return 0;
            }
            if(amount != 0){
                return -1;
            }
            return sumTime;
        }
    }
