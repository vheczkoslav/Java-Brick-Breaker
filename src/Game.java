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
    private static final long MS_PER_FRAME = 25; // 1000/25 = 40 FPS
    Game(){
        this.gs = gameState.GameMenu; // initial game state
        gf.addKeyListener(ch);
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

            while (lag >= MS_PER_FRAME) {
                //update();
                lag -= MS_PER_FRAME;
            }
            //System.out.println("Frame: " + frameTest);

            //render();
        }
    }
    void processInput(){
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
}
