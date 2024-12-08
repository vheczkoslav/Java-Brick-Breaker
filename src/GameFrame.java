import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameFrame extends JFrame {
    final int windowSize = 500; // W = H
    private static GameFrame singleton = null;
    public static GameFrame init(){
        if(singleton == null){
            singleton = new GameFrame();
            return singleton;
        }
        else{
            System.out.println("You can only have single instance of GameFrame!");
        }
        return null;
    }
    private GameFrame(){
        this.setVisible(true);
        this.setSize(new Dimension(windowSize, windowSize));
        this.setResizable(false);
        this.setTitle("Java brick breaker game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("X: " + e.getX() + ", Y: " + e.getY());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}