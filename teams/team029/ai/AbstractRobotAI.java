package team029.ai;

import battlecode.common.GameActionException;
import battlecode.common.Robot;
import battlecode.common.RobotController;
import team029.robot.IRobot;
import team029.routine.Routine;

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
