package ir.ac.kntu.logic;

import java.util.ArrayList;

public interface GraphicsEngine {


    public void initialize(ArrayList<Soldier> groupA, ArrayList<Soldier> groupB);

    public void visualizeFight(Soldier currentASoldier,Soldier currentBSoldier);

    public void visualizeFight(Soldier attacker, Soldier defender, Side side);

    public void visualizeDeath();

    public void visualizeDeath(int id, Side side);

    public void visualizeVictoryCondition(Director.VictoryState victoryState);
}
