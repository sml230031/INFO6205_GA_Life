package edu.neu.coe.info6205.life.Interface;

import edu.neu.coe.info6205.life.base.Game;
import edu.neu.coe.info6205.life.base.Point;
import edu.neu.coe.info6205.life.library.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

public class GameFrame extends JFrame {

        public static String pattern = "Mine";

        private JButton SelectPatternBtn = new JButton("Choose File");
        private JButton startGameBtn = new JButton("StartGame");
        private JButton pauseGameBtn = new JButton("Pause");
        private JLabel durationPromtLabel = new JLabel("              Animation interval setting(ms)");
        private JLabel patternLabel = new JLabel("                    Pattern：");
        //private JLabel patternLabel1 = new JLabel("");
        private static JTextField durationTextField = new JTextField();
        private static JTextField patternTextField = new JTextField();

        private boolean isStart = false;
        private static boolean stop = false;

        //private Matrix cellMatrix;
        private JPanel buttonPanel = new JPanel(new GridLayout(3, 2));
        private JPanel gridPanel = new JPanel();

        public static JTextField[][] textArea;

        private static final int DEFAULT_DURATION = 50;
        private static int duration = DEFAULT_DURATION;
        String Closed="ImportWindow_Closed";

        public static GameControlTask gamecon = new GameControlTask();
        Thread t1 = new Thread(gamecon, "T1");

        public GameFrame() {
            setTitle("Game of Life");
            initGridLayout();
            //SelectPatternBtn.addActionListener(new SelectPatternActioner());
            startGameBtn.addActionListener(new StartGameActioner());
            pauseGameBtn.addActionListener(new PauseGameActioner());

            //buttonPanel.add(SelectPatternBtn);
            buttonPanel.add(pauseGameBtn);
            buttonPanel.add(startGameBtn);
            buttonPanel.add(durationPromtLabel);
            buttonPanel.add(durationTextField);
            buttonPanel.add(patternLabel);
            buttonPanel.add(patternTextField);
            //buttonPanel.add(pauseGameBtn);
            buttonPanel.setBackground(Color.WHITE);

            durationTextField.setEditable(true);
            patternTextField.setEditable(false);

            getContentPane().add("North", buttonPanel);

            this.setSize(1000, 1200);
            this.setLocation(600, 50);
            this.setVisible(true);
            //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            this.gamecon = gamecon;
            setTime();
            durationTextField.setText("");
            Game.MaxGenerations = 1000;
    }

        public static void play(String p){
        String patternName = p;
        System.out.println("Game of Life with starting pattern: " + patternName);
        //new GameFrame();
        pattern = Library.get(patternName);
        patternTextField.setText(patternName+" : "+pattern);
        showPoints(Point.points(pattern));
    }



        public static int getTime(){
        try {
            duration = Integer.parseInt(durationTextField.getText().trim());
        } catch (NumberFormatException e1) {
            duration = DEFAULT_DURATION;
        }
        return duration;
    }
        public static int setTime(){
                duration = 0;
            return duration;
        }

        public static void showPoints(List<Point> Points) {
        for (int x = -50; x < 50; x++) {
            for (int y = -50; y < 50; y++) {
                Point p = new Point(x, -y);
                if (Points.contains(p)) {
                    textArea[x+50][y+50].setBackground(Color.BLACK);
                } else {
                    textArea[x+50][y+50].setBackground(Color.WHITE);
                }
            }
        }
    }

        public static boolean Gamestop(){
        return stop;
    }

        private void initGridLayout() {
        int rows = 100;//grid.getHeight();
        int cols = 100;//grid.getWidth();
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(rows, cols));
        textArea = new JTextField[rows][cols];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                JTextField text = new JTextField();
                textArea[x][y] = text;
                gridPanel.add(text);
            }
        }
        add("Center", gridPanel);
    }

        protected void processWindowEvent(WindowEvent e) {
            super.processWindowEvent(e);
            if (e.getID() == WindowEvent.WINDOW_CLOSING) {
                switch(JFrame.EXIT_ON_CLOSE) {
                    case HIDE_ON_CLOSE:
                        setVisible(false);
                        break;
                    case DISPOSE_ON_CLOSE:
                        dispose();
                        break;
                    case DO_NOTHING_ON_CLOSE:
                    default:
                        break;
                    case EXIT_ON_CLOSE:
                        gamecon.exit=true;
                        //System.exit(-1);
                        t1.stop();
                        break;
                }
            }
    }

        class StartGameActioner implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isStart) {
                    try {
                        duration = Integer.parseInt(durationTextField.getText().trim());
                    } catch (NumberFormatException e1) {
                        duration = DEFAULT_DURATION;
                    }
                    //new Thread(new GameControlTask()).start();
                    //GameControlTask gamecon = new GameControlTask();
                    //Thread t1 = new Thread(gamecon, "T1");
                    gamecon.exit=false;

                    t1.start();

                    //play(MainFrame.getPname());
                    //gamecon.start();
                    isStart = true;
                    stop = false;
                    startGameBtn.setEnabled(false);
                    //startGameBtn.setText("Pause");
                } else {
                    //stop = true;
                    //isStart = false;
                }
            }
        }
        class PauseGameActioner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (!isStart) {
                isStart = true;
                stop = false;
                pauseGameBtn.setText("Pause");
                Game.resumeThread();
            } else {
                stop = true;
                isStart = false;
                pauseGameBtn.setText("Continue");

            }
        }
    }

        public static class GameControlTask extends Thread implements Runnable {
            public volatile boolean exit = false;
            @Override
            public void run() {
               // while (!exit) {
                    final Game.Behavior generations = Game.run(0L, pattern);
                    System.out.println("Ending Game of Life after " + generations + " generations " + "pattern: " + pattern);

            }
        }

}


