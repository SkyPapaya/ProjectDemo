/**
 * 自定义方法的例子
 */
public class CustomTest1 {

    public static void main(String[] args) {

        System.out.println("测试方法的调用");
        // 这里执行一下 newLine 这个自定义方法的调用
        newLine;
    }

    public static void newLine() {
        System.out.println("123");
    }

}