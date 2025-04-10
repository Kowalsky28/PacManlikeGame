import javax.swing.*;
import java.awt.*;

public class MenuWindowFrame extends JFrame{
    public MenuWindowFrame(){
        JPanel startBPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(event -> {
            this.setVisible(false);
            SwingUtilities.invokeLater(()-> new MapSelector());
        });
        startBPanel.add(startButton);

        JPanel highScoreBPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton highScoreButton = new JButton("High Scores");
        highScoreBPanel.add(highScoreButton);

        JPanel exitBPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(event -> {System.exit(0);});
        exitBPanel.add(exitButton);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridBagLayout());
        buttonsPanel.add(highScoreBPanel);
        buttonsPanel.add(startBPanel);
        buttonsPanel.add(exitBPanel);

        add(buttonsPanel);
        setSize(new Dimension(400, 200));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("PacMan - Menu");
        setResizable(true);
        setVisible(true);
    }
}
