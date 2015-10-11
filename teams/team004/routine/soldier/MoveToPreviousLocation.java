package team004.routine.soldier;

import battlecode.common.GameActionException;
import battlecode.common.MapLocation;

public class MoveToPreviousLocation extends SoldierRoutine
{
    @Override
    protected boolean doRoutine() throws GameActionException
    {
        MapLocation previousLocation = soldier.getPreviousLocation();
        return new MoveToward(previousLocation).run(robot);
    }
}
