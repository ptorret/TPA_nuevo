package Graphics;

import Enemies.Enemy;
import Players.Player;

import javax.swing.*;
import java.awt.*;

public class battleEnviorment extends JFrame{
    private Player player;
    private Enemy enemy;

    private JPanel battleImages;
    private JButton attack = new JButton("Attack");
    private JButton attackSpecial = new JButton("AttackSpecial");
    private JButton buttonFinal = new JButton();
    private boolean specialAvailable = true;

    public battleEnviorment(){
        setResizable(false);
        setTitle("Battle frame");
        setLocation(150,150);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void finalAction(){
        JButton buttonFinal = new JButton();
        buttonFinal.setBounds(300,300,50,50);
        battleImages.add(buttonFinal);
        attack.setVisible(false);
        attackSpecial.setVisible(false);
        //buttonFinal.setText("Fin");
        buttonFinal.setVisible(true);
        if(player.getHealth() <= 0){
            buttonFinal.setText("Perdiste");
        }else{
            buttonFinal.setText("Ganaste");
        }
        buttonFinal.addActionListener(g ->{
            dispose();
        });
    }

    public void ATTACK(JLabel informationPlayer,JLabel informationEnemy,String attackType){

        if(player.getHealth() > 0){
            if(attackType == "normal"){
                enemy.setHealth(enemy.getHealth() - player.getDamageAttack());
            }else{
                enemy.setHealth(enemy.getHealth() - player.getSpecialAttack());
            }
            //enemy.setHealth(enemy.getHealth() - player.getDamageAttack());
            player.setHealth(player.getHealth() - enemy.getDamageAttack());
            informationPlayer.setText("Jugador\n Class : " + player.getWarriorClass() + " \n Salud: " + player.getHealth());
            informationEnemy.setText("Enemy\n Salud: " + enemy.getHealth());

            if(player.getHealth() <= 0){
                informationPlayer.setText("Jugador\n Class : " + player.getWarriorClass() + " \n Salud: " + 0);
                informationEnemy.setText("Enemy\n Salud: " + enemy.getHealth());
                finalAction();

            } else if (enemy.getHealth() <= 0) {
                informationPlayer.setText("Jugador\n Class : " + player.getWarriorClass() + " \n Salud: " + player.getHealth());
                informationEnemy.setText("Enemy\n Salud: " + 0);
                finalAction();
            }
        }

    }
    public void recreateBattle(Player player_,Enemy enemy_){
        setEnemy(enemy_);
        setPlayer(player_);
        attack.setSize(230,40);
        attackSpecial.setSize(230,40);
        battleImages = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLUE);
                g.fillRect(20, 20, 40, 40);
                g.setColor(Color.MAGENTA);
                g.fillRect(400,200 , 40, 40);
            }
        };
        battleImages.setPreferredSize(new Dimension(500,350));

        setLayout(new BorderLayout());

        JPanel buttonFightPanel = new JPanel();
        buttonFightPanel.setPreferredSize(new Dimension(100,50));
        buttonFightPanel.setLayout(new GridLayout());
        attack.setVisible(true);
        attackSpecial.setVisible(true);
        buttonFightPanel.add(attack);
        buttonFightPanel.add(attackSpecial);

        JPanel informationBattle = new JPanel();
        informationBattle.setPreferredSize(new Dimension(100,95));
        informationBattle.setLayout(new GridLayout());

        JLabel informationPlayer = new JLabel();
        informationPlayer.setText("Jugador\n Class : " + player.getWarriorClass() + " \n Salud: " + player.getHealth());
        informationBattle.add(informationPlayer);
        JLabel informationEnemy = new JLabel();
        informationEnemy.setText("Enemy\n Salud: " + enemy.getHealth());
        informationBattle.add(informationEnemy);


        add(informationBattle,BorderLayout.NORTH);
        add(battleImages,BorderLayout.CENTER);
        add(buttonFightPanel,BorderLayout.SOUTH);

        attack.addActionListener(e ->{
            ATTACK(informationPlayer,informationEnemy,"normal");
        });

        attackSpecial.addActionListener(e->{
            if(specialAvailable){
                ATTACK(informationPlayer,informationEnemy,"normal");
                specialAvailable = false;
                attackSpecial.setVisible(false);
            }
        });
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
