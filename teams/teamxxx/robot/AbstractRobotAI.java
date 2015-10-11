package teamxxx.robot;

import battlecode.common.RobotController;

public abstract class AbstractRobotAI implements IRobotAI
{
    protected RobotController robotController;

    public AbstractRobotAI(RobotController robotController)
    {
        this.robotController = robotController;
    }
}
