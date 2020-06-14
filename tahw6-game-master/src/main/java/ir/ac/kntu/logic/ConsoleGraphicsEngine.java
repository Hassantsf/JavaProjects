package ir.ac.kntu.logic;

import ir.ac.kntu.util.RandomHelper;

import java.util.ArrayList;

public class ConsoleGraphicsEngine implements GraphicsEngine {

    //TODO: Implement Graphics Options


    @Override
    public void initialize(ArrayList<Soldier> groupA, ArrayList<Soldier> groupB) {
        visualizeSide("A", groupA);
        System.out.println();
        visualizeSide("B", groupB);
    }

    @Override
    public void visualizeFight(Soldier currentASoldier, Soldier currentBSoldier) {
        System.out.println("---------------------------------------------------");
        System.out.println("From A:");
        System.out.println(currentASoldier);
        System.out.println();
        System.out.println("From B:");
        System.out.println(currentBSoldier);
        System.out.println("---------------------------------------------------");
    }

    @Override
    public void visualizeFight(Soldier attacker, Soldier defender, Side side) {
        int accuracyRoll = RandomHelper.nextInt(100);
        System.out.print("Soldier " + side + " Attacks ");
        System.out.print("AccuracyRoll: " + accuracyRoll);

        if (accuracyRoll > attacker.getGun().getAccuracy()) {
            int health = defender.getHealth() - attacker.getGun().getDamage();
            // For Head Shot
            if (accuracyRoll - 25 > attacker.getGun().getAccuracy()) {
                defender.setHealth(0);
                System.out.println(" Soldier " + attacker.getSide() + " headshot soldier " + defender.getSide());
            } else {
                if (health >= 0) {
                    defender.setHealth(health);
                } else {
                    defender.setHealth(0);
                }
                System.out.println(" Attack Hits | Soldier " + side + " takes " + attacker.getDamage() + " damage");
            }
        } else {
            System.out.println(" Attack Missed");
        }
    }

    @Override
    public void visualizeDeath() {
        System.out.println("Soldier died");
    }

    @Override
    public void visualizeDeath(int id, Side side) {
        System.out.println("Soldier #" + id + " From Side " + side + " Died!");
    }

    @Override
    public void visualizeVictoryCondition(Director.VictoryState victoryState) {
        System.out.println(victoryState);
    }

    private void visualizeSide(String side, ArrayList<Soldier> group) {
        System.out.println("Side " + side);
        for (int i = 0; i < group.size(); i++) {
            System.out.println(group.get(i));
        }
    }

}
