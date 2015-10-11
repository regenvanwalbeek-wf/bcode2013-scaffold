package team004.routine.core.decorator;

import battlecode.common.GameActionException;
import team004.routine.core.IRoutine;

/**
 * A succeeder always returns successfully, regardless of whether the decorated Routine runs successfully.
 */
public class Succeeder extends RoutineDecorator
{

    public Succeeder(IRoutine routine)
    {
        super(routine);
    }

    @Override
    protected boolean doRoutine() throws GameActionException
    {
        routine.run(robot);
        return true;
    }
}
