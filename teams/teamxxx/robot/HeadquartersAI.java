package teamxxx.robot;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.GameConstants;
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
    public boolean run() throws GameActionException {
        Direction spawnDirection = getSpawnDirection();
        if (spawnDirection == null)
            return false;

        robotController.spawn(spawnDirection);

        yield(GameConstants.HQ_SPAWN_DELAY); // TODO yielding will change if builiding suppliers...equation...or maybe just use isActive and dont worry about ever yielding..
        return true;
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
