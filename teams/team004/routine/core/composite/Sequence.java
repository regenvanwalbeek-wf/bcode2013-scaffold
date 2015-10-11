package team004.routine.core.composite;

import battlecode.common.GameActionException;
import team004.routine.core.IRoutine;

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
