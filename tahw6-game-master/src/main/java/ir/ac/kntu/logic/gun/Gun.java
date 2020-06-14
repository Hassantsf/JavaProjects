package ir.ac.kntu.logic.gun;

import ir.ac.kntu.logic.calibre.Calibre;

public class Gun {
    private GunType gunType;
    private int accuracy;
    private int damage;
    private Calibre calibre;

    public Gun() {
    }

    public Gun(GunType gunType, int accuracy, int damage, Calibre calibre) {
        this.gunType = gunType;
        this.calibre = calibre;
        this.accuracy = accuracy + calibre.getAccuracy();
        this.damage = damage + calibre.getDamage();
    }

    // Getters
    public GunType getGunType() {
        return gunType;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getDamage() {
        return damage;
    }

    public Calibre getCalibre() {
        return calibre;
    }

    // Setters
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public String toString() {
        return "Gun: #" + gunType +
                " | acc: " + accuracy +
                " | dmg: " + damage +
                " | calibre: " + calibre +
                '}';
    }

}

