package team029.routine.soldier;

import battlecode.common.GameActionException;
import battlecode.common.MapLocation;

public class MoveToPreviousLocation extends SoldierRoutine
{
    @Override
    protected boolean doRoutine() throws GameActionException
    {
        MapLocation previousLocation = getSoldier().getPreviousLocation();
        return new MoveToward(previousLocation).run(robot);
    }
}
