package team004.routine.core.composite;

import battlecode.common.GameActionException;
import team004.routine.core.IRoutine;

/**
 * A behavior tree selector - Runs a set of routines and returns false if none complete successfully.
 */
public class Selector extends CompositeRoutine
{
    @Override
    protected final boolean doRoutine() throws GameActionException
    {
        for (IRoutine routine : routines)
        {
            boolean routineSuccessful = routine.run(robot);
            if (routineSuccessful)
                return true;
        }

        return false;
    }

}
