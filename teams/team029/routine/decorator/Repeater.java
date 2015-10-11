package team029.routine.decorator;

import battlecode.common.GameActionException;
import team029.routine.IRoutine;

/**
 * Repeatedly runs a routine in an infinite loop (even if the routine fails)
 */
public class Repeater extends RoutineDecorator
{
    public Repeater(IRoutine routine)
    {
        super(routine);
    }

    @Override
    protected boolean doRoutine() throws GameActionException
    {
        while (true)
        {
            routine.run(robot);
        }
    }
}
