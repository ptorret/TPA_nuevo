package Players;

public class Player {
    private String nombre;
    private int xp=0;
    private String warriorClass;
    private int health = 100;
    private int damageAttack = 20;
    private int specialAttack = 40;

    private int sizeXplayer = 30;
    private int sizeYplayer = 30;

    private int posX = 50;
    private int posY = 50;



    public Player(String name){
        this.nombre = name;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
    public int getXp(){
        return this.xp;
    }

    public void setHealth(int vida){
        this.health = vida;
    }
    public int getHealth(){
        return this.health;
    }

    public void setDamageAttack(int damageAttack) {
        this.damageAttack = damageAttack;
    }
    public int getDamageAttack() {
        return damageAttack;
    }

    public int getSizeXPlayer() {
        return sizeXplayer;
    }

    public int getSizeYPlayer() {
        return sizeYplayer;
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

    public String getWarriorClass() {
        return warriorClass;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }
}
