package Graphics;

import Enemies.Enemy;
import Players.Player;

import javax.swing.*;

public class battleEnviorment {
    private JFrame frame;
    private JPanel panel;
    private Enemy enemy;
    private Player player;

    public battleEnviorment(Enemy enemy,Player player){
        this.enemy = enemy;
        this.player = player;
        frame = new JFrame("battle zone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        panel = new JPanel() {
            JButton noton = new JButton("mensaje");
        };

        frame.add(panel);
        frame.setVisible(true);

    }

}
