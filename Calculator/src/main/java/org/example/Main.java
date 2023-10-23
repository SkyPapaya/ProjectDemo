package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;


public class Main {
    static int i, j, k;
    static Integer countRight = 0;
    static Integer countFlase = 0;

    public static void main(String[] args) {


        //主菜单页面设计
        Frame frame = new Frame("计算器");
        JLabel backgroundImg = new JLabel(new ImageIcon("./target/1.png"));
        frame.add(backgroundImg);


        Random r = new Random();
        Font f1 = new Font("楷体", Font.BOLD, 20);
        Font f2 = new Font("宋体", Font.BOLD, 18);
        Font f3 = new Font("宋体", Font.BOLD, 16);
        frame.setBounds(200, 200, 500, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(184, 218, 210));
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        Label title = new Label("口算题卡");
        title.setBounds(190, 40, 180, 30);
        title.setFont(f1);


        frame.add(title);

        Label info = new Label("小朋友，今天想练习什么呀？");
        info.setBounds(125, 70, 380, 30);
        info.setFont(f2);
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
        markButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame markFrame = new Frame("成绩查询");
                markFrame.setBounds(250, 250, 300, 300);
                markFrame.setVisible(true);
                markFrame.setBackground(new Color(171, 170, 120));
                markFrame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        markFrame.setVisible(false);
                    }
                });
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
                addFrame.setBounds(250, 250, 300, 300);
                addFrame.setLayout(null);
                addFrame.setVisible(true);
                addFrame.setBackground(new Color(203, 210, 137));
                addFrame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        addFrame.setVisible(false);
                    }
                });
                TextField t2 = new TextField();
                t2.setBounds(20, 50, 50, 30);
                t2.setFont(f2);
                addFrame.add(t2);
                Button b5 = new Button("+");
                b5.setBounds(75, 50, 30, 30);
                addFrame.add(b5);
                TextField t3 = new TextField();
                t3.setBounds(110, 50, 50, 30);
                t3.setFont(f2);
                addFrame.add(t3);
                Button b6 = new Button("=");
                b6.setBounds(165, 50, 30, 30);
                addFrame.add(b6);
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
                    public void actionPerformed(ActionEvent a) {
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
            public void actionPerformed(ActionEvent a) {
                Frame subFrame = new Frame("减法法界面");
                subFrame.setBounds(250, 250, 300, 300);
                subFrame.setLayout(null);
                subFrame.setVisible(true);
                subFrame.setBackground(new Color(211, 218, 196));
                subFrame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        subFrame.setVisible(false);
                    }
                });
                TextField t21 = new TextField();
                t21.setBounds(20, 50, 50, 30);
                t21.setFont(f2);
                subFrame.add(t21);
                Button b51 = new Button("-");
                b51.setBounds(75, 50, 30, 30);
                subFrame.add(b51);
                TextField t31 = new TextField();
                t31.setBounds(110, 50, 50, 30);
                t31.setFont(f2);
                subFrame.add(t31);
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
                multiFrame.setBounds(250, 250, 300, 300);
                multiFrame.setLayout(null);
                multiFrame.setVisible(true);
                multiFrame.setBackground(new Color(173, 131, 139));
                multiFrame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        multiFrame.setVisible(false);
                    }
                });
                TextField t2 = new TextField();
                t2.setBounds(20, 50, 50, 30);
                t2.setFont(f2);
                multiFrame.add(t2);
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
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                Frame divFrame = new Frame("除法界面");
                divFrame.setBounds(250, 250, 300, 300);
                divFrame.setLayout(null);
                divFrame.setVisible(true);
                divFrame.setBackground(new Color(225, 218, 211));
                divFrame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        divFrame.setVisible(false);
                    }
                });
                TextField t2 = new TextField();
                t2.setBounds(20, 50, 50, 30);
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
                t2.setText("" + (r.nextInt(101)));
                t3.setText("" + (r.nextInt(101) + 1));
                Button b7 = new Button("确定");
                b7.setBounds(120, 110, 50, 40);
                TextField t5 = new TextField();
                t5.setBounds(40, 170, 200, 40);
                t5.setFont(f2);
                divFrame.add(t5);
                b7.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent a) {
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
