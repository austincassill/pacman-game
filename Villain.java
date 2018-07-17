/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmangame;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author Austin
 */
public class Villain {
    BufferedImage img;
    
    int x = 285;
    int y = 225;
    int xa = 2;
    int ya = 2;
    int movement = (int) Math.round(Math.random()*1);
    
    private PacmanGame game;
    
    public Villain(PacmanGame game) {
        try {
           img = ImageIO.read(getClass().getResource("/pacmangame/villain.png"));
        } catch (IOException e) {
        }
        this.game = game;
    }
    
    public void move() {
        if (x + xa < 0) {
            xa = 2;
            ya = randomWithRange(-2,2);
            while (ya == 1 || ya == -1) {
                ya = randomWithRange(-2,2);
            }
        }
	if (x + xa > game.getWidth() - 50) {
            xa = -2;
            ya = randomWithRange(-2,2);
            while (ya == 1 || ya == -1) {
                ya = randomWithRange(-2,2);
            }
        }
	if (y + ya < 0) {
            ya = 2;
            xa = randomWithRange(-2,2);
            while (xa == 1 || xa == -1) {
                xa = randomWithRange(-2,2);
            }
        }
	if (y + ya > game.getHeight() - 50) {
            ya = -2;
            xa = randomWithRange(-2,2);
            while (xa == 1 || xa == -1) {
                xa = randomWithRange(-2,2);
            }
        }
        
        x = x + xa;
        y = y + ya;
    }
    
    public void paint(Graphics2D g) {
		g.drawImage(img, x, y, 50, 50, null);
    }
    
    int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;     
        return (int)(Math.random() * range) + min;
    }
}
