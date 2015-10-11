package team029.routine.soldier;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;
import team029.routine.IRoutine;
import team029.routine.Routine;
import team029.routine.soldier.MoveDirection;

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
        MapLocation currentLocation = getSoldier().getLocation();
        Direction targetDirection = currentLocation.directionTo(targetLocation);
        IRoutine moveDirectionRoutine = new MoveDirection(targetDirection);
        return moveDirectionRoutine.run(robot);
    }
}
