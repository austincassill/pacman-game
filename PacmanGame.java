package pacmangame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PacmanGame extends JPanel {

    BufferedImage barricade1;
    BufferedImage barricade2;
    BufferedImage barricade3;
    
    int timer = 0; 
    
    Pacman pacman = new Pacman(this);
    boolean dead = false;
    Villain villain = new Villain(this);
    Food food1 = new Food(this);
    boolean food1Eaten = false;
    Food food2 = new Food(this);
    boolean food2Eaten = false;
    Food food3 = new Food(this);
    boolean food3Eaten = false;
    Food food4 = new Food(this);
    boolean food4Eaten = false;
    Food food5 = new Food(this);
    boolean food5Eaten = false;
    Food food6 = new Food(this);
    boolean food6Eaten = false;
    Food food7 = new Food(this);
    boolean food7Eaten = false;
    Food food8 = new Food(this);
    boolean food8Eaten = false;
    Food food9 = new Food(this);
    boolean food9Eaten = false;
    Food food10 = new Food(this);
    boolean food10Eaten = false;
    

    public PacmanGame() {
        try {
           barricade1 = ImageIO.read(getClass().getResource("/pacmangame/barricade.png"));
           barricade2 = ImageIO.read(getClass().getResource("/pacmangame/barricade.png"));
           barricade3 = ImageIO.read(getClass().getResource("/pacmangame/barricade.png"));
        } catch (IOException e) {
        }
        
        
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                pacman.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                pacman.keyPressed(e);
            }
        });
        setFocusable(true);

    }

    private void move() {
        pacman.move();
        villain.move();
        int pacmanX = pacman.x + 25;
        int pacmanY = pacman.y + 25;
        int villainX = villain.x + 25;
        int villainY = villain.y + 25; 
        int food1X = food1.x + 5;
        int food1Y = food1.y + 5;
        int food2X = food2.x + 5;
        int food2Y = food2.y + 5;
        int food3X = food3.x + 5;
        int food3Y = food3.y + 5;
        int food4X = food4.x + 5;
        int food4Y = food4.y + 5;
        int food5X = food5.x + 5;
        int food5Y = food5.y + 5;
        int food6X = food6.x + 5;
        int food6Y = food6.y + 5;
        int food7X = food7.x + 5;
        int food7Y = food7.y + 5;
        int food8X = food8.x + 5;
        int food8Y = food8.y + 5;
        int food9X = food9.x + 5;
        int food9Y = food9.y + 5;
        int food10X = food10.x + 5;
        int food10Y = food10.y + 5;
        if ((pacmanX < villainX + 30) && (pacmanX > villainX - 30) && (pacmanY < villainY + 30) && (pacmanY > villainY - 30)) {
            dead = true;
        }
        if ((pacmanX < food1X + 15) && (pacmanX > food1X - 15) && (pacmanY < food1Y + 15) && (pacmanY > food1Y - 15)) {
            food1Eaten = true;
        }
        if ((pacmanX < food2X + 15) && (pacmanX > food2X - 15) && (pacmanY < food2Y + 15) && (pacmanY > food2Y - 15)) {
            food2Eaten = true;
        }
        if ((pacmanX < food3X + 15) && (pacmanX > food3X - 15) && (pacmanY < food3Y + 15) && (pacmanY > food3Y - 15)) {
            food3Eaten = true;
        }
        if ((pacmanX < food4X + 15) && (pacmanX > food4X - 15) && (pacmanY < food4Y + 15) && (pacmanY > food4Y - 15)) {
            food4Eaten = true;
        }
        if ((pacmanX < food5X + 15) && (pacmanX > food5X - 15) && (pacmanY < food5Y + 15) && (pacmanY > food5Y - 15)) {
            food5Eaten = true;
        }
        if ((pacmanX < food6X + 15) && (pacmanX > food6X - 15) && (pacmanY < food6Y + 15) && (pacmanY > food6Y - 15)) {
            food6Eaten = true;
        }
        if ((pacmanX < food7X + 15) && (pacmanX > food7X - 15) && (pacmanY < food7Y + 15) && (pacmanY > food7Y - 15)) {
            food7Eaten = true;
        }
        if ((pacmanX < food8X + 15) && (pacmanX > food8X - 15) && (pacmanY < food8Y + 15) && (pacmanY > food8Y - 15)) {
            food8Eaten = true;
        }
        if ((pacmanX < food9X + 15) && (pacmanX > food9X - 15) && (pacmanY < food9Y + 15) && (pacmanY > food9Y - 15)) {
            food9Eaten = true;
        }
        if ((pacmanX < food10X + 15) && (pacmanX > food10X - 15) && (pacmanY < food10Y + 15) && (pacmanY > food10Y - 15)) {
            food10Eaten = true;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawImage(barricade1, 100, 100, 60, 500, null);
        g.drawImage(barricade2, 740, 100, 60, 500, null);
        g.drawImage(barricade3, 325, 220, 250, 250, null);
        if (food1Eaten == false) {
            food1.paint(g2d);
        }
        if (food2Eaten == false) {
            food2.paint(g2d);
        }
        if (food3Eaten == false) {
            food3.paint(g2d);
        }
        if (food4Eaten == false) {
            food4.paint(g2d);
        }
        if (food5Eaten == false) {
            food5.paint(g2d);
        }
        if (food6Eaten == false) {
            food6.paint(g2d);
        }
        if (food7Eaten == false) {
            food7.paint(g2d);
        }
        if (food8Eaten == false) {
            food8.paint(g2d);
        }
        if (food9Eaten == false) {
            food9.paint(g2d);
        }
        if (food10Eaten == false) {
            food10.paint(g2d);
        }

        if (food1Eaten == true && food2Eaten == true && food3Eaten == true && food4Eaten == true && food5Eaten == true && food6Eaten == true && food7Eaten == true && food8Eaten == true && food9Eaten == true && food10Eaten == true && dead == false) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g.setColor(Color.orange);
            g.drawString("VICTORY!!!", 385, 330);
            pacman.x = 225;
            pacman.y = 225;
            villain.x = 285;
            villain.y = 225;
            villain.xa = 0;
            villain.ya = 0;
            timer = timer + 1;
            if (timer == 1000) {
                System.exit(0);
            }
        }
        
        else if (dead == true) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g.setColor(Color.red);
            g.drawString("DEFEAT!!!", 385, 330);
            pacman.x = 225;
            pacman.y = 225;
            villain.x = 285;
            villain.y = 225;
            villain.xa = 0;
            villain.ya = 0;
            timer = timer + 1;
            if (timer == 1000) {
                System.exit(0);
            }
            
        } else {
            villain.paint(g2d);
            pacman.paint(g2d);
        }
        
    }

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        JFrame frame = new JFrame("Pacman Beta 1.0");
        PacmanGame game = new PacmanGame();
        frame.setVisible(true);
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game);
        game.setBackground(Color.BLACK);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(5);
           
        }
    }
}
