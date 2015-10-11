package team029.routine.decorator;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import team029.routine.IRoutine;

public class Inverter extends RoutineDecorator
{
    public Inverter(IRoutine routine)
    {
        super(routine);
    }

    @Override
    protected boolean doRoutine() throws GameActionException
    {
        return !routine.run(robot);
    }
}
