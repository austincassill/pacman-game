package pacmangame;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Pacman {
    BufferedImage img;
    
    int x = 425;
    int y = 475;
    int xa = 0;
    int ya = 0;
    int shift = 0; // 0 mouth is open, 1 mouth is closed
    
    private PacmanGame game;
    
    public Pacman(PacmanGame game) {
        try {
           img = ImageIO.read(getClass().getResource("/pacmangame/openright.png"));
           
        } catch (IOException e) {
        }
        this.game = game;
    }
    
    public void move() {
                // implement barricades
                //barricade 1
                if (x == 160 && xa == -1 && y > 50 && y < 600) {
                    x = 160;
                    y = y + ya;
                } 
                else if (x == 50 && xa == 1 && y > 50 && y < 600) {
                    x = 50;
                    y = y + ya;
                }
                else if (y == 50 && ya == 1 && x > 50 && x < 160) {
                    y = 50;
                    x = x + xa;
                }
                else if (y == 600 && ya == -1 && x > 50 && x < 160) {
                    y = 600;
                    x = x + xa;
                }
                // barricade 2
                else if (x == 800 && xa == -1 && y > 50 && y < 600) {
                    x = 800;
                    y = y + ya;
                } 
                else if (x == 690 && xa == 1 && y > 50 && y < 600) {
                    x = 690;
                    y = y + ya;
                }
                else if (y == 50 && ya == 1 && x > 690 && x < 800) {
                    y = 50;
                    x = x + xa;
                }
                else if (y == 600 && ya == -1 && x > 690 && x < 800) {
                    y = 600;
                    x = x + xa;
                }
                // barricade 3
                else if (x == 575 && xa == -1 && y > 170 && y < 470) {
                    x = 575;
                    y = y + ya;
                }
                else if (x == 275 && xa == 1 && y > 170 && y < 470) {
                    x = 275;
                    y = y + ya;
                }
                else if (y == 170 && ya == 1 && x > 275 && x < 575) {
                    y = 170;
                    x = x + xa;
                }
                else if (y == 470 && ya == -1 && x > 275 && x < 575) {
                    y = 470;
                    x = x + xa; 
                }
                else {
                    if (x + xa > 0 && x + xa < game.getWidth()-50) {
			x = x + xa;
                    }
                    if (y + ya > 0 && y + ya < game.getHeight()-50) {
			y = y + ya;
                    }
                }
                
                
    }
    
    public void paint(Graphics2D g) {
		g.drawImage(img, x, y, 50, 50, null);
    }
    
    public void keyReleased(KeyEvent e) {
		xa = 0;
                ya = 0;
    }
    
    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    xa = -1;
                    if (shift == 0) {
                        try {
                            img = ImageIO.read(getClass().getResource("/pacmangame/openleft.png"));
                        } catch (IOException f) {
                        }
                        shift = 1;
                    } else {
                        try {
                            img = ImageIO.read(getClass().getResource("/pacmangame/closedleft.png"));
                        } catch (IOException f) {
                        }
                        shift = 0;
                    }
                }
                
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    xa = 1;
                    if (shift == 0) {
                        try {
                            img = ImageIO.read(getClass().getResource("/pacmangame/openright.png"));
                        } catch (IOException f) {
                        }
                        shift = 1;
                    } else {
                        try {
                            img = ImageIO.read(getClass().getResource("/pacmangame/closedright.png"));
                        } catch (IOException f) {
                        }
                        shift = 0;
                    }
                }
                
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    ya = -1;
                    if (shift == 0) {
                        try {
                            img = ImageIO.read(getClass().getResource("/pacmangame/openup.png"));
                        } catch (IOException f) {
                        }
                        shift = 1;
                    } else {
                        try {
                            img = ImageIO.read(getClass().getResource("/pacmangame/closedup.png"));
                        } catch (IOException f) {
                        }
                        shift = 0;
                    }
                }
                
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    ya = 1;
                    if (shift == 0) {
                        try {
                            img = ImageIO.read(getClass().getResource("/pacmangame/opendown.png"));
                        } catch (IOException f) {
                        }
                        shift = 1;
                    } else {
                        try {
                            img = ImageIO.read(getClass().getResource("/pacmangame/closeddown.png"));
                        } catch (IOException f) {
                        }
                        shift = 0;
                    }
                }
    }
}
