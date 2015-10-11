package team004.routine.soldier.defuse;

import battlecode.common.GameActionException;
import team004.routine.soldier.SoldierRoutine;

/**
 * Responsibility: Defuse a mine with a robot at an adjacent target location
 */
public class Defuse extends SoldierRoutine
{
    @Override
    public boolean doRoutine() throws GameActionException
    {
        soldier.defuseMine();

        return true;
    }
}
