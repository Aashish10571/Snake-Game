package Main;

import javax.swing.*;

public class GameFrame {
    public static void main(String[] args) {
        GamePanel panel = new GamePanel();

        JFrame frame = new JFrame("Snake Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
