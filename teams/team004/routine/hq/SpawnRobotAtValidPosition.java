package team004.routine.hq;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import team004.util.DirectionIterator;

/**
 * Routine for spawning a robot in a safe position. Finds a position without any dangerous
 * mines or robots and puts a robot there.
 */
public class SpawnRobotAtValidPosition extends HQRoutine
{
    @Override
    protected boolean doRoutine() throws GameActionException {
        if (!hq.isActive())
            return false;

        // Try to spawn a robot on the direction closest
        Direction spawnDirection = getSpawnDirection();
        if (spawnDirection == null)
            return false;

        hq.spawn(spawnDirection);

        return true;
    }

    private Direction getSpawnDirection() throws GameActionException
    {
        // Try to spawn in the direction toward the enemy. Else get the next available square.
        Direction towardEnemyHQ = directionClosestToEnemyHQ();
        if (canSpawnRobotInDirection(towardEnemyHQ))
            return towardEnemyHQ;

        DirectionIterator iter = new DirectionIterator();
        while (iter.hasNext())
        {
            Direction nextDirection = (Direction) iter.next();
            if (nextDirection != towardEnemyHQ && canSpawnRobotInDirection(nextDirection))
                return nextDirection;
        }

        return null;
    }

    private Direction directionClosestToEnemyHQ()
    {
        return hq.getLocation().directionTo(hq.getEnemyHQLocation());
    }

    private boolean canSpawnRobotInDirection(Direction direction) throws GameActionException
    {
        if (!robot.canMove(direction))
            return false;

        boolean dangerousMine = hq.hasDangerousMine(hq.getLocation().add(direction));
        if (dangerousMine)
            return false;

        return true;
    }
}
