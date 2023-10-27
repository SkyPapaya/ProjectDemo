import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //生成随机数
        double number = (Math.random() + 1);
        int trueNumber = (int) (number * 100);
        System.out.println("随机数是：" + trueNumber);
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        while (input != trueNumber) {
            if (input < trueNumber) {
                System.out.println("猜小了");

            }
            if (input > trueNumber) {
                System.out.println("猜大了");
            }
            input = sc.nextInt();
        }
        System.out.println("猜对了");

    }
}