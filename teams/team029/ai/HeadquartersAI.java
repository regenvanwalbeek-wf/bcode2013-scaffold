package team029.ai;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;
import team029.robot.IRobot;
import team029.routine.IRoutine;
import team029.routine.Routine;

public class HeadquartersAI extends AbstractRobotAI
{
    public HeadquartersAI(IRobot robot)
    {
        super(robot);
    }

    private void spawnSoldierClosestToEnemyHQ() throws GameActionException
    {
        Direction dir = robot.getFriendlyHQLocation().directionTo(robot.getEnemyHQLocation());
        if (robot.getRobotController().canMove(dir))
            robot.getRobotController().spawn(dir);
    }

    @Override
    protected boolean doRoutine() throws GameActionException
    {
        if (robot.getRobotController().isActive())
            spawnSoldierClosestToEnemyHQ();
        robot.yield();
        return true;
    }
}
