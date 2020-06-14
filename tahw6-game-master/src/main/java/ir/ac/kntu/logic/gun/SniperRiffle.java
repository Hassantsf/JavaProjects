package ir.ac.kntu.logic.gun;

import ir.ac.kntu.util.RandomArmor;

public class SniperRiffle extends Gun {
    private boolean scope;

    public SniperRiffle() {
        // I set it to 0, so later I can changed manually
        super(GunType.SNIPER_RIFLE, 0, 20, RandomArmor.getCalibre());
        this.scope = RandomArmor.getScope();
        setAccuracy(60 + scopeAccuracy());
    }

    private int scopeAccuracy() {
        if (scope) {
            return RandomArmor.getScopeAccuracy();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Gun: #" + getGunType() +
                " | acc: " + getAccuracy() +
                " | dmg: " + getDamage() +
                " | calibre: " + getCalibre() +
                " | Scope: " + scope;
    }
}
