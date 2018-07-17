package pacmangame;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Food {
    BufferedImage img;
    
    int x = randomWithRange(45,850);
    int y = randomWithRange(45,650);
    
    
    
    private PacmanGame game;
    
    public Food(PacmanGame game) {
        try {
           img = ImageIO.read(getClass().getResource("/pacmangame/food.png"));
        } catch (IOException e) {
        }
        this.game = game;
        
        while (((x > 80 && x < 180) && (y > 80 && y < 620)) || ((x > 720 && x < 820) && (y > 80 && y < 620)) || ((x > 225 && x < 600) && (y > 195 && y < 470))) {
            x = randomWithRange(45,850);
            y = randomWithRange(45,650);
        }
    }
    
    public void paint(Graphics2D g) {
		g.drawImage(img, x, y, 10, 10, null);
    }
    
    int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;     
        return (int)(Math.random() * range) + min;
    }
    
}
