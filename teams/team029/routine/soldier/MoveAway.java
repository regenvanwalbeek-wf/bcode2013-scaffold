package team029.routine.soldier;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import team029.routine.IRoutine;

public class MoveAway extends SoldierRoutine
{
    private MapLocation avoidLocation;

    public MoveAway(MapLocation avoidLocation)
    {
        this.avoidLocation = avoidLocation;
    }

    @Override
    protected boolean doRoutine() throws GameActionException
    {
        MapLocation currentLocation = getSoldier().getLocation();
        Direction targetDirection = currentLocation.directionTo(avoidLocation).opposite();
        IRoutine moveDirectionRoutine = new MoveDirection(targetDirection);
        return moveDirectionRoutine.run(robot);
    }
}
