package edu.neu.coe.info6205.life.Interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame{
    private JPanel panel1;
    private JButton chooseButton;
    private JButton startButton;
    private JPanel Jpanel2;
    private view v;

    public Frame() {
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view v = new view();
                //JSplitPane.setRightComponent(v);
                Jpanel2.add(v);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Frame");
        frame.setContentPane(new Frame().panel1);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(1000,1000);
    }
}
