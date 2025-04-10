import javax.swing.*;
import java.awt.*;

public class RedGhost extends Ghost{

    private Thread slowDownThread;
    //nr 4
    public RedGhost(int x, int y, ImageIcon icon){
        super(x,y,icon, Color.RED);
        this.slowDownThread = new Thread(()->{
            this.setSpeed(650);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.setSpeed(350);
        });
    }
    public Thread getSlowDownThread() {
        return slowDownThread;
    }
}
