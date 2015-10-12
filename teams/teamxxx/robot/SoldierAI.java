package teamxxx.robot;

import battlecode.common.*;

public class SoldierAI extends AbstractRobotAI
{
    public SoldierAI(RobotController robotController)
    {
        super(robotController);
    }

    @Override
    public boolean run() throws GameActionException
    {
        Direction targetDirection = robotController.getLocation().directionTo(getEnemyHQLocation());
        MapLocation targetLocation = robotController.getLocation().add(targetDirection);

        clearDangerousMinesOnLocation(targetLocation);

        if (!robotController.canMove(targetDirection)) {
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
}
