package com.yiliao.menzhen.ui;

import cn.hutool.core.io.FileUtil;
import com.yiliao.menzhen.domain.User;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RegisterJFrame extends JFrame implements MouseListener {
    //用于存储已注册的用户信息
    ArrayList<User> allUsers;

    JTextField username = new JTextField();
    JTextField password = new JTextField();
    JTextField rePassword = new JTextField();

    JButton submit = new JButton();
    JButton reset = new JButton();

    public RegisterJFrame(ArrayList<User> allUsers) {
        //将存储的用户信息接收
        this.allUsers = allUsers;
        //初始化界面
        initFrame();
        //在这个界面中添加内容
        initView();
        //让当前界面显示出来
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //点击了注册按钮
        if (e.getSource() == submit) {
            if (username.getText().length() == 0 || password.getText().length() == 0 || rePassword.getText().length() == 0) {
                showDialog("用户名和密码不能为空");
                return;
            }
            if (!password.getText().equals(rePassword.getText())) {
                showDialog("两次密码输入不一致");
                return;
            }
            if (!username.getText().matches("[a-zA-Z0-9]{4,16}")) {
                showDialog("用户名不符合规则,长度至少4位,最多16位");
                return;
            }
            if (!password.getText().matches("\\S*(?=\\S{6,})(?=\\S*\\d)(?=\\S*[a-z])\\S*")) {
                showDialog("密码不符合规则，至少包含1个小写字母，1个数字，长度至少6位");
                return;
            }
            if (containsUsername(username.getText())) {
                showDialog("用户名已经存在，请重新输入");
                return;
            }
            allUsers.add(new User(username.getText(), password.getText()));
            File file = new File("resources/userinfo.txt");
            FileUtil.writeLines(allUsers, file, "UTF-8");
            showDialog("注册成功");
            this.setVisible(false);
            new LoginJFrame();
            //点击了重置按钮
        } else if (e.getSource() == reset) {
            username.setText("");
            password.setText("");
            rePassword.setText("");
        }
    }

    //判断username在集合中是否存在
    private boolean containsUsername(String username) {
        for (User u : allUsers) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    //按下按键
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == submit) {
            submit.setIcon(new ImageIcon("resources\\image\\register\\注册按下.png"));
        } else if (e.getSource() == reset) {
            reset.setIcon(new ImageIcon("resources\\image\\register\\重置按下.png"));
        }
    }

    //松开按键
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == submit) {
            submit.setIcon(new ImageIcon("resources\\image\\register\\注册按钮.png"));
        } else if (e.getSource() == reset) {
            reset.setIcon(new ImageIcon("resources\\image\\register\\重置按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //在这个界面中添加内容
    private void initView() {
        JLabel usernameText = new JLabel(new ImageIcon("resources\\image\\register\\注册用户名.png"));
        usernameText.setBounds(85, 135, 80, 20);

        username.setBounds(195, 134, 200, 30);

        JLabel passwordText = new JLabel(new ImageIcon("resources\\image\\register\\注册密码.png"));
        passwordText.setBounds(97, 193, 70, 20);

        password.setBounds(195, 195, 200, 30);

        JLabel rePasswordText = new JLabel(new ImageIcon("resources\\image\\register\\再次输入密码.png"));
        rePasswordText.setBounds(64, 255, 95, 20);

        rePassword.setBounds(195, 255, 200, 30);

        submit.setIcon(new ImageIcon("resources\\image\\register\\注册按钮.png"));
        submit.setBounds(123, 310, 128, 47);
        submit.setBorderPainted(false);
        submit.setContentAreaFilled(false);
        submit.addMouseListener(this);

        reset.setIcon(new ImageIcon("resources\\image\\register\\重置按钮.png"));
        reset.setBounds(256, 310, 128, 47);
        reset.setBorderPainted(false);
        reset.setContentAreaFilled(false);
        reset.addMouseListener(this);

        JLabel background = new JLabel(new ImageIcon("resources/image/background/传智健康.png"));
        background.setBounds(0, 0, 470, 390);

        this.getContentPane().add(usernameText);
        this.getContentPane().add(passwordText);
        this.getContentPane().add(rePasswordText);
        this.getContentPane().add(username);
        this.getContentPane().add(password);
        this.getContentPane().add(rePassword);
        this.getContentPane().add(submit);
        this.getContentPane().add(reset);
        this.getContentPane().add(background);
    }

    //初始化界面
    private void initFrame() {
        setSize(488, 430);
        setTitle("用户注册");
        setLayout(null);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
    }

    //展示弹框
    public void showDialog(String content) {
        JDialog jDialog = new JDialog();
        if (!jDialog.isVisible()) {
            jDialog.getContentPane().removeAll();
            JLabel jLabel = new JLabel(content);
            jLabel.setBounds(0, 0, 200, 150);
            jDialog.add(jLabel);
            jDialog.setSize(200, 150);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setVisible(true);
        }
    }


}
