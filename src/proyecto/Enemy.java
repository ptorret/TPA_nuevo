package proyecto;

import javax.swing.*;
import java.awt.*;

public class Enemy {
    //cambios
    private int hp;
    private String name;
    public int posX = 50;
    public int posY = 50;
    public int size = 30;


    public Enemy(int hp_,String name_) {
        this.hp = hp_;
        this.name = name_;
    }

    public JPanel sprite;

    /*public void createImage(){
        sprite = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillRect(50, 50, 20, 20);
            }
        };
    }*/

    public JPanel getSprite(){
        return sprite;
    }
}
