package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/*
@author Haomin Wang
@version 1.0.0
@update 2023/10/23 增加行注解
*/
public class Main {
    static int i, j, k;
    //统计正确的题目数量
    static Integer countRight = 0;
    //统计错误的题目数量
    static Integer countFlase = 0;


    public static void main(String[] args) {
        //主菜单页面设计
        //frame 主菜单容器
        Frame frame = new Frame("计算器");
        Random r = new Random();
        Font f1 = new Font("楷体", Font.BOLD, 20);
        Font f2 = new Font("宋体", Font.BOLD, 18);
        Font f3 = new Font("宋体", Font.BOLD, 16);
        frame.setBounds(200, 200, 500, 400);
        //设置布局
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(184, 218, 210));
        frame.addWindowListener(new WindowAdapter() {
            //窗口关闭
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Label title = new Label("口算题卡");
        title.setBounds(190, 40, 180, 30);
        title.setFont(f1);


        frame.add(title);

        //xxLabel 主菜单子标签
        //创建标签
        Label info = new Label("小朋友，今天想练习什么呀？");
        //设置标签的位置
        info.setBounds(125, 70, 380, 30);
        //设置标签字体
        info.setFont(f2);
        //添加标签到主容器
        frame.add(info);

        Label addLabel = new Label("1.加法运算");
        addLabel.setBounds(135, 110, 80, 30);
        addLabel.setFont(f3);

        frame.add(addLabel);

        Label subLabel = new Label("2.减法运算");
        subLabel.setBounds(135, 150, 80, 30);
        subLabel.setFont(f3);
        frame.add(subLabel);

        Label mulitLabel = new Label("3.乘法运算");
        mulitLabel.setBounds(135, 190, 80, 30);
        mulitLabel.setFont(f3);
        frame.add(mulitLabel);

        Label divLabel = new Label("4.除法运算");
        divLabel.setBounds(135, 230, 80, 30);
        divLabel.setFont(f3);
        frame.add(divLabel);

        //成绩查询界面
        Button markButton = new Button("查看成绩");
        markButton.setBounds(350, 330, 80, 30);
        //为按钮添加跳转监听事件
        markButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame markFrame = new Frame("成绩查询");
                markFrame.setBounds(250, 250, 300, 300);
                //将新页面设置为可见
                markFrame.setVisible(true);
                //设置背景颜色
                markFrame.setBackground(new Color(171, 170, 120));
                markFrame.addWindowListener(new WindowAdapter() {
                    //设置窗口关闭按钮
                    public void windowClosing(WindowEvent e) {
                        markFrame.setVisible(false);
                    }
                });
                //设置显示内容
                Label rightNumber = new Label("今天对了" + countRight + "题，太棒了！！");
                markFrame.add(rightNumber);
                rightNumber.setFont(f3);
                rightNumber.setBounds(10, 60, 180, 20);
                Label falseNumber = new Label("今天错了" + countFlase + "题，要继续加油哦！！");
                markFrame.add(falseNumber);
                falseNumber.setFont(f3);
                falseNumber.setBounds(10, 100, 80, 20);
            }
        });
        frame.add(markButton);

        //加法测试界面
        Button b1 = new Button("+");
        b1.setBounds(255, 110, 40, 30);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                Frame addFrame = new Frame("加法界面");
                //设置显示框位置
                addFrame.setBounds(250, 250, 300, 300);
                //不设置特殊格式
                addFrame.setLayout(null);
                //设置标签可见
                addFrame.setVisible(true);
                //设置背景颜色
                addFrame.setBackground(new Color(203, 210, 137));
                addFrame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        addFrame.setVisible(false);
                    }
                });
                TextField t2 = new TextField();
                //设置位置
                t2.setBounds(20, 50, 50, 30);
                t2.setFont(f2);
                addFrame.add(t2);
                //实例化按钮
                Button b5 = new Button("+");
                //设置按钮位置
                b5.setBounds(75, 50, 30, 30);
                addFrame.add(b5);
                //实例化输入框
                TextField t3 = new TextField();
                t3.setBounds(110, 50, 50, 30);
                t3.setFont(f2);
                addFrame.add(t3);
                //实例化按钮
                Button b6 = new Button("=");
                b6.setBounds(165, 50, 30, 30);
                //将按钮添加到主页面
                addFrame.add(b6);
                //实例化输入框
                TextField t4 = new TextField();
                t4.setBounds(200, 50, 50, 30);
                t4.setFont(f2);
                addFrame.add(t4);
                t2.setText("" + (r.nextInt(101)));
                t3.setText("" + (r.nextInt(101)));
                Button b7 = new Button("确定");
                b7.setBounds(120, 110, 50, 40);
                TextField t5 = new TextField();
                t5.setBounds(40, 170, 200, 40);
                t5.setFont(f2);
                addFrame.add(t5);
                b7.addActionListener(new ActionListener() {
                    //监听展示事件
                    public void actionPerformed(ActionEvent a) {
                        //输入数字
                        i = Integer.parseInt(t2.getText());
                        j = Integer.parseInt(t3.getText());
                        k = Integer.parseInt(t4.getText());
                        //正确回答弹窗
                        if (i + j == k) {
                            t5.setText("回答正确");
                            t2.setText("" + (r.nextInt(101)));
                            t3.setText("" + (r.nextInt(101)));
                            t4.setText("");
                            countRight++;
                        } else {
                            //错误回答弹窗
                            t5.setText("" + i + "+" + "" + j + "正确答案:" + (i + j));
                            t2.setText("" + (r.nextInt(101)));
                            t3.setText("" + (r.nextInt(101)));
                            t4.setText("");
                            countFlase++;
                        }
                    }
                });
                addFrame.add(b7);

            }
        });
        frame.add(b1);
        //减法测试界面
        Button b2 = new Button("-");
        b2.setBounds(255, 150, 40, 30);
        b2.addActionListener(new ActionListener() {
            //监听展示事件
            public void actionPerformed(ActionEvent a) {
                Frame subFrame = new Frame("减法法界面");
                subFrame.setBounds(250, 250, 300, 300);
                subFrame.setLayout(null);
                subFrame.setVisible(true);
                subFrame.setBackground(new Color(211, 218, 196));
                subFrame.addWindowListener(new WindowAdapter() {
                    //新增关闭按钮
                    public void windowClosing(WindowEvent e) {
                        subFrame.setVisible(false);
                    }
                });
                //实例化输入框
                TextField t21 = new TextField();
                //设置输入框位置
                t21.setBounds(20, 50, 50, 30);
                //设置字体
                t21.setFont(f2);
                subFrame.add(t21);
                //实例化标签
                Button b51 = new Button("-");
                b51.setBounds(75, 50, 30, 30);
                subFrame.add(b51);
                //实例化输入框
                TextField t31 = new TextField();
                t31.setBounds(110, 50, 50, 30);
                t31.setFont(f2);
                subFrame.add(t31);
                //实例化按钮
                Button b61 = new Button("=");
                b61.setBounds(165, 50, 30, 30);
                subFrame.add(b61);
                TextField t41 = new TextField();
                t41.setBounds(200, 50, 50, 30);
                t41.setFont(f2);
                subFrame.add(t41);
                t21.setText("" + (r.nextInt(101)));
                t31.setText("" + (r.nextInt(101)));
                Button b71 = new Button("确定");
                b71.setBounds(120, 110, 50, 40);
                TextField t51 = new TextField();
                t51.setBounds(40, 170, 200, 40);
                t51.setFont(f2);
                subFrame.add(t51);
                //添加监听事件
                b71.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent a) {
                        i = Integer.parseInt(t21.getText());
                        j = Integer.parseInt(t31.getText());
                        k = Integer.parseInt(t41.getText());
                        if (i - j == k) {
                            t51.setText("回答正确");
                            t21.setText("" + (r.nextInt(101)));
                            t31.setText("" + (r.nextInt(101)));
                            t41.setText("");
                            countRight++;
                        } else {
                            t51.setText("" + i + "-" + "" + j + "正确答案:" + (i - j));
                            t21.setText("" + (r.nextInt(101)));
                            t31.setText("" + (r.nextInt(101)));
                            t41.setText("");
                            countFlase++;
                        }
                    }
                });
                subFrame.add(b71);
            }
        });
        frame.add(b2);
        //乘法测试界面
        Button b3 = new Button("*");
        b3.setBounds(255, 190, 40, 30);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                Frame multiFrame = new Frame("乘法界面");
                //设置位置
                multiFrame.setBounds(250, 250, 300, 300);
                //不设置特殊格式
                multiFrame.setLayout(null);
                //设置可见
                multiFrame.setVisible(true);
                //设置背景颜色
                multiFrame.setBackground(new Color(173, 131, 139));
                multiFrame.addWindowListener(new WindowAdapter() {
                    //添加窗口关闭按钮
                    public void windowClosing(WindowEvent e) {
                        multiFrame.setVisible(false);
                    }
                });
                //设置输入框
                TextField t2 = new TextField();
                //设置位置
                t2.setBounds(20, 50, 50, 30);
                t2.setFont(f2);
                multiFrame.add(t2);
                //实例化按钮
                Button b5 = new Button("*");
                b5.setBounds(75, 50, 30, 30);
                multiFrame.add(b5);
                TextField t3 = new TextField();
                t3.setBounds(110, 50, 50, 30);
                t3.setFont(f2);
                multiFrame.add(t3);
                Button b6 = new Button("=");
                b6.setBounds(165, 50, 30, 30);
                multiFrame.add(b6);
                TextField t4 = new TextField();
                t4.setBounds(200, 50, 50, 30);
                t4.setFont(f2);
                multiFrame.add(t4);
                t2.setText("" + (r.nextInt(10)));
                t3.setText("" + (r.nextInt(10)));
                Button b7 = new Button("确定");
                b7.setBounds(120, 110, 50, 40);
                TextField t5 = new TextField();
                t5.setBounds(40, 170, 200, 40);
                t5.setFont(f2);
                multiFrame.add(t5);
                b7.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent a) {
                        //输入数字
                        i = Integer.parseInt(t2.getText());
                        j = Integer.parseInt(t3.getText());
                        k = Integer.parseInt(t4.getText());
                        if (i * j == k) {
                            t5.setText("回答正确");
                            t2.setText("" + (r.nextInt(10)));
                            t3.setText("" + (r.nextInt(10)));
                            t4.setText("");
                            countRight++;
                        } else {
                            t5.setText("" + i + "*" + "" + j + "正确答案:" + (i * j));
                            t2.setText("" + (r.nextInt(10)));
                            t3.setText("" + (r.nextInt(10)));
                            t4.setText("");
                            countFlase++;
                        }

                    }
                });
                multiFrame.add(b7);

            }
        });
        frame.add(b3);
        //除法测试界面
        Button b4 = new Button("/");
        b4.setBounds(255, 230, 40, 30);
        //添加监听
        b4.addActionListener(new ActionListener() {
            //监听展示事件
            public void actionPerformed(ActionEvent a) {
                Frame divFrame = new Frame("除法界面");
                divFrame.setBounds(250, 250, 300, 300);
                divFrame.setLayout(null);
                divFrame.setVisible(true);
                divFrame.setBackground(new Color(225, 218, 211));
                divFrame.addWindowListener(new WindowAdapter() {
                    //窗口关闭
                    public void windowClosing(WindowEvent e) {
                        divFrame.setVisible(false);
                    }
                });
                //添加输入框
                TextField t2 = new TextField();
                //设置位置
                t2.setBounds(20, 50, 50, 30);
                //设置字体
                t2.setFont(f2);
                divFrame.add(t2);
                Button b5 = new Button("/");
                b5.setBounds(75, 50, 30, 30);
                divFrame.add(b5);
                TextField t3 = new TextField();
                t3.setBounds(110, 50, 50, 30);
                t3.setFont(f2);
                divFrame.add(t3);
                Button b6 = new Button("=");
                b6.setBounds(165, 50, 30, 30);
                divFrame.add(b6);
                TextField t4 = new TextField();
                t4.setBounds(200, 50, 50, 30);
                t4.setFont(f2);
                divFrame.add(t4);
                //输入数字
                t2.setText("" + (r.nextInt(101)));
                t3.setText("" + (r.nextInt(101) + 1));
                Button b7 = new Button("确定");
                b7.setBounds(120, 110, 50, 40);
                TextField t5 = new TextField();
                t5.setBounds(40, 170, 200, 40);
                t5.setFont(f2);
                divFrame.add(t5);
                //添加监听
                b7.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent a) {
                        //输入数字
                        i = Integer.parseInt(t2.getText());
                        j = Integer.parseInt(t3.getText());
                        k = Integer.parseInt(t4.getText());

                        if (i / j == k) {
                            t5.setText("回答正确");
                            t2.setText("" + (r.nextInt(101)));
                            t3.setText("" + (r.nextInt(101) + 1));
                            t4.setText("");
                            countRight++;

                        } else {
                            t5.setText("" + i + "/" + "" + j + "正确答案:" + (i / j));
                            t2.setText("" + (r.nextInt(101)));
                            t3.setText("" + (r.nextInt(101) + 1));
                            t4.setText("");
                            countFlase++;
                        }

                    }
                });
                divFrame.add(b7);

            }
        });
        frame.add(b4);
    }

}
