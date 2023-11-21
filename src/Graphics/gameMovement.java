package Graphics;

import Enemies.Dragon;
import Enemies.Enemy;
import Players.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

public class gameMovement {
    private JFrame frame;
    private battleEnviorment battleFrame = new battleEnviorment();
    private JPanel canvas;
    private Player player;
    private Enemy enemy;
    private int targetX;
    private int targetY;
    private final int speed = 1;

    private JButton buttonFight;

    public gameMovement(Player player_, Enemy enemy_) {
        this.player = player_;
        this.enemy = enemy_;

        frame = new JFrame("TPA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        buttonFight = new JButton("fight");
        buttonFight.setBounds(enemy.getPosX(),enemy.getPosY(),100,20);
        buttonFight.setVisible(false);
        frame.add(buttonFight);

        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                super.paintComponents(g);
                g.setColor(Color.BLUE);
                g.fillRect(300, 20, enemy.getSizeXenemy(), enemy.getSizeYenemy());
                g.setColor(Color.MAGENTA);
                g.fillRect(player.getPosX(), player.getPosY(), player.getSizeXPlayer(), player.getSizeYPlayer());
            }
        };

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                targetX = e.getX();
                targetY = e.getY();
                moveTowardsTarget();
            }
        });

        frame.add(canvas);
        frame.setVisible(true);
    }

    public boolean colicion(){
        if(     player.getPosX() < enemy.getPosX() + enemy.getSizeXenemy() &&
                player.getPosX() > enemy.getPosX() - enemy.getSizeYenemy() &&
                player.getPosY() < enemy.getPosY() + enemy.getSizeYenemy() &&
                player.getPosY() > enemy.getPosY() - enemy.getSizeYenemy()){
            return true;
        }
        return false;
    }
    private void moveTowardsTarget() {
        buttonFight.setVisible(false);

        Thread movementThread = new Thread(() -> {
            while (player.getPosX() != targetX || player.getPosY() != targetY) {
                if (player.getPosX() < targetX) {
                    player.setPosX(player.getPosX() + speed);
                } else if (player.getPosX() > targetX) {
                    player.setPosX(player.getPosX() - speed);
                }
                if (player.getPosY() < targetY) {
                    player.setPosY(player.getPosY() + speed);
                } else if (player.getPosY() > targetY) {
                    player.setPosY(player.getPosY() - speed);
                }

                SwingUtilities.invokeLater(() -> canvas.repaint());

                try {
                    Thread.sleep(1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(colicion()){
                try {
                    System.out.println("!!!");
                    buttonFight.setVisible(true);
                    buttonFight.addActionListener(e ->{
                        battleFrame.recreateBattle(player,enemy);
                        battleFrame.setVisible(true);
                        buttonFight.setVisible(false);
                    });
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        movementThread.start();
    }

    public static void main(String[] args) {
        /*
        Player player = new Player("jugador");
        Dragon dragon = new Dragon();
        SwingUtilities.invokeLater(()->{
            gameMovement myGameMovement = new gameMovement(player,dragon);
        });
        */
        principalMenu menu = new principalMenu();
    }
}
