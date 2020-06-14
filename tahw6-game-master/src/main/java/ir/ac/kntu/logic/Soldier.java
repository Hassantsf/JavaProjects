package ir.ac.kntu.logic;

import ir.ac.kntu.logic.gun.Gun;
import ir.ac.kntu.util.RandomArmor;

public class Soldier {
    private int id;
    private int health;
    private int damage;
    private Gun gun;
    private Side side;

    public Soldier(int id, Side side){
        health = RandomArmor.getHealth();
        gun = RandomArmor.getWeapon();
        this.damage = gun.getDamage();
        this.setId(id);
        this.side = side;
    }
    public Gun getGun() {
        return gun;
    }
    public int getHealth(){
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public Side getSide() {
        return side;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Soldier: " +
                "#" + getId() +
                " | health: " + health +
                "\n" + gun;
    }
}
