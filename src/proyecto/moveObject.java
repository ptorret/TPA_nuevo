package proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class moveObject {
    private JFrame frame;
    private JPanel canvas;
    private int x = 50;
    private int y = 50;
    private int targetX;
    private int targetY;
    private int speed = 2;
    private Enemy demon = new Enemy(10,"DAS");

    public moveObject() {
        frame = new JFrame("Walk to Mouse Click");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.MAGENTA);
                g.fillRect(demon.posX,demon.posY, demon.size, demon.size);
                g.setColor(Color.BLUE);
                g.fillRect(x, y, 20, 20);
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

    private void moveTowardsTarget() {
        Thread movementThread = new Thread(() -> {
            while (x != targetX || y != targetY) {
                if (x < targetX) {
                    x += speed;
                } else if (x > targetX) {
                    x -= speed;
                }

                if (y < targetY) {
                    y += speed;
                } else if (y > targetY) {
                    y -= speed;
                }

                SwingUtilities.invokeLater(() -> canvas.repaint());

                try {
                    //if()
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        movementThread.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(moveObject::new);
    }
}