import javax.swing.*;
import java.awt.*;
public abstract class Character extends JFrame {

    private int x;
    private int y;
    private ImageIcon icon;
    public Character(int x, int y, ImageIcon icon){
        this.x = x;
        this.y = y;
        this.icon = icon;
    }
    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ImageIcon getIcon() {
        return icon;
    }



}
