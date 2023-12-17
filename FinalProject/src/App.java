import java.awt.*;

import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame main = new JFrame();
                main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                main.setSize(1280, 720);

                main.setResizable(false);
                main.setTitle("Final Project");
                HomePage homePanel = new HomePage();
                ModePage modePanel = new ModePage();
                LeaderboardPage leaderboardPanel = new LeaderboardPage();
                Mode1 mode1 = new Mode1();
                Mode2 mode2 = new Mode2();
                Mode3 mode3 = new Mode3();
                
                main.getContentPane().setLayout(new CardLayout());
                main.getContentPane().add(homePanel, "1");
                main.getContentPane().add(modePanel, "2");
                main.getContentPane().add(leaderboardPanel, "leaderboard");
                main.getContentPane().add(mode1, "mode1");
                main.getContentPane().add(mode2, "mode2");
                main.getContentPane().add(mode3, "mode3");
                
                main.pack();
                main.setLocationRelativeTo(null);
                main.setVisible(true);
            }
        });
    }
}
