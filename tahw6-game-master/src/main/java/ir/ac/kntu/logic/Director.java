package ir.ac.kntu.logic;

import ir.ac.kntu.util.RandomHelper;
import ir.ac.kntu.util.ScannerWrapper;

import java.util.ArrayList;

public class Director {

    private ArrayList<Soldier> groupA;
    private ArrayList<Soldier> groupB;

    private GraphicsEngine graphicsEngine;

    private Soldier currentASoldier;
    private Soldier currentBSoldier;

    private VictoryState victoryState;

    public Director(GraphicsEngine graphicsEngine, int numberOfSoldier) {
        this.graphicsEngine = graphicsEngine;
        victoryState = VictoryState.NOT_FINISHED;

        groupA = new ArrayList<Soldier>();
        groupB = new ArrayList<Soldier>();
        for (int i = 0; i < numberOfSoldier; i++) {
            groupA.add(new Soldier((i + 1), Side.A));
        }

        for (int i = 0; i < numberOfSoldier; i++) {
            groupB.add(new Soldier((i + 1), Side.B));
        }
    }

    public void startGameLoop() {
        int turn = 1;
        while (!DirectorHelper.isAllDead(groupA, groupB)) {
            System.out.println("Turn " + turn);
            graphicsEngine.initialize(groupA, groupB);
            currentASoldier = groupA.get(RandomHelper.nextInt(groupA.size()));
            currentBSoldier = groupB.get(RandomHelper.nextInt(groupB.size()));
            graphicsEngine.visualizeFight(currentASoldier, currentBSoldier);
            if (RandomHelper.nextBoolean()) {
                fight(currentASoldier, currentBSoldier);
            } else {
                fight(currentBSoldier, currentASoldier);
            }

            if (currentASoldier.getHealth() == 0) {
                deleteSoldier(currentASoldier);
                graphicsEngine.visualizeDeath(currentASoldier.getId(), currentASoldier.getSide());
            } else if (currentBSoldier.getHealth() == 0){
                deleteSoldier(currentBSoldier);
                graphicsEngine.visualizeDeath(currentBSoldier.getId(), currentBSoldier.getSide());
            }
            turn++;
            ScannerWrapper.hold();
        }

        if (groupA.isEmpty()) {
            System.out.println(VictoryState.WIN_B);
        } else {
            System.out.println(VictoryState.WIN_A);
        }
    }

    public void deleteSoldier(Soldier deadSoldier) {
        if (deadSoldier.getSide() == Side.A) {
            groupA.remove(deadSoldier);
        } else {
            groupB.remove(deadSoldier);
        }
    }

    private void fight(Soldier attacker, Soldier defender) {
        graphicsEngine.visualizeFight(attacker, defender, attacker.getSide());
        if (defender.getHealth() != 0) {
            graphicsEngine.visualizeFight(defender, attacker, defender.getSide());
        }
    }

    public enum VictoryState {WIN_A, WIN_B, NOT_FINISHED}
}
