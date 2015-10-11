package team029.routine.soldier;

import battlecode.common.*;
import team029.robot.soldier.ISoldier;
import team029.routine.Routine;
import team029.routine.soldier.SoldierRoutine;

public class IsOnTopOfNonFriendlyMine extends SoldierRoutine
{
    @Override
    protected boolean doRoutine() throws GameActionException
    {
        ISoldier soldier = getSoldier();
        MapLocation currentLocation = soldier.getLocation();
        Team mineTeam = robot.senseMine(currentLocation);

        if (mineTeam == null)
            return false;

        Team robotTeam = robot.getTeam();

        if (mineTeam == robotTeam)
            return false;
        else
            return true;
    }
}
