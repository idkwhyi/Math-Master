import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class ModePage extends JPanel{


    ModePage(){
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setPreferredSize(new Dimension(1280, 720));
        
        JPanel centerPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        centerPanel.setBounds(280, 160, 720, 400);

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(200, 80));
        backButton.setBounds(10, 10, 150, 70);

        JButton btn1 = new JButton("Mode 1");
        JButton btn2 = new JButton("Mode 2");
        JButton btn3 = new JButton("Mode 3");

        centerPanel.add(btn1);
        centerPanel.add(btn2);
        centerPanel.add(btn3);

        add(backButton);
        add(centerPanel);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "1");
            }
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "mode1");
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "mode2");
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "mode3");
            }
        });
    }

}
