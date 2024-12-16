import javax.swing.*;
import java.awt.*;

public class Button {
    private int x, y, width, height;
    private String text;
    Button(int x, int y, int width, int height, String text){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }
    void render(Graphics2D g2d){
        g2d.fillRect(x, y, width, height);
        g2d.setFont(new Font("Serif", Font.PLAIN, 23)); // 30pts = 40px
        g2d.setColor(new Color(255, 255, 255));
        g2d.drawString(text, x + (width/4), y + (height/2));
    }
}
