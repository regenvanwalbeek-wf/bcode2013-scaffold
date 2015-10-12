package teamxxx.robot;

import battlecode.common.*;
import teamxxx.util.DirectionIterator;

import java.util.Iterator;

public class SoldierAI extends AbstractRobotAI
{
    public SoldierAI(RobotController robotController)
    {
        super(robotController);
    }

    @Override
    public void run() throws GameActionException
    {
        Direction targetDirection = robotController.getLocation().directionTo(getEnemyHQLocation());
        MapLocation targetLocation = robotController.getLocation().add(targetDirection);

        clearDangerousMinesOnLocation(targetLocation);


        if (!robotController.canMove(targetDirection)) {
            placeMineTowardDirection(targetDirection);
        } else {
            robotController.move(targetDirection);
            // TODO yield how long?
        }

    }

    private void clearDangerousMinesOnLocation(MapLocation location) throws GameActionException
    {
        boolean hasDangerousMine = hasDangerousMine(location);
        if (!hasDangerousMine)
            return;

        robotController.defuseMine(location);

        yield(GameConstants.MINE_DEFUSE_DELAY);
    }


    private void placeMineTowardDirection(Direction targetDirection) throws GameActionException
    {
        Iterator directionIter = new DirectionIterator(targetDirection);
        while (directionIter.hasNext())
        {
            Direction nextDirection = (Direction) directionIter.next();
            MapLocation targetLocation = robotController.getLocation().add(nextDirection);
            if (!hasMine(targetLocation))
            {
                robotController.layMine();
                yield(GameConstants.MINE_LAY_DELAY);
                break;
            }
        }
    }
}
