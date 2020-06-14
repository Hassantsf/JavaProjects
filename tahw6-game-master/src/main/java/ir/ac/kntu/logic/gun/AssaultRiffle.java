package ir.ac.kntu.logic.gun;

import ir.ac.kntu.util.RandomArmor;

public class AssaultRiffle extends Gun {
    public AssaultRiffle() {
        super(GunType.ASSAULT_RIFLE, 50, 10, RandomArmor.getCalibre());
    }
}
