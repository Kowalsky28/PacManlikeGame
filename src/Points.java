import javax.swing.*;

public class Points {
    private int points;

    private JLabel pointsLabel;
    public Points(){
        this.points = 0;
        this.pointsLabel = new JLabel();
        pointsLabel.setOpaque(true);
        pointsLabel.setText(Integer.toString(this.points));
    }
    public void increasePoints(){
        points += 10;
    }
    public void superIncrPoints(){
        points += 100;
    }
    public synchronized void refreshPoints(){
        pointsLabel.setText(Integer.toString(this.points));
        pointsLabel.repaint();
    }
    public int getPoints() {
        return points;
    }
    public JLabel getPointsLabel() {
        return pointsLabel;
    }

}
