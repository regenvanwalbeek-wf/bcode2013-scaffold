package team004.routine.core.decorator;

import battlecode.common.GameActionException;
import team004.routine.core.IRoutine;

public class LimitedRepeater extends RoutineDecorator
{
    private int numRepetitions;

    public LimitedRepeater(IRoutine routine, int numRepetitions)
    {
        super(routine);
        this.numRepetitions = numRepetitions;
    }

    @Override
    protected boolean doRoutine() throws GameActionException
    {
        for (int repetitionIndex = 0; repetitionIndex < numRepetitions; repetitionIndex++)
        {
            routine.run(robot);
        }
        return true;
    }
}
