import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlHandler implements KeyListener {
    private static ControlHandler singleton = null;
    private ControlHandler(){ singleton = this; }
    private int currentKeyCode;
    public static ControlHandler init(){
        if(singleton == null){
            singleton = new ControlHandler();
            return singleton;
        }
        else{
            System.out.println("You can only have single instance of ControlHandler!");
        }
        return null;
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        currentKeyCode = e.getKeyCode();
        //System.out.println(currentKeyCode);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        currentKeyCode = 0;
    }

    public int getKeyCode(){
        return currentKeyCode;
    }
}
