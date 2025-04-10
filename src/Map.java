import javax.swing.*;
import java.awt.*;
public class Map extends JFrame {
     private int[][] board;
     public JLabel[][] panelBoard;
     private ImageIcon wall, floor, food, redGhost, cyanGhost, pinkGhost,orangeGhost, pacManRight, pacManUp, pacManDown,
             pacManLeft, pacManClosedRight, pacmanHalfOpenRight, pacManHalfOpenUp, pacManClosedUp, pacManHalfOpenDown,
             pacManClosedDown, pacManHalfOpenLeft, pacManClosedLeft, superFood, extraHeart, extraHearts2, slowDown,
             speedUp;
     private int scaleDiv;
     private JLabel winTxt;
    public Map(int n){
        this.board = switch (n){
            case 1 -> new int[][]{
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 4, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}

            };
            case 2 -> new int[][]{
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1},
                    {1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1},
                    {1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}

            };
            case 3 -> new int[][]{
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}

            };
            case 4 -> new int[][]{
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 4, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1},
                    {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                    {1, 6, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 5, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}

            };
            default -> new int[][]{ //20
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
                        {1, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 1,},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                        {1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1,},
                        {1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1,},
                        {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                        {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                        {1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1,},
                        {1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1,},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                        {1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1,},
                        {1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1,},
                        {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                        {1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                        {1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1,},
                        {1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1,},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                        {1, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 1,},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,}

                };


        };
        this.scaleDiv = switch (n){
            case 1 -> 12;
            case 2 -> 24;
            case 3 -> 30;
            case 4 -> 16;
            default -> 20;
        };

        this.panelBoard = new JLabel[this.board.length][this.board[0].length];
        this.floor = new ImageIcon(new ImageIcon("new_pngs\\floor.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.wall = new ImageIcon(new ImageIcon("new_pngs\\wall.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.food = new ImageIcon(new ImageIcon("new_pngs\\floorWithFood.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.redGhost = new ImageIcon(new ImageIcon("new_pngs\\redGhost.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.cyanGhost = new ImageIcon(new ImageIcon("new_pngs\\cyanGhost.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.pinkGhost = new ImageIcon(new ImageIcon("new_pngs\\pinkGhost.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.orangeGhost = new ImageIcon(new ImageIcon("new_pngs\\orangeGhost.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.pacManRight = new ImageIcon(new ImageIcon("new_pngs\\pacmanOpenFull.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.pacManLeft = new ImageIcon(new ImageIcon("new_pngs\\pacmanOpenFullLeft.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.pacManUp = new ImageIcon(new ImageIcon("new_pngs\\pacmanOpenFullUp.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.pacManDown = new ImageIcon(new ImageIcon("new_pngs\\pacmanOpenFullDown.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.pacmanHalfOpenRight = new ImageIcon(new ImageIcon("new_pngs\\pacmanHalfwayRight.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.pacManClosedRight = new ImageIcon(new ImageIcon("new_pngs\\pacmanClosedRight.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.pacManClosedLeft = new ImageIcon(new ImageIcon("new_pngs\\pacmanClosedLeft.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.pacManClosedUp = new ImageIcon(new ImageIcon("new_pngs\\pacmanClosedUp.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.pacManClosedDown = new ImageIcon(new ImageIcon("new_pngs\\pacmanClosedDown.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.pacManHalfOpenLeft = new ImageIcon(new ImageIcon("new_pngs\\pacmanHalfwayLeft.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.pacManHalfOpenUp = new ImageIcon(new ImageIcon("new_pngs\\pacmanHalfwayUp.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.pacManHalfOpenDown = new ImageIcon(new ImageIcon("new_pngs\\pacmanHalfwayDown.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.superFood = new ImageIcon(new ImageIcon("new_pngs\\superFood.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.extraHeart = new ImageIcon(new ImageIcon("new_pngs\\extraHeart.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.extraHearts2 = new ImageIcon(new ImageIcon("new_pngs\\extraHeart2.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.speedUp = new ImageIcon(new ImageIcon("new_pngs\\speedUp.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));
        this.slowDown = new ImageIcon(new ImageIcon("new_pngs\\slowDown.png").getImage().getScaledInstance(600/scaleDiv,600/scaleDiv,Image.SCALE_SMOOTH));

        this.winTxt = new JLabel();
    }
    public boolean checkForWin(Points points, Timer timer){
        boolean win = true;
        for(int i = 0;i<this.panelBoard.length;i++){
            for(int j = 0;j<this.panelBoard[i].length;j++){
                if(this.panelBoard[i][j].getIcon().equals(this.food)) {
                    win = false;
                    break;
                }
            }
        }
        if(win) {
            this.winTxt.setText("Wygrana!! Ilosc pkt:  " + points.getPoints() + "  Czas: " + timer.formattedTime());
            this.winTxt.repaint();
            return true;
        }
        return false;
    }

    public void createMap(JPanel grid, PacMan pacMan, Ghost redGhost, Ghost pinkGhost, Ghost orangeGhost, Ghost cyanGhost){
        for(int i = 0; i < this.board.length; i++){
            for(int j = 0; j < this.board[i].length;j++){
                this.panelBoard[i][j] = new JLabel();
                this.panelBoard[i][j].setOpaque(true);
                switch (this.board[i][j]){
                    case 1 -> {
                        this.panelBoard[i][j].setBackground(Color.BLACK);
                        this.panelBoard[i][j].setIcon(wall);
                    }
                    case 3 -> {
                        pacMan.setX(j);
                        pacMan.setY(i);
                        this.panelBoard[i][j].setBackground(new Color(112,146,190));
                        this.panelBoard[i][j].setIcon(this.pacManRight);
                    }
                    case 4 -> {
                        redGhost.setX(j);
                        redGhost.setY(i);
                        this.panelBoard[i][j].setBackground(new Color(112,146,190));
                        this.panelBoard[i][j].setIcon(this.redGhost);
                    }
                    case 5 -> {
                        pinkGhost.setX(j);
                        pinkGhost.setY(i);
                        this.panelBoard[i][j].setBackground(new Color(112,146,190));
                        this.panelBoard[i][j].setIcon(this.pinkGhost);
                    }
                    case 6 -> {
                        orangeGhost.setX(j);
                        orangeGhost.setY(i);
                        this.panelBoard[i][j].setBackground(new Color(112,146,190));
                        this.panelBoard[i][j].setIcon(this.orangeGhost);
                    }
                    case 7 -> {
                        cyanGhost.setX(j);
                        cyanGhost.setY(i);
                        this.panelBoard[i][j].setBackground(new Color(112,146,190));
                        this.panelBoard[i][j].setIcon(this.cyanGhost);
                    }
                    default -> { //Floor with food
                        this.panelBoard[i][j].setBackground(new Color(112,146,190));
                        this.panelBoard[i][j].setIcon(food);
                    }
                }
                grid.add(this.panelBoard[i][j]);
            }
        }
    }

    public ImageIcon getFood() {
        return food;
    }
    public ImageIcon getFloor() {
        return floor;
    }
    public ImageIcon getWall() {
        return wall;
    }
    public int getBoardLength(){
        return board.length;
    }
    public int getBoardWidth(){
        return board[0].length;
    }
    public ImageIcon getRedGhost() {
        return redGhost;
    }
    public ImageIcon getCyanGhost() {
        return cyanGhost;
    }
    public ImageIcon getPinkGhost() {
        return pinkGhost;
    }
    public ImageIcon getOrangeGhost() {
        return orangeGhost;
    }
    public ImageIcon getPacManRight() {
        return pacManRight;
    }
    public ImageIcon getPacManUp() {
        return pacManUp;
    }
    public ImageIcon getPacManDown() {
        return pacManDown;
    }
    public ImageIcon getPacManLeft() {
        return pacManLeft;
    }
    public ImageIcon getPacManClosedRight() {
        return pacManClosedRight;
    }
    public ImageIcon getPacmanHalfOpenRight() {
        return pacmanHalfOpenRight;
    }

    public ImageIcon getPacManHalfOpenUp() {
        return pacManHalfOpenUp;
    }

    public ImageIcon getPacManClosedUp() {
        return pacManClosedUp;
    }

    public ImageIcon getPacManHalfOpenDown() {
        return pacManHalfOpenDown;
    }

    public ImageIcon getPacManClosedDown() {
        return pacManClosedDown;
    }

    public ImageIcon getPacManHalfOpenLeft() {
        return pacManHalfOpenLeft;
    }

    public ImageIcon getPacManClosedLeft() {
        return pacManClosedLeft;
    }

    public ImageIcon getSuperFood() {
        return superFood;
    }

    public ImageIcon getExtraHeart() {
        return extraHeart;
    }
    public ImageIcon getSlowDown() {
        return slowDown;
    }

    public ImageIcon getSpeedUp() {
        return speedUp;
    }

    public JLabel getWinTxt() {
        return winTxt;
    }
}
