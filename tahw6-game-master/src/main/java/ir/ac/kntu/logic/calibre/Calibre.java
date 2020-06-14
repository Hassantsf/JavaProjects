package ir.ac.kntu.logic.calibre;

public enum Calibre {
    CALIBRE_5(15, 0),
    CALIBRE_7(-10, 10);

    private final int accuracy;
    private final int damage;

    private Calibre(int accuracy, int damage) {
        this.accuracy = accuracy;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public int getAccuracy() {
        return accuracy;
    }
}