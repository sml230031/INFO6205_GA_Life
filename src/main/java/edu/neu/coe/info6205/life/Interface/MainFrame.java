package edu.neu.coe.info6205.life.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    JButton jb1,jb2,jb3=null;
    JPanel jp1,jp2,jp3,jp4=null;
    //JLabel jlb1,jlb2,jlb3,jlb4,jlb5,jlb6=null;
    public static String patternName;

    public static void main(String[] args) {
        //JFrame MainFrame = new JFrame("Frame");
        MainFrame ui=new MainFrame();
        //ui.setContentPane(new Frame());
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.pack();
        ui.setVisible(true);
        ui.setSize(400,300);
        //patternName = args.length > 0 ? args[0] : "Blip";
        //patternName = PatternLibrary.getPatternName()!=null ? PatternLibrary.getPatternName() : "Blip";
    }

    public MainFrame()
    {
        jb1=new JButton("Play");
        jb1.setForeground(Color.BLUE);
        jb2=new JButton("PatternLibrary");
        jb2.setForeground(Color.BLUE);
        jb3=new JButton("GA");
        jb3.setForeground(Color.BLUE);

        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jp1.add(jb1);
        jp2.add(jb2);
        jp3.add(jb3);
        //jp3.add(jlb3);
        //jp3.add(jlb4);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.setLayout(new GridLayout(4,3,50,50));
        this.setTitle("Game of Life");
        //this.setSize(400,300);
        this.setLocation(200, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
    }
    public static String getPname(){
        return patternName;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jb1){
            //dispose();
            GameFrame g = new GameFrame();
            patternName = PatternLibrary.getPatternName()!=null ? PatternLibrary.getPatternName() : "Glider2";//"Blip";
            g.play(patternName);
            //new GameFrame();
        }else if(e.getSource() == jb2){
            //dispose();
            new PatternLibrary();    // PatternLibrary/runGA
        }else if(e.getSource() == jb3){
            //dispose();
            new runGA();
        }

    }

}
