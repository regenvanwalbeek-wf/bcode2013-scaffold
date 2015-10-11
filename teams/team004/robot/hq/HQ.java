package team004.robot.hq;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import team004.robot.AbstractRobot;
import team004.routine.hq.IHQ;

public class HQ extends AbstractRobot implements IHQ
{
    public HQ(RobotController robotController)
    {
        super(robotController);
    }


    @Override
    public void spawn(Direction direction) throws GameActionException {
        robotController.spawn(direction);
    }
}
