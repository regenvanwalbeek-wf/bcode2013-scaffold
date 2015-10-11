package team029.routine.leaf;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import team029.routine.Routine;
// TODO not really sure if this should be a routine or built into routines, or maybe even a decorator?
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
