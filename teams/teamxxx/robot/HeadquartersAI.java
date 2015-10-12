package teamxxx.robot;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import teamxxx.util.DirectionIterator;

import java.util.Iterator;

public class HeadquartersAI extends AbstractRobotAI
{
    public HeadquartersAI(RobotController robotController)
    {
        super(robotController);
    }

    @Override
    public void run() throws GameActionException {
        if (!robotController.isActive())
            return;

        Direction spawnDirection = getSpawnDirection();
        if (spawnDirection == null)
            return;

        robotController.spawn(spawnDirection);

        // TODO yield. How many times? equation...or maybe it's active while spawning and doesnt matter...
    }


    private Direction getSpawnDirection() throws GameActionException {
        // Try to spawn in the direction toward the enemy. Else get the next available square.
        Direction towardEnemyHQ = calcDirectionClosestToEnemyHQ();

        Iterator iter = new DirectionIterator(towardEnemyHQ);
        while (iter.hasNext()) {
            Direction nextDirection = (Direction) iter.next();
            if (canSpawnRobotInDirection(nextDirection))
                return nextDirection;
        }

        return null;
    }

    private Direction calcDirectionClosestToEnemyHQ() {
        return robotController.getLocation().directionTo(getEnemyHQLocation());
    }

    private boolean canSpawnRobotInDirection(Direction direction) throws GameActionException {
        if (!robotController.canMove(direction))
            return false;

        boolean dangerousMine = hasDangerousMine(robotController.getLocation().add(direction));
        if (dangerousMine)
            return false;

        return true;
    }
}
