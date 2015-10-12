package teamxxx.robot;

import battlecode.common.*;

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


        if (!robotController.canMove(targetDirection))
            return;

        robotController.move(targetDirection);

        // TODO yield how long?


    }

    private void clearDangerousMinesOnLocation(MapLocation location) throws GameActionException
    {
        boolean dangerousMine = hasDangerousMine(location);
        if (!dangerousMine)
            return;

        robotController.defuseMine(location);

        yield(GameConstants.MINE_DEFUSE_DELAY);
    }
}
