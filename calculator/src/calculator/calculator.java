package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class calculator extends JFrame
{
    JPanel mainPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    static JLabel show = new JLabel();
    static calculate calculate = new calculate();
    boolean start;
    boolean isExist;
    double result;
    String insert;
    public static void main(String[] args){
        new calculator();
    }
    public calculator(){
        initial();
    }
    public void initial(){
        this.setVisible(true);
        this.setSize(400,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("簡易計算機");
        this.setResizable(false);
        Image image = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("images.jpg"));
        this.setIconImage(image);

        start=true;
        isExist = false;
        insert = "=";
        result = 0.0;

        mainPanel.setLayout(new BorderLayout());
        show.setText("0");
        buttonPanel.setLayout(new GridLayout(5,4));
        actionListener1 a1 = new actionListener1();
        actionListener2 a2 = new actionListener2();
        actionListener3 a3 = new actionListener3();
        this.addButton("",a1);
        this.addButton("",a1);
        this.addButton("AC" , a1);
        this.addButton("D",a1);
        this.addButton("7",a3);
        this.addButton("8",a3);
        this.addButton("9",a3);
        this.addButton("×",a2);
        this.addButton("4" ,a3);
        this.addButton("5",a3);
        this.addButton("6", a3);
        this.addButton("-",a2);
        this.addButton("1",a3);
        this.addButton("2",a3);
        this.addButton("3",a3);
        this.addButton("+",a2);
        this.addButton("0",a3);
        this.addButton(".",a3);
        this.addButton("=",a2);
        this.addButton("÷", a2);
        mainPanel.add(show,"North");
        mainPanel.add(buttonPanel,"Center");
        this.add(mainPanel);
    }
    public void addButton(String content , ActionListener listener){
        JButton button = new JButton(content);
        button.addActionListener(listener);
        buttonPanel.add(button);
    }
}
