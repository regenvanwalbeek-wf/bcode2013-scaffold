package team004.ai;

import battlecode.common.GameActionException;
import team004.robot.IRobot;

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
