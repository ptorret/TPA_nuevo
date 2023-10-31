package Enemies;

public class Enemy {
    private int sizeXenemy = 30;
    private int sizeYenemy = 30;
    private int health = 120;
    private int damageAttack = 15;
    private int defensa = 20;

    private int posX = 300;
    private int posY= 20;


    public int getSizeXenemy() {
        return sizeXenemy;
    }
    public int getSizeYenemy() {
        return sizeYenemy;
    }
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
