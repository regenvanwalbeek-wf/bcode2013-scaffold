package team029.routine;

import battlecode.common.GameActionException;
import team029.robot.IRobot;

public abstract class Routine implements IRoutine
{
    protected IRobot robot;

    @Override
    public IRobot getRobot()
    {
        return robot;
    }

    @Override
    public final boolean run(IRobot robot)
    {
        try
        {
            this.robot = robot;
            boolean routineSuccessful = doRoutine();
            return routineSuccessful;
        }
        catch (GameActionException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Executes a routine
     * @return
     *      If the routine was successful
     * @throws GameActionException
     *      If an exception occurred while interacting with the world
     */
    protected abstract boolean doRoutine() throws GameActionException;
}
