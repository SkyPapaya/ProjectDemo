import java.util.Scanner;

public class Main {
    //打印空格
    public static void blank() {

        System.out.print(" ");
    }

    //打印符号
    public static void sign() {

        System.out.print("*");

    }

    //打印倒三角
    public static void printStar(int x) {

        //打印几行
        for (int j = 0; j < x; j++) {
            //left blank
            for (int i = 0; i < j; i++) {
                blank();
            }
            //left sign
            for (int i = 0; i < x - j - 1; i++) {
                sign();
            }
            //middle sign
            System.out.print("*");
            //right sign
            for (int i = 0; i < x - j - 1; i++) {
                sign();
            }
            System.out.println("");


        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要打印的三角形行数:");
        int lines = sc.nextInt();
        printStar(lines);

    }
}