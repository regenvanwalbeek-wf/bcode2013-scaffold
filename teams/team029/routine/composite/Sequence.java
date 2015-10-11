package team029.routine.composite;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import team029.routine.IRoutine;

/**
 * A behavior tree sequence - Runs a set of routines and returns true if they all complete successfully
 */
public class Sequence extends CompositeRoutine
{
    @Override
    protected final boolean doRoutine() throws GameActionException
    {
        for (IRoutine routine : routines)
        {
            boolean routineSuccessful = routine.run(robot);

            if (!routineSuccessful)
                return false;
        }
        return true;
    }
}
