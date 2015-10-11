package team004.routine.soldier;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import team004.routine.core.IRoutine;

/**
 * Responsibility: Move a robot toward a given coordinate.
 */
public class MoveToward extends SoldierRoutine
{
    private MapLocation targetLocation;

    public MoveToward(MapLocation targetLocation)
    {
        this.targetLocation = targetLocation;
    }

    @Override
    public boolean doRoutine() throws GameActionException
    {
        MapLocation currentLocation = soldier.getLocation();
        Direction targetDirection = currentLocation.directionTo(targetLocation);
        IRoutine moveDirectionRoutine = new MoveDirection(targetDirection);
        return moveDirectionRoutine.run(robot);
    }
}
