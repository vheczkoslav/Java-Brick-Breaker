package entities;

import java.awt.*;

public abstract class Entity {
    int width, height, x, y;
    Entity(int width, int height, int x, int y){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }
    abstract void render(Graphics2D g2d);
}
