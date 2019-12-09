package edu.neu.coe.info6205.life.Interface;

import edu.neu.coe.info6205.life.library.Library;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PatternLibrary extends JFrame {
    private DefaultTableModel model = null;
    private JTable table = null;
    public int i,j = 1;
    public static String pattern;
    public String points;
    private JButton reBtn;
    private JButton selectBtn;

    public PatternLibrary()
    {
        //super("PatternLibrary");
        String[][] datas = {};
        String[] titles = { "PatternName", "Points" };
        model = new DefaultTableModel(datas, titles);
        table = new JTable(model);
        reBtn = new JButton("refresh");
        selectBtn = new JButton("select");

        selectBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                int selectedrow = table.getSelectedRow();
                if(selectedrow > 0){
                    pattern = (String)table.getValueAt(selectedrow, 0);
                    points = (String)table.getValueAt(selectedrow, 1);
                    GameFrame g = new GameFrame();
                    g.play(pattern);
                }
                else
                    JOptionPane.showMessageDialog(null,"Please select any row");

            }
        });
        reBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                populateTable();
            }
        });

        add(reBtn, BorderLayout.NORTH);
        add(new JScrollPane(table));
        add(selectBtn, BorderLayout.SOUTH);

        setSize(400, 300);
        setLocationRelativeTo(null);
        this.setLocation(650, 200);
        this.setSize(600, 600);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        populateTable();
    }

    public static String getPatternName() {
        return pattern;
    }

    public String getPoints() {
        return points;
    }

    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel)table.getModel();
        dtm.setRowCount(0);
        for(String key : Library.map.keySet()){

            Object row[] = new Object[2];
            row[0] = key;
            row[1] = Library.map.get(key);
            dtm.addRow(row);

        }
    }


}
