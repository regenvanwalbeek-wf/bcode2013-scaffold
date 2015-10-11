package team004.ai;

import battlecode.common.RobotController;
import team004.robot.IRobot;
import team004.routine.core.Routine;

public abstract class AbstractRobotAI extends Routine implements IRobotAI
{
    protected RobotController robotController;

    public AbstractRobotAI(IRobot robot)
    {
        this.robot = robot;
    }

    @Override
    public IRobot getRobot()
    {
        return robot;
    }
}
