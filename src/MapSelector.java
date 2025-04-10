import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapSelector extends JFrame implements ActionListener {
    JComboBox boardSizeButton;
    private int mapSelector;
    private int[] intsBoard = {1,4,5,2,3};
    public MapSelector(){
        String[] jCBNames = {"12x12","16x16","20x20","24x24","30x30"};
        this.boardSizeButton = new JComboBox(jCBNames);
        boardSizeButton.addActionListener(this);
        add(boardSizeButton);
        setSize(new Dimension(200, 100));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("PacMan - BoardSize");
        setResizable(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mapSelector = intsBoard[boardSizeButton.getSelectedIndex()];
        SwingUtilities.invokeLater(()-> new PacManWindowFrame(mapSelector));
        this.setVisible(false);
    }
}
