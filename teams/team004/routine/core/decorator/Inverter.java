package team004.routine.core.decorator;

import battlecode.common.GameActionException;
import team004.routine.core.IRoutine;

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
