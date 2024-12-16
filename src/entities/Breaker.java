package entities;

import java.awt.*;

public class Breaker extends Entity{
    private static Breaker b;
    private Breaker(int width, int height, int x, int y) {
        super(width, height, x, y);
    }

    public static Breaker init(int width, int height, int x, int y){
        if(b == null){
            b = new Breaker(width, height, x, y);
            return b;
        }
        else{
            System.out.println("You can only have single instance of ControlHandler!");
        }
        return null;
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(new Color(255, 255, 255));
        g2d.fillRect(x, y, width, height);
    }
}
