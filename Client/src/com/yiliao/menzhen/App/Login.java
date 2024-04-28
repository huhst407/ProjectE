package com.yiliao.menzhen.App;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{

    public static void main(String[] args) {
        new Login("测试");
    }
    public Login(String name){
        super(name);
        JPanel jp1 = new JPanel();
        JLabel jl1 = new JLabel("账号");
        JTextField username = new JTextField(10);

        jp1.setLayout(new FlowLayout());
        jp1.add(jl1);
        jp1.add(username);

        JPanel jp2 = new JPanel();
        JLabel jl2 = new JLabel("密码");
        JPasswordField pw = new JPasswordField(10);
        pw.setEchoChar('*');
        jp2.setLayout(new FlowLayout());
        jp2.add(jl2);
        jp2.add(pw);

        JButton ok = new JButton("登录");
        JButton quit = new JButton("注册");
        JPanel jp3 = new JPanel();
        jp3.setLayout(new FlowLayout());
        jp3.add(ok);
        jp3.add(quit);

        this.setLayout(new GridLayout(3,2));
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.setAlwaysOnTop(true);
        //this.setSize(1000, 900);
        this.setBounds(300,200,5000,500);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

