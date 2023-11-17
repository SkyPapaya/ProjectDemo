package com.youkeda;

import com.youkeda.test.j5c4s4p2.DiningArea;
import com.youkeda.test.j5c4s4p2.Drink;
import com.youkeda.test.j5c4s4p2.Food;
import com.youkeda.test.j5c4s4p2.RestaurantGuide;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class YkdTest {

  public static void error(String msg) {
    System.err.println("<YkdError>" + msg + "</YkdError>");
}

@Test
public void runB() {
    PrintStream out = System.out;

    boolean checkResult = checkClass(out);
    if (!checkResult) {
        return;
    }

    RestaurantGuide rg = new RestaurantGuide();

    DiningArea foodFactory = rg.guideEat("food");

    if (foodFactory == null) {
        error("调用 RestaurantGuide 类的 guideEat(\"food\") 方法返回结果为 null ");
    }

    Food rice = foodFactory.getFood("rice");
    if (rice == null || !"米饭".equals(rice.getName())) {
        error("输入`rice`应该输出“米饭”");
    }

    Food tomato = foodFactory.getFood("tomato");
    if (tomato == null || !"番茄炒蛋".equals(tomato.getName())) {
        error("输入`tomato`应该输出“番茄炒蛋”");
    }

    Food beef = foodFactory.getFood("beef");
    if (beef == null || !"牛肉".equals(beef.getName())) {
        error("输入`beef`应该输出“牛肉”");
    }

    DiningArea drinkFactory = rg.guideEat("drink");

    if (drinkFactory == null) {
        error("调用 RestaurantGuide 类的 guideEat(\"drink\") 方法返回结果为 null ");
    }

    Drink tea = drinkFactory.getDrink("tea");
    if (tea == null || !"乌龙茶".equals(tea.getName())) {
        error("输入`tea`应该输出“乌龙茶”");
    }

    Drink juice = drinkFactory.getDrink("juice");
    if (juice == null || !"芒果汁".equals(juice.getName())) {
        error("输入`juice`应该输出“芒果汁”");
    }
}

private boolean checkClass(PrintStream out) {
    boolean result = true;
    try {
        Class<?> afClass = Class.forName("com.youkeda.test.j5c4s4p2.AbstractFood");
        Method method = afClass.getDeclaredMethod("setName", String.class);
        Method method2 = afClass.getDeclaredMethod("getName");
        Field field = afClass.getDeclaredField("name");
    } catch (ClassNotFoundException e) {
        System.setOut(out);
        error("没有创建`com.youkeda.test.j5c4s4p2.AbstractFood`类");
        result = false;
    } catch (NoSuchMethodException e) {
        System.setOut(out);
        error("`com.youkeda.test.j5c4s4p2.AbstractFood`类没有创建`setName(String)`方法和`getName()`方法");
        result = false;
    } catch (NoSuchFieldException e) {
        System.setOut(out);
        error("`com.youkeda.test.j5c4s4p2.AbstractFood`类没有创建`name`属性");
        result = false;
    }

    try {
        Class<?> afClass = Class.forName("com.youkeda.test.j5c4s4p2.AbstractDrink");
        Method method = afClass.getDeclaredMethod("setName", String.class);
        Method method2 = afClass.getDeclaredMethod("getName");
        Field field = afClass.getDeclaredField("name");
    } catch (ClassNotFoundException e) {
        System.setOut(out);
        error("没有创建`com.youkeda.test.j5c4s4p2.AbstractDrink`类");
        result = false;
    } catch (NoSuchMethodException e) {
        System.setOut(out);
        error("`com.youkeda.test.j5c4s4p2.AbstractDrink`类没有创建`setName(String)`方法和`getName()`方法");
        result = false;
    } catch (NoSuchFieldException e) {
        System.setOut(out);
        error("`com.youkeda.test.j5c4s4p2.AbstractDrink`类没有创建`name`属性");
        result = false;
    }

    return result;
}

}
