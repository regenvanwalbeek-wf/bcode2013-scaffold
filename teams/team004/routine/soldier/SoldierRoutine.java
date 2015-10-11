package team004.routine.soldier;

import team004.robot.IRobot;
import team004.robot.ISoldier;
import team004.robot.soldier.Soldier;
import team004.routine.core.Routine;

public abstract class SoldierRoutine extends Routine
{
    @Deprecated // TODO fix this like HQAI
    public ISoldier getSoldier()
    {
        return (ISoldier) robot;
    }

    protected Soldier soldier;

    @Override
    protected void setRobot(IRobot robot) {
        super.setRobot(robot);
        soldier = (Soldier) robot;
    }

}
