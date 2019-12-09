package edu.neu.coe.info6205.life.Interface;

import edu.neu.coe.info6205.life.GA.GA;
import edu.neu.coe.info6205.life.base.Point;
import edu.neu.coe.info6205.life.library.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class runGA extends JFrame implements ActionListener{
    JButton select;
    JButton jb1,jb2,jb3=null;
    JRadioButton jrb1,jrb2=null;
    JPanel jp1,jp2,jp3,jp4=null;
    static JTextField jrf,jcf=null;
    static JTextArea result = null;
    JLabel jlb1,jlb2,jlb3=null;
    ButtonGroup bg=null;
    public String r ;
    public int i;

    public static List<Point> points = new ArrayList<>();

    public runGA()
    {
        jb1=new JButton("run");  jb2=new JButton("reset");  jb3=new JButton(" ");

        jrb1=new JRadioButton("1");    jrb2=new JRadioButton("2");

        bg=new ButtonGroup();

        bg.add(jrb1);    bg.add(jrb2);
        jrb2.setSelected(true);

        jp1=new JPanel();  jp2=new JPanel();  jp3=new JPanel();  jp4=new JPanel();

        jlb1=new JLabel("rows:");  jlb2=new JLabel("cols:");  jlb3=new JLabel("result:");

        jrf=new JTextField(10); jcf=new JTextField(10); result = new JTextArea();

        jp1.add(jlb1);jp1.add(jrf);

        jp2.add(jlb2);jp2.add(jcf);

        //jp4.add(jlb3);       jp4.add(jrb1);      jp4.add(jrb2);

        jp3.add(jb1);        jp3.add(jb2);       jp3.add(jb3);  jp4.add(jlb3); jp4.add(result);


        this.add(jp1);       this.add(jp2);      this.add(jp3);       this.add(jp4);

        this.setLayout(new GridLayout(4,1));
        this.setTitle("runGA");
        this.setSize(500,500);
        this.setLocation(650, 200);
        this.setVisible(true);
        this.setResizable(true);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);

        GameFrame.setTime();

    }

    public static int getRows(){
        int r = 0;
        if(!jrf.getText().equals("") && isNumeric(jrf.getText())){
            r = Integer.parseInt(jrf.getText());
            r = r>0? r : 3;
        }
        else r = 3;
        return r;
    }
    public  static int getCols(){
        int c = 0;
        if(!jcf.getText().equals("") && isNumeric(jcf.getText())){
            c = Integer.parseInt(jcf.getText());
            c = c>0? c : 3;
        }
        else c = 3;
        return c;
    }

    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== jb1) {
            int i = 1;
            GA ga = new GA(getRows(),getCols());

            points = ga.run();

            StringBuffer str = new StringBuffer();
            for(Point p:points){
                str.append(p.getX());
                str.append(" ");
                str.append(p.getY());
                str.append(",");
            }
            r = str.toString();

            result.setText(r);
            Library.put("result"+String.valueOf(i++)+" : ",r);


        } else if(e.getSource()== jb2) {
            jrf.setText("");
            jcf.setText("");
        }

    }


}
