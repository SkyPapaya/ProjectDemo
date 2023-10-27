import java.util.*;

public class                                                                                                                                                                                                                                     Main {
    public static void main(String[] args) {
        int[] test = {22, 34, 565, 11, 4141, 447, 489};
        profit(test);
        System.out.println(test);
    }

    public static void profit(int[] prices) {
        int buy = 0;
        int sold = 1;
        int money;
        int times = 0;
        Map<Integer, Integer> moneyAndTimes = new HashMap<>();
        Map<Integer, String> buyAndSold = new HashMap<>();
        if (prices.length == 1) {
            System.out.println("第 1 天买入，第 1 天卖出，盈利 0");
            return;
        }
        while (buy < sold) {
            money = prices[sold] - prices[buy];
            sold++;
            times++;
            String days = buy + 1 + "," + sold;
            //存入买入卖出日期
            buyAndSold.put(times, days);
            moneyAndTimes.put(times, money);
            if (sold == prices.length) {
                buy++;
                sold = buy + 1;
            }
            if (buy == prices.length - 2) {
                money = prices[buy] - prices[sold];
                times++;
                moneyAndTimes.put(times, money);
                //存入买入卖出日期
                buyAndSold.put(times, days);
                break;
            }
        }
        if (selectProfit(moneyAndTimes) <= 0) {
            //保本结果
            System.out.println("第 1 天买入，第 1 天卖出，盈利 0");
            return;
        }
        //获得了最大的利润对应的循环次数
        int timeValue = times(moneyAndTimes, selectProfit(moneyAndTimes));
        String date = buyAndSold.get(timeValue);
        String buyData = date.substring(0, 1);
        String soldData = date.substring(2, 3);
        //正常结果
        System.out.println("第 " + buyData + " 天买入，第 " + soldData + " 天卖出，盈利 " + selectProfit(moneyAndTimes));
    }

    //找出最大利润
    public static int selectProfit(Map<Integer, Integer> moneyAndTimes) {
        int[] profit = new int[moneyAndTimes.size()];
        int i = 1;
        while (i < moneyAndTimes.size()) {
            int number = moneyAndTimes.get(i);
            profit[i] = number;
            i++;
        }
        bubbleSort(profit);
        return Math.max(profit[0], profit[profit.length - 1]);

    }

    //寻找最大利润对应的循环次数
    public static int times(Map<Integer, Integer> moneyAndTimes, int value) {

        List<Object> list = new ArrayList<>();
        for (int key : moneyAndTimes.keySet()) {
            if (moneyAndTimes.get(key) == value) {
                list.add(key);
            }

        }
        return (int) list.get(0);
    }

    //排序
    public static void bubbleSort(int[] array) {
        // 每次循环，都能冒泡出剩余元素中最大的元素，因此需要循环 array.length 次
        for (int i = 0; i < array.length; i++) {
            // 每次遍历，只需要遍历 0 到 array.length - i - 1中元素，因此之后的元素都已经是最大的了
            for (int j = 0; j < array.length - i - 1; j++) {
                // 交换元素
                if (array[j] < array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }


}