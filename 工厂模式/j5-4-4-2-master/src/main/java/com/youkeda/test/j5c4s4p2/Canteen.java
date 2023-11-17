package com.youkeda.test.j5c4s4p2;

/**
 * 餐厅
 */
public class Canteen {
    public Food getFood(String name) {
        Food food = null;
        if ("rice".equals(name)) {
            Rice rice = new Rice();
            rice.setName("米饭");
            food = rice;
        } else if ("tomato".equals(name)) {
            Tomato tomato = new Tomato();
            tomato.setName("番茄炒蛋");
            food = tomato;
        } else if ("beef".equals(name)) {
            Beef beef = new Beef();
            beef.setName("牛肉");
            food = beef;
        }

        return food;
    }
}
