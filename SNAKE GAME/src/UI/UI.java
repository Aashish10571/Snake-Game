package UI;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class UI {
    GamePanel panel;

    Image apple, trophy, volume, mute;

    int trophyEarned = 0;
    public int score = 0;

    boolean scoreSet = false;

    Font font;

    public UI(GamePanel panel) {
        this.panel = panel;
        font = new Font("Space Mono", Font.BOLD, 23);
        setImage();
    }

    public void setImage() {
        try {
            apple = ImageIO.read(new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\apple\\apple.png"));
            trophy = ImageIO.read(new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\extras\\trophy.png"));
            volume = ImageIO.read(new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\volume\\mute.png"));
            mute = ImageIO.read(new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\volume\\volume.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.WHITE);
        graphics2D.setFont(font);
        graphics2D.drawImage(apple, panel.tileSize / 2, panel.tileSize / 4, panel.tileSize - 8, panel.tileSize - 8, null);
        graphics2D.drawString(" " + panel.collisionChecker.appleEaten, panel.tileSize + panel.tileSize / 4, panel.tileSize - 2);

        if (!panel.gameOn) {
            trophyEarned = Math.max(trophyEarned, panel.collisionChecker.appleEaten);
            if (!scoreSet) {
                score = panel.collisionChecker.appleEaten;
                scoreSet = true;
            }
            panel.collisionChecker.appleEaten = 0;
        } else {
            score = 0;
            scoreSet = false;
        }
        graphics2D.drawImage(trophy, panel.tileSize * 4, panel.tileSize / 4, panel.tileSize - 8, panel.tileSize - 8, null);
        graphics2D.drawString(" " + trophyEarned, 4 * panel.tileSize + panel.tileSize - 9, panel.tileSize - 2);

        if (panel.soundOn)
            graphics2D.drawImage(volume, panel.tileSize * 20 - 10, panel.tileSize / 4, panel.tileSize - 4, panel.tileSize - 4, null);
        else
            graphics2D.drawImage(mute, panel.tileSize * 20 - 10, panel.tileSize / 4, panel.tileSize - 4, panel.tileSize - 4, null);
    }
}
