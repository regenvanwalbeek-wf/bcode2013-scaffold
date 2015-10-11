package team029.routine.decorator;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import team029.routine.IRoutine;

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
