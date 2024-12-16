import entities.*;

import java.awt.*;

public class Gameplay {
    private static Graphics2D g2d;
    private static Breaker b;
    static int level = 1;

    static void init(Graphics2D gd){
        b = Breaker.init(50, 25, 175, 350);
        g2d = gd;
    }

    static void render(){
        try {
            if(b != null) b.render(g2d);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private Gameplay(){}
}
