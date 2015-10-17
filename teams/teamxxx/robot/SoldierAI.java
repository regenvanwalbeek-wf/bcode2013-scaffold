package teamxxx.robot;

import battlecode.common.*;
import teamxxx.util.DirectionUtil;

import java.util.ArrayList;

// TODO cache the location and see if that improves things much
public class SoldierAI extends AbstractRobotAI
{
    public SoldierAI(RobotController robotController)
    {
        super(robotController);
    }

    @Override
    public boolean run() throws GameActionException
    {
        Direction targetDirection = getMineFreeDirectionCloserToHQ();
        if (targetDirection == null) {
            targetDirection = robotController.getLocation().directionTo(getEnemyHQLocation());
        }
        robotController.setIndicatorString(1, "Dir " + targetDirection);
        MapLocation targetLocation = robotController.getLocation().add(targetDirection);

        clearDangerousMinesOnLocation(targetLocation);

        if (!robotController.canMove(targetDirection)) {
            // If there's an adjacent enemy, attack!
            if (robotController.senseNearbyGameObjects(Robot.class, 1, getEnemyTeam()).length > 0)
                return true;

            if (hasMine(robotController.getLocation()))
                return false;

            robotController.layMine();
            yield(GameConstants.MINE_LAY_DELAY);
            return true;
        } else {
            robotController.move(targetDirection);
            yield(1); // TODO How long are you supposed to yield after movement?
            return true;
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

    // TODO make this "closest"? just have to change that static to do a little bit more calculation. It's pretty expensive it seems...
    private Direction getMineFreeDirectionCloserToHQ() throws GameActionException
    {
        int before = Clock.getBytecodesLeft();
        ArrayList<Direction> directionsCloserToHQ = DirectionUtil.getDirectionsCloserAndEquidistantToTarget(robotController.getLocation(), getEnemyHQLocation());
        int after = Clock.getBytecodesLeft();
        robotController.setIndicatorString(2, "bytecodes" + (before - after));
        for (Direction direction : directionsCloserToHQ)
        {
            boolean hasDangerousMine = hasDangerousMine(robotController.getLocation().add(direction));
            if (hasDangerousMine)
                continue;

            if (!robotController.canMove(direction))
                continue;

            return direction;
        }

        return null;
    }
}
