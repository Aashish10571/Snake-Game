package Extra;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Extras {
    Font font;
    File file;

    public Extras() {
        setFont();
    }

    public void setFont() {
        try {
            file = new File("C:\\Users\\Aashish\\Desktop\\PROJECTS\\SNAKE GAME\\res\\font\\BlackOpsOne-Regular.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(100f);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
