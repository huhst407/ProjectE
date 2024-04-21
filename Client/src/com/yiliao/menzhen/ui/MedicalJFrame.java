package com.yiliao.menzhen.ui;

import javax.swing.*;
import java.awt.*;

public class MedicalJFrame extends JFrame {
    public MedicalJFrame() {
        this.setTitle("医疗门诊系统 主菜单");
        setLayout(new GridLayout(5, 0));
        JButton jb1 = new JButton("会员管理");
        JButton jb2 = new JButton("预约管理");
        JButton jb3 = new JButton("健康评估");
        JButton jb4 = new JButton("健康干预");
        JButton jb5 = new JButton("退出");
        add(jb1);add(jb2);add(jb3);add(jb4);add(jb5);

        //给主页面设置显示位置,大小
        setBounds(500, 200, 500, 500);
        //设置显示该图形化界面
        setVisible(true);
        //设置关闭模式 当前模式为界面与程序运行同时关闭
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
