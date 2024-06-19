package Extra;

import Main.GamePanel;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameOver {
    Extras extras = new Extras();
    GamePanel gamePanel;

    Font scoreFont, tryAgainFont;

    public GameOver(GamePanel panel) {
        this.gamePanel = panel;
        setFont();
    }

    public void setFont() {
        scoreFont = new Font("Space Mono", Font.BOLD, 30);
        tryAgainFont = new Font("Space Mono", Font.PLAIN, 20);
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.WHITE);
        graphics2D.setFont(scoreFont);
        FontMetrics metrics1 = gamePanel.getFontMetrics(graphics2D.getFont());
        graphics2D.drawString("Score : " + gamePanel.ui.score, (gamePanel.screenWidth - metrics1.stringWidth("Score : " + gamePanel.ui.score)) / 2, gamePanel.tileSize * 6);

        graphics2D.setColor(Color.RED);
        graphics2D.setFont(extras.font);
        FontMetrics metrics2 = gamePanel.getFontMetrics(graphics2D.getFont());
        graphics2D.drawString("GAME OVER", (gamePanel.screenWidth - metrics2.stringWidth("GAME OVER")) / 2, gamePanel.screenHeight / 2);

        graphics2D.setColor(Color.YELLOW);
        graphics2D.setFont(tryAgainFont);
        FontMetrics metrics3 = gamePanel.getFontMetrics(graphics2D.getFont());
        graphics2D.drawString("press SPACE to play again", (gamePanel.screenWidth - metrics3.stringWidth("press SPACE to play again")) / 2, gamePanel.tileSize * 17);
    }
}
