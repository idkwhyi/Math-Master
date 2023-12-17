import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Mode2 extends JPanel{

    Mode2(){
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setPreferredSize(new Dimension(1280, 720));
        
        JPanel centerPanel = new JPanel(new GridLayout(4, 5, 10, 10));
        centerPanel.setBounds(280, 160, 720, 400);

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(200, 80));
        backButton.setBounds(10, 10, 150, 70);

        JLabel titleLabel = new JLabel("Mode 2", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setBounds(280, 120, 720, 40);

        JButton level = new JButton("Level");

        centerPanel.add(level);
        centerPanel.add(new JButton("level"));
        centerPanel.add(new JButton("level"));
        centerPanel.add(new JButton("level"));
        centerPanel.add(new JButton("level"));
        centerPanel.add(new JButton("level"));
        centerPanel.add(new JButton("level"));
        centerPanel.add(new JButton("level"));
        centerPanel.add(new JButton("level"));

        add(backButton);
        add(centerPanel);
        add(titleLabel);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "2");
            }
        });
        
    }
}