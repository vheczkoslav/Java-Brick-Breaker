import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Game{
    private enum gameState{
        GameMenu,
        GameStart,
        GameRunning,
        GamePaused,
        GameExit
    };
    private gameState gs;
    private ControlHandler ch = ControlHandler.init();
    private GameFrame gf = GameFrame.init();
    private Graphics2D g2d;
    private int mouseX, mouseY;
    private static final long MS_PER_FRAME = 25; // 1000/25 = 40 FPS
    private GameMenu gm = null;
    Game(){
        this.gs = gameState.GameMenu; // initial game state
        gf.addKeyListener(ch);
        this.g2d = (Graphics2D)gf.getGraphics();
        gm = new GameMenu(gf);
        run();
    }
    void run(){
        var previousTime = System.currentTimeMillis();
        var lag = 0L;
        //int frameTest = 0;
        while (gs != gameState.GameExit) {
            var currentTime = System.currentTimeMillis();
            var elapsedTime = currentTime - previousTime;
            previousTime = currentTime;
            lag += elapsedTime;

            //frameTest = (frameTest + 1) % (1000 / (int)MS_PER_FRAME);

            processInput();
            //update();

            while (lag >= MS_PER_FRAME) {
                //update();
                lag -= MS_PER_FRAME;
            }
            //System.out.println("Frame: " + frameTest);

            render();
        }
    }
    void processInput(){
        if(gs == gameState.GameMenu && gf.getX() >= 100 && gf.getX() <= 300 && gf.getY() >= 200 && gf.getY() <= 250 && gf.getX() != mouseX && gf.getY() != mouseY){
            mouseX = gf.getX();
            mouseY = gf.getY();
            gs = gameState.GameStart;
            Gameplay.init(g2d);
        }
        if(ch.getKeyCode() == KeyEvent.VK_DOWN){
                System.out.println("Down");
        }
        if(ch.getKeyCode() == KeyEvent.VK_UP){
                System.out.println("Up");
        }
        if(ch.getKeyCode() == KeyEvent.VK_LEFT){
                System.out.println("Left");
        }
        if(ch.getKeyCode() == KeyEvent.VK_RIGHT){
                System.out.println("Right");
        }
    }
    void render(){
        g2d.setColor(new Color(0,0,0));
        switch(gs){
            case GameMenu:
                gm.render(g2d);
                break;
            case GameStart:
                g2d.fillRect(0,0,400,400);
                Gameplay.render();
                break;
        }
    }
}
