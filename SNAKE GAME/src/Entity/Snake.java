package Entity;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Snake {
    GamePanel panel;

    Image[] snakeImg;

    public Snake(GamePanel panel) {
        this.panel = panel;

        snakeImg = new Image[14];

        setImage();
    }

    public void setImage() {
        try {
            // -------------------------------- Head Of Snake -------------------------------------//
            snakeImg[0] = ImageIO.read(new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\snake\\head_up.png"));
            snakeImg[1] = ImageIO.read(new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\snake\\head_down.png"));
            snakeImg[2] = ImageIO.read(new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\snake\\head_left.png"));
            snakeImg[3] = ImageIO.read(new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\snake\\head_right.png"));

            // -------------------------------- Body Of Snake -------------------------------------//
            snakeImg[4] = ImageIO.read(new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\snake\\body_horizontal.png"));
            snakeImg[5] = ImageIO.read(new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\snake\\body_vertical.png"));
            snakeImg[6] = ImageIO.read(new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\snake\\body_bottomleft.png"));
            snakeImg[7] = ImageIO.read(new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\snake\\body_topleft.png"));
            snakeImg[8] = ImageIO.read(new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\snake\\body_bottomright.png"));
            snakeImg[9] = ImageIO.read(new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\snake\\body_topright.png"));

            // -------------------------------- Tail Of Snake -------------------------------------//
            snakeImg[10] = ImageIO.read(new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\snake\\tail_up.png"));
            snakeImg[11] = ImageIO.read(new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\snake\\tail_down.png"));
            snakeImg[12] = ImageIO.read(new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\snake\\tail_left.png"));
            snakeImg[13] = ImageIO.read(new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\snake\\tail_right.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D graphics2D) {
        for (int i = 0; i < panel.bodyParts; i++) {
            if (i == 0) {
                switch (panel.direction) {
                    case "up":
                        graphics2D.drawImage(snakeImg[0], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                        break;
                    case "down":
                        graphics2D.drawImage(snakeImg[1], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                        break;
                    case "left":
                        graphics2D.drawImage(snakeImg[2], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                        break;
                    case "right":
                        graphics2D.drawImage(snakeImg[3], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                        break;
                }
            } else if (i == panel.bodyParts - 1) {
                if (!Objects.equals(panel.snakeDir[i], panel.snakeDir[i - 1])) {
                    switch (panel.snakeDir[i - 1]) {
                        case "up":
                            graphics2D.drawImage(snakeImg[11], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                            break;
                        case "down":
                            graphics2D.drawImage(snakeImg[10], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                            break;
                        case "left":
                            graphics2D.drawImage(snakeImg[13], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                            break;
                        case "right":
                            graphics2D.drawImage(snakeImg[12], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                            break;
                    }
                } else {
                    switch (panel.snakeDir[i]) {
                        case "up":
                            graphics2D.drawImage(snakeImg[11], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                            break;
                        case "down":
                            graphics2D.drawImage(snakeImg[10], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                            break;
                        case "left":
                            graphics2D.drawImage(snakeImg[13], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                            break;
                        case "right":
                            graphics2D.drawImage(snakeImg[12], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                            break;
                    }
                }
            } else {
                if (Objects.equals(panel.snakeDir[i], "right") && Objects.equals(panel.snakeDir[i - 1], "right") || Objects.equals(panel.snakeDir[i], "left") && Objects.equals(panel.snakeDir[i - 1], "left")) {
                    graphics2D.drawImage(snakeImg[4], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                }
                if (Objects.equals(panel.snakeDir[i], "up") && Objects.equals(panel.snakeDir[i - 1], "up") || Objects.equals(panel.snakeDir[i], "down") && Objects.equals(panel.snakeDir[i - 1], "down")) {
                    graphics2D.drawImage(snakeImg[5], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                }
                if (Objects.equals(panel.snakeDir[i], "right") && Objects.equals(panel.snakeDir[i - 1], "down")) {
                    graphics2D.drawImage(snakeImg[6], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                }
                if (Objects.equals(panel.snakeDir[i], "down") && Objects.equals(panel.snakeDir[i - 1], "right")) {
                    graphics2D.drawImage(snakeImg[9], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                }
                if (Objects.equals(panel.snakeDir[i], "right") && Objects.equals(panel.snakeDir[i - 1], "up")) {
                    graphics2D.drawImage(snakeImg[7], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                }
                if (Objects.equals(panel.snakeDir[i], "up") && Objects.equals(panel.snakeDir[i - 1], "right")) {
                    graphics2D.drawImage(snakeImg[8], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                }
                if (Objects.equals(panel.snakeDir[i], "left") && Objects.equals(panel.snakeDir[i - 1], "up")) {
                    graphics2D.drawImage(snakeImg[9], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                }
                if (Objects.equals(panel.snakeDir[i], "up") && Objects.equals(panel.snakeDir[i - 1], "left")) {
                    graphics2D.drawImage(snakeImg[6], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                }
                if (Objects.equals(panel.snakeDir[i], "left") && Objects.equals(panel.snakeDir[i - 1], "down")) {
                    graphics2D.drawImage(snakeImg[8], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                }
                if (Objects.equals(panel.snakeDir[i], "down") && Objects.equals(panel.snakeDir[i - 1], "left")) {
                    graphics2D.drawImage(snakeImg[7], panel.snakeX[i], panel.snakeY[i], panel.tileSize, panel.tileSize, null);
                }
            }
        }
    }
}
