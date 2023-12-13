import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class HomePage extends JPanel {

    private JButton playButton;
    private JButton optionButton;
    private JButton quitButton;
    private int width = 400;
    private int height = 80;

    public HomePage() {
        initComponents();
    }

    private void initComponents() {
        // setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
        setPreferredSize(new Dimension(1280, 720));

        Dimension sizing = new Dimension(width, height);
        
// Title and subtitle
        JLabel title = new JLabel("Game Title");
        JLabel subTitle = new JLabel("Subtitle game hereeee!");

        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(JLabel.CENTER);
        subTitle.setHorizontalTextPosition(JLabel.CENTER);
        subTitle.setVerticalTextPosition(JLabel.CENTER);

        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        subTitle.setHorizontalAlignment(JLabel.CENTER);
        subTitle.setVerticalAlignment(JLabel.CENTER);

        title.setFont(new Font("Poppins", Font.BOLD, 40));
        subTitle.setFont(new Font("Poppins", Font.BOLD, 30));

        title.setPreferredSize(sizing);
        subTitle.setPreferredSize(sizing);
    
// Title and subtitle

// Button Components
        playButton = new JButton("Play");
        optionButton = new JButton("Option");
        quitButton = new JButton("Quit");
        
        playButton.setPreferredSize(sizing);
        optionButton.setPreferredSize(sizing);
        quitButton.setPreferredSize(sizing);

        playButton.setFont(new Font("Poppins", Font.BOLD, 20));
        optionButton.setFont(new Font("Poppins", Font.BOLD, 20));
        quitButton.setFont(new Font("Poppins", Font.BOLD, 20));
// Button Components

// title panel 
        JPanel gameTextPanel = new JPanel();
        gameTextPanel.setLayout(new GridLayout(2, 1, 0, 10));
        gameTextPanel.add(title);
        gameTextPanel.add(subTitle);

// title panel 

// button panel
        // margin top
        JPanel marginTopPanel = new JPanel();
        marginTopPanel.setPreferredSize(new Dimension(0, 30));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 40, 10));
        buttonPanel.setBorder(new EmptyBorder(0, 60, 0, 60));
        buttonPanel.add(marginTopPanel);
        buttonPanel.add(playButton);
        buttonPanel.add(optionButton);
        buttonPanel.add(quitButton);

        JPanel mainButtonPanel = new JPanel();
        mainButtonPanel.setLayout(new BorderLayout());

        mainButtonPanel.add(marginTopPanel, BorderLayout.NORTH);
        mainButtonPanel.add(buttonPanel, BorderLayout.SOUTH);
// button panel

// panel container
        JPanel panelContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 40));
        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));
        panelContainer.setBorder(new EmptyBorder(50, 50, 50, 50));
        panelContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelContainer.setAlignmentY(Component.CENTER_ALIGNMENT);
        panelContainer.add(gameTextPanel);
        panelContainer.add (mainButtonPanel);

        add(panelContainer);
        setAlignmentY(Component.CENTER_ALIGNMENT);


        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "2");
            }
        });

        optionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Options button clicked");
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}


