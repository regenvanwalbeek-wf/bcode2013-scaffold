package team029.routine.decorator;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import team029.routine.IRoutine;

/**
 * Repeats a routine until the routine fails. A RepeatUntilFail routine always returns successfully
 */
public class RepeatUntilFail extends RoutineDecorator
{
    public RepeatUntilFail(IRoutine routine)
    {
        super(routine);
    }

    @Override
    protected boolean doRoutine() throws GameActionException
    {
        boolean routineSuccessful = true;
        while (routineSuccessful)
        {
            routineSuccessful = routine.run(robot);
        }
        return true;
    }
}
