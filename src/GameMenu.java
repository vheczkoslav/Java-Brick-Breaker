import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.FileInputStream;
import java.io.IOException;

public class GameMenu {
    private BufferedImage background;
    private Button b;
    GameMenu(GameFrame gf){
        try {
            background = ImageIO.read(new FileInputStream("img/main_menu_sprites/background.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        b = new Button(100, 200, 200, 50, "Start game");
    }
    public void render(Graphics2D g2d){
        g2d.drawImage(background, 0, 0, background.getWidth(), background.getHeight(), null);
        b.render(g2d);
    }
}
