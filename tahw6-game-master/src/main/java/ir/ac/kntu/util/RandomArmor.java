package ir.ac.kntu.util;

import ir.ac.kntu.logic.calibre.Calibre;
import ir.ac.kntu.logic.gun.AssaultRiffle;
import ir.ac.kntu.logic.gun.Gun;
import ir.ac.kntu.logic.gun.SniperRiffle;

public class RandomArmor {
    public static Calibre getCalibre() {
        return RandomHelper.nextBoolean() ? Calibre.CALIBRE_7 : Calibre.CALIBRE_5;
    }

    public static boolean getScope() {
        return RandomHelper.nextBoolean();
    }

    public static int getScopeAccuracy() {
        int roof = 10;
        int ceil = 5;
        return RandomHelper.nextInt(ceil, roof);
    }

    public static Gun getWeapon() {
        if (RandomHelper.nextBoolean()) {
            return new AssaultRiffle();
        } else {
            return new SniperRiffle();
        }
    }

    public static int getHealth() {
        int ceil = 10, roof = 100;
        return RandomHelper.nextInt(ceil, roof);
    }
}
