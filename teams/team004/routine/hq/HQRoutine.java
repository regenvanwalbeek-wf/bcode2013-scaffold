package team004.routine.hq;

import team004.robot.IRobot;
import team004.robot.hq.HQ;
import team004.routine.core.Routine;

public abstract class HQRoutine extends Routine
{
    protected HQ hq;

    @Override
    protected void setRobot(IRobot robot) {
        super.setRobot(robot);
        hq = (HQ) robot;
    }
}
