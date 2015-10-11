package team029.routine.composite;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import team029.routine.IRoutine;

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
