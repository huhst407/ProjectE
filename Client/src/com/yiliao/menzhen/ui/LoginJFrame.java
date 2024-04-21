package com.yiliao.menzhen.ui;


import cn.hutool.core.io.FileUtil;
import com.yiliao.menzhen.domain.User;
import com.yiliao.menzhen.uti.CodeUtil;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LoginJFrame extends JFrame implements MouseListener {
    //用于存储已注册的用户信息
    ArrayList<User> allUsers = new ArrayList<>();

    JButton login = new JButton();
    JButton register = new JButton();
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JTextField code = new JTextField();
    //正确的验证码
    JLabel rightCode = new JLabel();

    public LoginJFrame() {
        //读取本地文件中的用户信息
        readUserInfo();
        //初始化界面
        initJFrame();
        //在这个界面中添加内容
        initView();
        //让当前界面显示出来
        this.setVisible(true);
    }

    //读取本地文件中的用户信息
    //暂时IO读取文件数据 还没连接到后端数据库
    private void readUserInfo() {
        File file = new File("resources/userinfo.txt");
        List<String> userInfoStrList = FileUtil.readUtf8Lines(file);
        for (String str : userInfoStrList) {
            String[] userInfoArr = str.split("&");
            String[] arr1 = userInfoArr[0].split("=");
            String[] arr2 = userInfoArr[1].split("=");
            User user = new User(arr1[1], arr2[1]);
            allUsers.add(user);
        }
    }

    //点击事件
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == login) {
            String usernameInput = username.getText();
            String passwordInput = password.getText();
            String codeInput = code.getText();

            User userInfo = new User(usernameInput, passwordInput);

            if (codeInput.length() == 0) {
                showJDialog("验证码不能为空");
            } else if (usernameInput.length() == 0 || passwordInput.length() == 0) {
                showJDialog("用户名或密码为空");
            } else if (!codeInput.equalsIgnoreCase(rightCode.getText())) {
                showJDialog("验证码错误");
            } else if (contains(userInfo)) {
                this.setVisible(false);
                new MedicalJFrame();
            } else {
                showJDialog("用户名或密码错误");
            }
        } else if (e.getSource() == register) {
            this.setVisible(false);
            new RegisterJFrame(allUsers);
        } else if (e.getSource() == rightCode) {
            String code = CodeUtil.getCode();
            rightCode.setText(code);
        }
    }

    //展示弹框
    private void showJDialog(String content) {
        JDialog jDialog = new JDialog();
        if (!jDialog.isVisible()) {
            jDialog.setSize(200, 150);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);

            JLabel warning = new JLabel(content);
            warning.setBounds(0, 0, 200, 150);
            jDialog.getContentPane().add(warning);

            jDialog.setVisible(true);
        }
    }

    //按下不松
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("resources\\image\\login\\登录按下.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("resources\\image\\login\\注册按下.png"));
        }
    }

    //松开按钮
    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("resources\\image\\login\\登录按钮.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("resources\\image\\login\\注册按钮.png"));
        }
    }

    //鼠标划入
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    //鼠标划出
    @Override
    public void mouseExited(MouseEvent e) {

    }

    //判断用户在集合中是否存在
    private boolean contains(User userInput) {
        for (int i = 0; i < allUsers.size(); i++) {
            User rightUser = allUsers.get(i);
            if (userInput.getUsername().equals(rightUser.getUsername()) && userInput.getPassword().equals(rightUser.getPassword())) {
                return true;
            }
        }
        return false;
    }

    //在这个界面中添加内容
    private void initView() {
        JLabel usernameText = new JLabel(new ImageIcon("resources\\image\\login\\用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);

        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        JLabel passwordText = new JLabel(new ImageIcon("resources\\image\\login\\密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        JLabel codeText = new JLabel(new ImageIcon("resources\\image\\login\\验证码.png"));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);

        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);

        String codeStr = CodeUtil.getCode();
        rightCode.setText(codeStr);
        rightCode.addMouseListener(this);
        rightCode.setBounds(300, 256, 50, 30);
        this.getContentPane().add(rightCode);

        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("resources\\image\\login\\登录按钮.png"));
        login.setBorderPainted(false);
        login.setContentAreaFilled(false);
        login.addMouseListener(this);
        this.getContentPane().add(login);

        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("resources\\image\\login\\注册按钮.png"));
        register.setBorderPainted(false);
        register.setContentAreaFilled(false);
        register.addMouseListener(this);
        this.getContentPane().add(register);

        JLabel background = new JLabel(new ImageIcon("resources/image/background/登录背景.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }

    //初始化界面
    private void initJFrame() {
        this.setSize(488, 430);
        this.setTitle("用户登录");
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setLayout(null);
    }
}
