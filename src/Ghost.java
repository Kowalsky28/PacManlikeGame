import javax.swing.*;
import java.awt.*;

public abstract class Ghost extends Character{

    private Color color;
    private int speed;
    private int los;
    public Ghost(int x, int y, ImageIcon icon, Color color){
        super(x,y,icon);
        this.color = color;
        this.los = 1;
        this.speed = 350;

    }
    public synchronized void checkCollision(Map map, PacMan pacMan){
        if ((map.panelBoard[this.getY()][this.getX()].equals(map.panelBoard[pacMan.getY()][pacMan.getX()]))) {
            pacMan.setLives(pacMan.getLives()-1);
            pacMan.getLivesLabel().setText(Integer.toString(pacMan.getLives()));
            pacMan.getLivesLabel().repaint();
            map.panelBoard[pacMan.getY()][pacMan.getX()].setIcon(map.getFloor());
            map.panelBoard[pacMan.getY()][pacMan.getX()].repaint();
            pacMan.setY(1);
            pacMan.setX(1);
            map.panelBoard[pacMan.getY()][pacMan.getX()].setIcon(pacMan.getIcon());
            map.panelBoard[pacMan.getY()][pacMan.getX()].repaint();
        }
    }
    public synchronized void ghostMove(Map map, PacMan pacMan){
        this.los = (int)(Math.random()*4+1);
        switch (los){
            case 1 -> { //left
                if(!(map.panelBoard[this.getY()][this.getX()-1].getIcon().equals(map.getWall()))) {
                    Icon tmp = map.panelBoard[this.getY()][this.getX()-1].getIcon();
                    this.setX(this.getX() - 1);
                    map.panelBoard[this.getY()][this.getX()].setIcon(this.getIcon());
                    map.panelBoard[this.getY()][this.getX()].repaint();
                    if(tmp.equals(map.getFood()))
                        map.panelBoard[this.getY()][this.getX() + 1].setIcon(map.getFood());
                    else if(tmp.equals(map.getExtraHeart()))
                        map.panelBoard[this.getY()][this.getX() + 1].setIcon(map.getExtraHeart());
                    else if(tmp.equals(map.getSlowDown()))
                        map.panelBoard[this.getY()][this.getX() + 1].setIcon(map.getSlowDown());
                    else if(tmp.equals(map.getSpeedUp()))
                        map.panelBoard[this.getY()][this.getX() + 1].setIcon(map.getSpeedUp());
                    else if(tmp.equals(map.getSuperFood()))
                        map.panelBoard[this.getY()][this.getX() + 1].setIcon(map.getSuperFood());
                    else  map.panelBoard[this.getY()][this.getX() + 1].setIcon(map.getFloor());
                    map.panelBoard[this.getY()][this.getX() + 1].repaint();
                }
            }
            case 2 -> { //right
                if(!(map.panelBoard[this.getY()][this.getX()+1].getIcon().equals(map.getWall()))) {
                    Icon tmp = map.panelBoard[this.getY()][this.getX()+1].getIcon();
                    this.setX(this.getX() + 1);
                    map.panelBoard[this.getY()][this.getX()].setIcon(this.getIcon());
                    map.panelBoard[this.getY()][this.getX()].repaint();
                    if(tmp.equals(map.getFood()))
                        map.panelBoard[this.getY()][this.getX() - 1].setIcon(map.getFood());
                    else if(tmp.equals(map.getExtraHeart()))
                        map.panelBoard[this.getY()][this.getX() - 1].setIcon(map.getExtraHeart());
                    else if(tmp.equals(map.getSlowDown()))
                        map.panelBoard[this.getY()][this.getX() - 1].setIcon(map.getSlowDown());
                    else if(tmp.equals(map.getSpeedUp()))
                        map.panelBoard[this.getY()][this.getX() - 1].setIcon(map.getSpeedUp());
                    else if(tmp.equals(map.getSuperFood()))
                        map.panelBoard[this.getY()][this.getX() - 1].setIcon(map.getSuperFood());
                    else  map.panelBoard[this.getY()][this.getX() - 1].setIcon(map.getFloor());
                    map.panelBoard[this.getY()][this.getX() - 1].repaint();
                }
            }
            case 3 -> { //up
                if(!(map.panelBoard[this.getY()-1][this.getX()].getIcon().equals(map.getWall())) &&
                        !(map.panelBoard[this.getY()-1][this.getX()].equals(map.panelBoard[1][1]))) {
                    Icon tmp = map.panelBoard[this.getY()-1][this.getX()].getIcon();
                    this.setY(this.getY() - 1);
                    map.panelBoard[this.getY()][this.getX()].setIcon(this.getIcon());
                    map.panelBoard[this.getY()][this.getX()].repaint();
                    if(tmp.equals(map.getFood()))
                        map.panelBoard[this.getY()+1][this.getX()].setIcon(map.getFood());
                    else if(tmp.equals(map.getExtraHeart()))
                        map.panelBoard[this.getY()+1][this.getX()].setIcon(map.getExtraHeart());
                    else if(tmp.equals(map.getSlowDown()))
                        map.panelBoard[this.getY()+1][this.getX()].setIcon(map.getSlowDown());
                    else if(tmp.equals(map.getSpeedUp()))
                        map.panelBoard[this.getY()+1][this.getX()].setIcon(map.getSpeedUp());
                    else if(tmp.equals(map.getSuperFood()))
                        map.panelBoard[this.getY()+1][this.getX()].setIcon(map.getSuperFood());
                    else  map.panelBoard[this.getY()+1][this.getX()].setIcon(map.getFloor());
                    map.panelBoard[this.getY()+1][this.getX()].repaint();
                }

            }
            case 4 -> { //down
                if(!(map.panelBoard[this.getY()+1][this.getX()].getIcon().equals(map.getWall()))) {
                    Icon tmp = map.panelBoard[this.getY()+1][this.getX()].getIcon();
                    this.setY(this.getY() + 1);
                    map.panelBoard[this.getY()][this.getX()].setIcon(this.getIcon());
                    map.panelBoard[this.getY()][this.getX()].repaint();
                    if(tmp.equals(map.getFood()))
                        map.panelBoard[this.getY()-1][this.getX()].setIcon(map.getFood());
                    else if(tmp.equals(map.getExtraHeart()))
                        map.panelBoard[this.getY()-1][this.getX()].setIcon(map.getExtraHeart());
                    else if(tmp.equals(map.getSlowDown()))
                        map.panelBoard[this.getY()-1][this.getX()].setIcon(map.getSlowDown());
                    else if(tmp.equals(map.getSpeedUp()))
                        map.panelBoard[this.getY()-1][this.getX()].setIcon(map.getSpeedUp());
                    else if(tmp.equals(map.getSuperFood()))
                        map.panelBoard[this.getY()-1][this.getX()].setIcon(map.getSuperFood());
                    else  map.panelBoard[this.getY()-1][this.getX()].setIcon(map.getFloor());
                    map.panelBoard[this.getY() - 1][this.getX()].repaint();
                }


            }
        }
        checkCollision(map, pacMan);
    }

