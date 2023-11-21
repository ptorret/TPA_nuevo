package Graphics;

import Enemies.Dragon;
import Players.Player;

import javax.swing.*;
import java.awt.*;

public class principalMenu extends JFrame {

    private JPanel characterSelector = new JPanel();
    private Player player;
    public principalMenu(){
        setTitle("RPG videogame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,600,600);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,600,600);
        JButton start = new JButton("Start");
        start.setBounds(20,20,150,50);

        characterSelector.setBounds(0,0,600,600);
        characterSelector.setLayout(new GridLayout(2,3));

        JLabel nameLabel = new JLabel("Introduce tu nombre :");
        JTextField textName = new JTextField();

        characterSelector.add(nameLabel);
        characterSelector.add(textName);
        characterSelector.add(new JLabel());

        JButton botonBarbaro = new JButton("Barbaro");
        JButton botonMago = new JButton("Mago");
        JButton botonValquiria = new JButton("Valquiria");

        characterSelector.add(botonBarbaro);
        characterSelector.add(botonMago);
        characterSelector.add(botonValquiria);

        start.addActionListener(e -> {
            /*remove(panel);
            add(characterSelector);
            System.out.println("Empieza el videojuego");*/
            Player player = new Player("jugador");
            Dragon dragon = new Dragon();
            SwingUtilities.invokeLater(()->{
                gameMovement myGameMovement = new gameMovement(player,dragon);
            });
        });

        JButton close = new JButton("EXIT");
        close.setBounds(20,170,150,50);
        close.addActionListener(e -> {
            dispose();
        });

        panel.add(start);
        panel.add(close);

        add(panel);
        setVisible(true);
        setResizable(true);
    }
}
