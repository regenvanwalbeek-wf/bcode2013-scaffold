package team004.routine.robot;

import battlecode.common.GameActionException;
import team004.routine.core.Routine;

/**
 * A routine that forces the robot to end its turn.
 */
public class Yield extends Routine
{
    @Override
    protected boolean doRoutine() throws GameActionException
    {
        robot.yield();
        return true;
    }
}
