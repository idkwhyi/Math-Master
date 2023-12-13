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
                main.setTitle("Final Project");
                HomePage homePanel = new HomePage();
                ModePage modePanel = new ModePage();
                
                main.getContentPane().setLayout(new CardLayout());
                main.getContentPane().add(homePanel, "1");
                main.getContentPane().add(modePanel, "2");
                
                main.pack();
                main.setLocationRelativeTo(null);
                main.setVisible(true);
            }
            
        });
    }
}
