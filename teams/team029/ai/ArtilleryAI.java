package team029.ai;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import team029.robot.IRobot;
import team029.routine.Routine;

public class ArtilleryAI extends AbstractRobotAI
{

    public ArtilleryAI(IRobot robot)
    {
        super(robot);
    }

    @Override
    protected boolean doRoutine() throws GameActionException
    {
        robot.yield();
        return true;
    }
}