    public void createPowerUp(Map map, ImageIcon imageIcon){
        switch (this.getLos()) {
            case 1 -> { //left
                if(this.getY() != 0 && this.getY() != map.panelBoard.length-1 && this.getX()+1 != 0 && this.getX()+1 != map.panelBoard[0].length)
                    map.panelBoard[this.getY()][this.getX()+1].setIcon(imageIcon);
                map.panelBoard[this.getY()][this.getX()+1].repaint();
            }
            case 2 -> { //right
                if(this.getY() != 0 && this.getY() != map.panelBoard.length-1 && this.getX()-1 != 0 && this.getX()-1 != map.panelBoard[0].length)
                    map.panelBoard[this.getY()][this.getX()-1].setIcon(imageIcon);
                map.panelBoard[this.getY()][this.getX()-1].repaint();
            }
            case 3 -> { //up
                if(this.getY()+1 != 0 && this.getY()+1 != map.panelBoard.length-1 && this.getX() != 0 && this.getX() != map.panelBoard[0].length)
                    map.panelBoard[this.getY()+1][this.getX()].setIcon(imageIcon);
                map.panelBoard[this.getY()+1][this.getX()].repaint();
            }
            case 4 -> { //down
                if(this.getY()-1 != 0 && this.getY()-1 != map.panelBoard.length-1 && this.getX() != 0 && this.getX() != map.panelBoard[0].length)
                    map.panelBoard[this.getY()-1][this.getX()].setIcon(imageIcon);
                map.panelBoard[this.getY()-1][this.getX()].repaint();
            }
        }
    }
    public int getLos() {
        return los;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
