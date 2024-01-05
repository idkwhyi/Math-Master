import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.util.List;

public class LeaderboardPage extends JPanel {

    Color backgroundColor = new Color(0x3887BE);

    LeaderboardManager leaderboardManager = new LeaderboardManager();

    List<Object[]> easyPlayerScoreData;
    List<Object[]> mediumPlayerScoreData;
    List<Object[]> hardPlayerScoreData;

    Style style = new Style();

    LeaderboardPage() {
        easyPlayerScoreData = leaderboardManager.getPlayerScoreData("ez");
        mediumPlayerScoreData = leaderboardManager.getPlayerScoreData("md");
        hardPlayerScoreData = leaderboardManager.getPlayerScoreData("hrd");
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1280, 720));
        setBackground(style.leaderboardBgColor);

        // styling
        int borderRadius = 10;
        Font titleFont = new Font(style.font_title, Font.BOLD, style.h1);
        Font labelFont = new Font(style.font_title, Font.BOLD, style.h3);
        Font leaderboardItemsFont = new Font(style.font_text, Font.PLAIN, style.text_font_big);
        Font btn_info = new Font(style.font_button, Font.BOLD, style.text_font_medium);

        JPanel gap = new JPanel();

        // margin
        JPanel marginLeft = new JPanel();
        marginLeft.setPreferredSize(new Dimension(20, 60));
        marginLeft.setBackground(style.leaderboardBgColor);
        JPanel marginRight = new JPanel();
        marginRight.setPreferredSize(new Dimension(20, 60));
        marginRight.setBackground(style.leaderboardBgColor);
        // margin

        // back button
        JPanel buttonContainer = new JPanel();
        buttonContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        buttonContainer.setPreferredSize(new Dimension(1280, 90));
        buttonContainer.setBackground(style.leaderboardBgColor);

        RoundedButton backButton = new RoundedButton("Back");
        backButton.setPreferredSize(new Dimension(100, 50));
        backButton.setFont(btn_info);
        backButton.setBackground(style.backButtonColor);
        backButton.setForeground(style.whiteColor);
        backButton.setBorder(new EmptyBorder(10, 20, 10, 20)); // Padding for text
        backButton.setCornerRadius(borderRadius);
        backButton.setBorderColor(Color.WHITE);
        backButton.setBorderThickness(2);

        JLabel title = new JLabel("Leaderboard");
        title.setPreferredSize(new Dimension(210, 50));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(titleFont);
        title.setBackground(style.leaderboardBgColor);
        title.setForeground(style.whiteColor);

        buttonContainer.add(marginLeft);
        buttonContainer.add(backButton);
        buttonContainer.add(title);
        // back button

        // main leaderboard
        // int totalMode = 4;
        int easyLength = easyPlayerScoreData.size() + 2;
        int mediumLength = mediumPlayerScoreData.size() + 1;
        int hardLength = hardPlayerScoreData.size() + 1;
        // int total = n * totalMode;
        // JPanel panel = new JPanel(new GridLayout(totalMode, 1)); // set the scroll
        // height
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(style.leaderboardBgColor);

        JPanel easyContainer = new JPanel(new BorderLayout());
        JPanel mediumContainer = new JPanel(new BorderLayout());
        JPanel hardContainer = new JPanel(new BorderLayout());

        easyContainer.setBackground(style.leaderboardBgColor);
        mediumContainer.setBackground(style.leaderboardBgColor);
        hardContainer.setBackground(style.leaderboardBgColor);

        JLabel easyLabel = new JLabel("Easy Mode");
        easyLabel.setFont(labelFont);
        easyLabel.setForeground(style.whiteColor);
        JLabel mediumLabel = new JLabel("Medium Mode");
        mediumLabel.setFont(labelFont);
        mediumLabel.setForeground(style.whiteColor);
        JLabel hardLabel = new JLabel("Hard Mode");
        hardLabel.setFont(labelFont);
        hardLabel.setForeground(style.whiteColor);

        JPanel easyLeaderboard = new JPanel(new GridLayout(easyLength, 1));
        JPanel mediumLeaderboard = new JPanel(new GridLayout(mediumLength, 1));
        JPanel hardLeaderboard = new JPanel(new GridLayout(hardLength, 1));

        easyLeaderboard.setBackground(style.leaderboardBgColor);
        mediumLeaderboard.setBackground(style.leaderboardBgColor);
        hardLeaderboard.setBackground(style.leaderboardBgColor);

        JPanel easyItems = new JPanel(new GridLayout(1, 3));
        JPanel mediumItems = new JPanel(new GridLayout(1, 3));
        JPanel hardItems = new JPanel(new GridLayout(1, 3));

        JLabel rank_text_easy = new JLabel("Rank");
        rank_text_easy.setFont(leaderboardItemsFont);
        rank_text_easy.setBackground(style.leaderboardBgColor);
        rank_text_easy.setForeground(style.whiteColor);
        JLabel username_text_easy = new JLabel("Username");
        username_text_easy.setFont(leaderboardItemsFont);
        username_text_easy.setBackground(style.leaderboardBgColor);
        username_text_easy.setForeground(style.whiteColor);
        JLabel score_text_easy = new JLabel("Score");
        score_text_easy.setFont(leaderboardItemsFont);
        score_text_easy.setBackground(style.leaderboardBgColor);
        score_text_easy.setForeground(style.whiteColor);

        JLabel rank_text_medium = new JLabel("Rank");
        rank_text_medium.setFont(leaderboardItemsFont);
        rank_text_medium.setBackground(style.leaderboardBgColor);
        rank_text_medium.setForeground(style.whiteColor);
        JLabel username_text_medium = new JLabel("Username");
        username_text_medium.setFont(leaderboardItemsFont);
        username_text_medium.setBackground(style.leaderboardBgColor);
        username_text_medium.setForeground(style.whiteColor);
        JLabel score_text_medium = new JLabel("Score");
        score_text_medium.setFont(leaderboardItemsFont);
        score_text_medium.setBackground(style.leaderboardBgColor);
        score_text_medium.setForeground(style.whiteColor);

        JLabel rank_text_hard = new JLabel("Rank");
        rank_text_hard.setFont(leaderboardItemsFont);
        rank_text_hard.setBackground(style.leaderboardBgColor);
        rank_text_hard.setForeground(style.whiteColor);
        JLabel username_text_hard = new JLabel("Username");
        username_text_hard.setFont(leaderboardItemsFont);
        username_text_hard.setBackground(style.leaderboardBgColor);
        username_text_hard.setForeground(style.whiteColor);
        JLabel score_text_hard = new JLabel("Score");
        score_text_hard.setFont(leaderboardItemsFont);
        score_text_hard.setBackground(style.leaderboardBgColor);
        score_text_hard.setForeground(style.whiteColor);

        easyItems.setBackground(style.leaderboardBgColor);
        mediumItems.setBackground(style.leaderboardBgColor);
        hardItems.setBackground(style.leaderboardBgColor);

        easyItems.add(rank_text_easy);
        easyItems.add(username_text_easy);
        easyItems.add(score_text_easy);

        mediumItems.add(rank_text_medium);
        mediumItems.add(username_text_medium);
        mediumItems.add(score_text_medium);

        hardItems.add(rank_text_hard);
        hardItems.add(username_text_hard);
        hardItems.add(score_text_hard);

        easyLeaderboard.add(easyItems);
        mediumLeaderboard.add(mediumItems);
        hardLeaderboard.add(hardItems);

        for (int i = 0; i < easyPlayerScoreData.size(); i++) {
            Object[] pair = easyPlayerScoreData.get(i);
            int playerId = (int) pair[0];
            int totalScore = (int) pair[1];

            JPanel entryPanel = new JPanel(new GridLayout(1, 3));
            entryPanel.setBackground(style.leaderboardBgColor);

            int easy_rank = i + 1;
            JLabel rankLabel = new JLabel(String.valueOf(easy_rank));
            JLabel nameLabel = new JLabel(leaderboardManager.getUsername(playerId));
            JLabel scoreLabel = new JLabel(String.valueOf(totalScore));

            rankLabel.setFont(leaderboardItemsFont);
            nameLabel.setFont(leaderboardItemsFont);
            scoreLabel.setFont(leaderboardItemsFont);

            rankLabel.setBackground(style.leaderboardBgColor);
            nameLabel.setBackground(style.leaderboardBgColor);
            scoreLabel.setBackground(style.leaderboardBgColor);
            
            if(i%2 == 0){
                rankLabel.setForeground(style.secondLeaderboard);
                nameLabel.setForeground(style.secondLeaderboard);
                scoreLabel.setForeground(style.secondLeaderboard);
            } else {
                rankLabel.setForeground(style.whiteColor);
                nameLabel.setForeground(style.whiteColor);
                scoreLabel.setForeground(style.whiteColor);
            }
            
            entryPanel.add(rankLabel);
            entryPanel.add(nameLabel);
            entryPanel.add(scoreLabel);

            easyLeaderboard.add(entryPanel);
        }

        for (int i = 0; i < mediumPlayerScoreData.size(); i++) {
            Object[] pair = mediumPlayerScoreData.get(i);
            int playerId = (int) pair[0];
            int totalScore = (int) pair[1];

            JPanel entryPanel = new JPanel(new GridLayout(1, 3));
            entryPanel.setBackground(style.leaderboardBgColor);

            int easy_rank = i + 1;
            JLabel rankLabel = new JLabel(String.valueOf(easy_rank));
            JLabel nameLabel = new JLabel(leaderboardManager.getUsername(playerId));
            JLabel scoreLabel = new JLabel(String.valueOf(totalScore));

            rankLabel.setFont(leaderboardItemsFont);
            nameLabel.setFont(leaderboardItemsFont);
            scoreLabel.setFont(leaderboardItemsFont);

            rankLabel.setBackground(style.leaderboardBgColor);
            nameLabel.setBackground(style.leaderboardBgColor);
            scoreLabel.setBackground(style.leaderboardBgColor);

            rankLabel.setForeground(style.whiteColor);
            nameLabel.setForeground(style.whiteColor);
            scoreLabel.setForeground(style.whiteColor);

            entryPanel.add(rankLabel);
            entryPanel.add(nameLabel);
            entryPanel.add(scoreLabel);

            mediumLeaderboard.add(entryPanel);
        }

        for (int i = 0; i < hardPlayerScoreData.size(); i++) {
            Object[] pair = hardPlayerScoreData.get(i);
            int playerId = (int) pair[0];
            int totalScore = (int) pair[1];

            JPanel entryPanel = new JPanel(new GridLayout(1, 3));
            entryPanel.setBackground(style.leaderboardBgColor);

            int easy_rank = i + 1;
            JLabel rankLabel = new JLabel(String.valueOf(easy_rank));
            JLabel nameLabel = new JLabel(leaderboardManager.getUsername(playerId));
            JLabel scoreLabel = new JLabel(String.valueOf(totalScore));

            rankLabel.setFont(leaderboardItemsFont);
            nameLabel.setFont(leaderboardItemsFont);
            scoreLabel.setFont(leaderboardItemsFont);

            rankLabel.setBackground(style.leaderboardBgColor);
            nameLabel.setBackground(style.leaderboardBgColor);
            scoreLabel.setBackground(style.leaderboardBgColor);

            rankLabel.setForeground(style.whiteColor);
            nameLabel.setForeground(style.whiteColor);
            scoreLabel.setForeground(style.whiteColor);

            entryPanel.add(rankLabel);
            entryPanel.add(nameLabel);
            entryPanel.add(scoreLabel);

            hardLeaderboard.add(entryPanel);
        }

        easyContainer.add(easyLabel, BorderLayout.NORTH);
        easyContainer.add(gap);
        easyContainer.add(easyLeaderboard, BorderLayout.SOUTH);
        easyContainer.setBackground(style.leaderboardBgColor);

        mediumContainer.add(mediumLabel, BorderLayout.NORTH);
        mediumContainer.add(gap);
        mediumContainer.add(mediumLeaderboard, BorderLayout.CENTER);
        mediumContainer.setBackground(style.leaderboardBgColor);

        hardContainer.add(hardLabel, BorderLayout.NORTH);
        hardContainer.add(gap);
        hardContainer.add(hardLeaderboard, BorderLayout.CENTER);
        hardContainer.setBackground(style.leaderboardBgColor);

        easyContainer.setBorder(BorderFactory.createEmptyBorder(5, 0, 20, 5));
        mediumContainer.setBorder(BorderFactory.createEmptyBorder(5, 0, 20, 5));
        hardContainer.setBorder(BorderFactory.createEmptyBorder(5, 0, 20, 5));

        panel.add(easyContainer);
        panel.add(mediumContainer);
        panel.add(hardContainer);

        JScrollPane scrollPanel = new JScrollPane(panel);
        scrollPanel.setBackground(style.leaderboardBgColor);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setPreferredSize(new Dimension(900, 1000));

        scrollPanel.setBorder(null);

        // main leaderboard
        add(buttonContainer, BorderLayout.NORTH);
        add(marginLeft, BorderLayout.LINE_START);
        add(marginRight, BorderLayout.LINE_END);
        add(scrollPanel, BorderLayout.CENTER);
        // add(centerPanel, BorderLayout.CENTER);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "home");
            }
        });
    }
}