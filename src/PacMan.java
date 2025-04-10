import javax.swing.*;
import java.awt.*;

public class PacMan extends Character {
    private int lives;
    private JLabel livesLabel;
    private Points points;
    private int speed;
    private int counter;
    private Thread speedUpThread;

    public PacMan(int x, int y, ImageIcon icon){
        super(x,y,icon);
        this.lives = 3;
        livesLabel = new JLabel();
        ImageIcon livesHeart = new ImageIcon(new ImageIcon("new_pngs\\heart.png").getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));
        livesLabel.setIcon(livesHeart);
        livesLabel.setOpaque(true);
        livesLabel.setText(Integer.toString(this.getLives()));
        livesLabel.setHorizontalTextPosition(JLabel.CENTER);
        this.speed = 400;
        this.points = new Points();
        this.counter = 0;
        this.speedUpThread = new Thread(()->{
            this.setSpeed(200);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.setSpeed(400);
        });
    }
    public void increaseSpeed(){
        if(this.speedUpThread.isInterrupted())
            this.speedUpThread.start();
    }
    public synchronized void pacManMove(char direction, Map map, RedGhost redGhost){

        switch (direction){
            case 'l' -> {
                if(!(map.panelBoard[this.getY()][this.getX()-1].getIcon().equals(map.getWall()))) {
                    if((map.panelBoard[this.getY()][this.getX()-1].getIcon().equals(map.getFood())))
                        points.increasePoints();
                    if((map.panelBoard[this.getY()][this.getX()-1].getIcon().equals(map.getSuperFood())))
                        points.superIncrPoints();
                    if((map.panelBoard[this.getY()][this.getX()-1].getIcon().equals(map.getExtraHeart()))){
                        this.setLives(this.getLives()+1);
                        this.getLivesLabel().setText(Integer.toString(this.getLives()));
                        this.getLivesLabel().repaint();
                    }
                    if((map.panelBoard[this.getY()][this.getX()-1].getIcon().equals(map.getSpeedUp())))
                        this.increaseSpeed();
                    if((map.panelBoard[this.getY()][this.getX()-1].getIcon().equals(map.getSlowDown())))
                        if(!redGhost.getSlowDownThread().isAlive())
                            redGhost.getSlowDownThread().start();

                    this.setX(this.getX() - 1);
                    map.panelBoard[this.getY()][this.getX()].setIcon(map.getPacManLeft());
                    map.panelBoard[this.getY()][this.getX()].repaint();
                    map.panelBoard[this.getY()][this.getX() + 1].setIcon(map.getFloor());
                    map.panelBoard[this.getY()][this.getX() + 1].repaint();
                }


            }
            case 'r' -> {
                if(!(map.panelBoard[this.getY()][this.getX()+1].getIcon().equals(map.getWall()))) {
                    if((map.panelBoard[this.getY()][this.getX()+1].getIcon().equals(map.getFood())))
                        points.increasePoints();
                    if((map.panelBoard[this.getY()][this.getX()+1].getIcon().equals(map.getSuperFood())))
                        points.superIncrPoints();
                    if((map.panelBoard[this.getY()][this.getX()+1].getIcon().equals(map.getExtraHeart()))){
                        this.setLives(this.getLives()+1);
                        this.getLivesLabel().setText(Integer.toString(this.getLives()));
                        this.getLivesLabel().repaint();
                    }
                    if((map.panelBoard[this.getY()][this.getX()+1].getIcon().equals(map.getSpeedUp())))
                        this.increaseSpeed();
                    if((map.panelBoard[this.getY()][this.getX()+1].getIcon().equals(map.getSlowDown())))
                        if(!redGhost.getSlowDownThread().isAlive())
                            redGhost.getSlowDownThread().start();
                    this.setX(this.getX() + 1);
                    map.panelBoard[this.getY()][this.getX()].setIcon(this.getIcon());
                    map.panelBoard[this.getY()][this.getX()].repaint();
                    map.panelBoard[this.getY()][this.getX() - 1].setIcon(map.getFloor());
                    map.panelBoard[this.getY()][this.getX() - 1].repaint();
                }
            }
            case 'u' -> {
                if(!(map.panelBoard[this.getY()-1][this.getX()].getIcon().equals(map.getWall()))) {
                    if((map.panelBoard[this.getY()-1][this.getX()].getIcon().equals(map.getFood())))
                        points.increasePoints();
                    if((map.panelBoard[this.getY()-1][this.getX()].getIcon().equals(map.getSuperFood())))
                        points.superIncrPoints();
                    if((map.panelBoard[this.getY()-1][this.getX()].getIcon().equals(map.getExtraHeart()))){
                        this.setLives(this.getLives()+1);
                        this.getLivesLabel().setText(Integer.toString(this.getLives()));
                        this.getLivesLabel().repaint();
                    }
                    if((map.panelBoard[this.getY()-1][this.getX()].getIcon().equals(map.getSpeedUp())))
                        this.increaseSpeed();
                    if((map.panelBoard[this.getY()-1][this.getX()].getIcon().equals(map.getSlowDown())))
                        if(!redGhost.getSlowDownThread().isAlive())
                            redGhost.getSlowDownThread().start();
                    this.setY(this.getY() - 1);
                    map.panelBoard[this.getY()][this.getX()].setIcon(map.getPacManUp());
                    map.panelBoard[this.getY()][this.getX()].repaint();
                    map.panelBoard[this.getY() + 1][this.getX()].setIcon(map.getFloor());
                    map.panelBoard[this.getY() + 1][this.getX()].repaint();
                }

            }
            case 'd' -> {
                if(!(map.panelBoard[this.getY()+1][this.getX()].getIcon().equals(map.getWall()))) {
                    if((map.panelBoard[this.getY()+1][this.getX()].getIcon().equals(map.getFood())))
                        points.increasePoints();
                    if((map.panelBoard[this.getY()+1][this.getX()].getIcon().equals(map.getSuperFood())))
                        points.superIncrPoints();
                    if((map.panelBoard[this.getY()+1][this.getX()].getIcon().equals(map.getExtraHeart()))){
                        this.setLives(this.getLives()+1);
                        this.getLivesLabel().setText(Integer.toString(this.getLives()));
                        this.getLivesLabel().repaint();
                    }
                    if((map.panelBoard[this.getY()+1][this.getX()].getIcon().equals(map.getSpeedUp())))
                        this.increaseSpeed();
                    if((map.panelBoard[this.getY()+1][this.getX()].getIcon().equals(map.getSlowDown())))
                        if(!redGhost.getSlowDownThread().isAlive())
                            redGhost.getSlowDownThread().start();
                    this.setY(this.getY() + 1);
                    map.panelBoard[this.getY()][this.getX()].setIcon(map.getPacManDown());
                    map.panelBoard[this.getY()][this.getX()].repaint();
                    map.panelBoard[this.getY() - 1][this.getX()].setIcon(map.getFloor());
                    map.panelBoard[this.getY() - 1][this.getX()].repaint();
                }
            }
        }
    }
    public JLabel getLivesLabel() {
        return livesLabel;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public Points getPoints() {
        return points;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}


