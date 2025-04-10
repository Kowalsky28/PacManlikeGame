import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class PacManWindowFrame extends JFrame implements KeyListener{
    private Map map;
    private PacMan pacMan;
    private RedGhost redGhost;
    private PinkGhost pinkGhost;
    private OrangeGhost orangeGhost;
    private CyanGhost cyanGhost;
    private JPanel grid;
    private Thread pacManMove, ghostsMove, pacManRefresh, clock, spawnPowerUp, checkForWinThread;
    private char pacManDir;
    private Timer timer;

    public PacManWindowFrame(int n){
        this.map = new Map(n);
        switch (n){
            case 1 -> {
                this.redGhost = new RedGhost(0,0,this.map.getRedGhost());
                this.pinkGhost = new PinkGhost(0,0,this.map.getPinkGhost());
            }
            case 4 ->{
                this.redGhost = new RedGhost(0,0,this.map.getRedGhost());
                this.pinkGhost = new PinkGhost(0,0,this.map.getPinkGhost());
                this.orangeGhost = new OrangeGhost(0,0, this.map.getOrangeGhost());
            }
            default -> {
                this.redGhost = new RedGhost(0,0,this.map.getRedGhost());
                this.pinkGhost = new PinkGhost(0,0,this.map.getPinkGhost());
                this.orangeGhost = new OrangeGhost(0,0,this.map.getOrangeGhost());
                this.cyanGhost = new CyanGhost(0,0,this.map.getCyanGhost());
            }
        }
        this.pacMan = new PacMan(0,0, this.map.getPacManRight());
        this.grid = new JPanel(new GridLayout(map.getBoardLength(),map.getBoardWidth()));
        map.createMap(grid,pacMan, redGhost, pinkGhost, orangeGhost, cyanGhost);
        addKeyListener(this);

        this.pacManMove = new Thread(()->{
            while (true) {
                pacMan.getPoints().refreshPoints();
                switch (pacManDir) {
                    case 'u' -> pacMan.pacManMove('u', map,redGhost);
                    case 'd' -> pacMan.pacManMove('d', map,redGhost);
                    case 'l' -> pacMan.pacManMove('l', map,redGhost);
                    case 'r' -> pacMan.pacManMove('r', map,redGhost);
                }
                try {
                    Thread.sleep(pacMan.getSpeed());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        pacManMove.start();

        this.ghostsMove = new Thread(()->{
           while (true){
               switch (n){
                   case 1 -> {
                       redGhost.ghostMove(map,pacMan);
                       pinkGhost.ghostMove(map,pacMan);
                   }
                   case 4 ->{
                       redGhost.ghostMove(map,pacMan);
                       pinkGhost.ghostMove(map,pacMan);
                       orangeGhost.ghostMove(map,pacMan);
                   }
                   default -> {
                       redGhost.ghostMove(map,pacMan);
                       pinkGhost.ghostMove(map,pacMan);
                       orangeGhost.ghostMove(map,pacMan);
                       cyanGhost.ghostMove(map,pacMan);
                   }
               }
               try{
                   Thread.sleep(redGhost.getSpeed());
               }catch (InterruptedException e){
                   throw new RuntimeException(e);
               }
           }
        });
        ghostsMove.start();

        this.pacManRefresh = new Thread(()->{
            while (true){
                switch (pacManDir) {
                    case 'r' -> map.panelBoard[pacMan.getY()][pacMan.getX()].setIcon(map.getPacmanHalfOpenRight());
                    case 'l' -> map.panelBoard[pacMan.getY()][pacMan.getX()].setIcon(map.getPacManHalfOpenLeft());
                    case 'u' -> map.panelBoard[pacMan.getY()][pacMan.getX()].setIcon(map.getPacManHalfOpenUp());
                    case 'd' -> map.panelBoard[pacMan.getY()][pacMan.getX()].setIcon(map.getPacManHalfOpenDown());
                }
                map.panelBoard[pacMan.getY()][pacMan.getX()].repaint();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                switch (pacManDir) {
                    case 'r' -> map.panelBoard[pacMan.getY()][pacMan.getX()].setIcon(map.getPacManClosedRight());
                    case 'l' -> map.panelBoard[pacMan.getY()][pacMan.getX()].setIcon(map.getPacManClosedLeft());
                    case 'u' -> map.panelBoard[pacMan.getY()][pacMan.getX()].setIcon(map.getPacManClosedUp());
                    case 'd' -> map.panelBoard[pacMan.getY()][pacMan.getX()].setIcon(map.getPacManClosedDown());
                }
                map.panelBoard[pacMan.getY()][pacMan.getX()].repaint();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                switch (pacManDir) {
                    case 'r' -> map.panelBoard[pacMan.getY()][pacMan.getX()].setIcon(map.getPacManRight());
                    case 'l' -> map.panelBoard[pacMan.getY()][pacMan.getX()].setIcon(map.getPacManLeft());
                    case 'u' -> map.panelBoard[pacMan.getY()][pacMan.getX()].setIcon(map.getPacManUp());
                    case 'd' -> map.panelBoard[pacMan.getY()][pacMan.getX()].setIcon(map.getPacManDown());
                }
                map.panelBoard[pacMan.getY()][pacMan.getX()].repaint();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        pacManRefresh.start();

        this.spawnPowerUp = new Thread(()->{
            while (true) {
                if(Math.random() <= 0.25){
                    switch (n) {
                        case 1 -> {
                            redGhost.createPowerUp(map, map.getSpeedUp());
                            pinkGhost.createPowerUp(map, map.getSuperFood());
                        }
                        case 4 -> {
                            redGhost.createPowerUp(map, map.getSpeedUp());
                            pinkGhost.createPowerUp(map, map.getSuperFood());
                            orangeGhost.createPowerUp(map, map.getSlowDown());
                        }
                        default -> {
                            cyanGhost.createPowerUp(map, map.getExtraHeart());
                            redGhost.createPowerUp(map, map.getSpeedUp());
                            orangeGhost.createPowerUp(map, map.getSlowDown());
                            pinkGhost.createPowerUp(map, map.getSuperFood());
                        }
                    }
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        spawnPowerUp.start();

        this.timer = new Timer();
        this.clock = new Thread(()->{
            while(true){
                timer.countTime();
                timer.refreshClock();
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    throw new RuntimeException(e);
                }
            }
        });
        clock.start();

        this.checkForWinThread = new Thread(()->{
           while (true){
               if(map.checkForWin(pacMan.getPoints(),timer)) {
                   Thread.currentThread().interrupt();
                   break;
               }
           }
        });
        checkForWinThread.start();

        setLayout(new BorderLayout());
        JPanel game = new JPanel();
        game.setBackground(Color.darkGray);
        game.setSize(600,600);
        game.add(grid);

        JPanel pointsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel timeTxt = new JLabel("Time:");
        JLabel scoreTxt = new JLabel("Score: ");
        JLabel exitText = new JLabel("Press ESCAPE to exit");
        pointsPanel.add(scoreTxt);
        pointsPanel.add(pacMan.getPoints().getPointsLabel());
        JPanel livesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        livesPanel.add(pacMan.getLivesLabel());
        JPanel timerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        timerPanel.add(timeTxt);
        timerPanel.add(timer.getTimeLabel());
        JPanel infoBar = new JPanel();
        infoBar.setBackground(new Color(176,196,222));
        infoBar.setLayout(new GridBagLayout());
        infoBar.add(pointsPanel);
        infoBar.add(livesPanel);
        infoBar.add(timerPanel);

        JPanel exitPanel = new JPanel();
        exitPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        exitPanel.add(exitText);

        JPanel winPanel = new JPanel();
        winPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        winPanel.add(map.getWinTxt());

        JPanel downPanel = new JPanel(new GridLayout(3,1));
        downPanel.add(infoBar);
        downPanel.add(winPanel);
        downPanel.add(exitPanel);

        add(game, BorderLayout.NORTH);
        add(downPanel);

        setSize(new Dimension(601, 800));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("PacMan - Game");
        setResizable(true);
        setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_LEFT){
            if(!(map.panelBoard[pacMan.getY()][pacMan.getX()-1].getIcon().equals(map.getWall())))
                pacManDir = 'l';
        }
        if (e.getKeyCode()==KeyEvent.VK_RIGHT){
            if(!(map.panelBoard[pacMan.getY()][pacMan.getX()+1].getIcon().equals(map.getWall())))
                pacManDir = 'r';
        }
        if (e.getKeyCode()==KeyEvent.VK_UP){
            if(!(map.panelBoard[pacMan.getY()-1][pacMan.getX()].getIcon().equals(map.getWall())))
                pacManDir = 'u';
        }
        if (e.getKeyCode()==KeyEvent.VK_DOWN){
            if(!(map.panelBoard[pacMan.getY()+1][pacMan.getX()].getIcon().equals(map.getWall())))
                pacManDir = 'd';
        }
        if (e.getKeyCode()==KeyEvent.VK_ESCAPE){
            this.setVisible(false);
            SwingUtilities.invokeLater(()-> new MenuWindowFrame());
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
