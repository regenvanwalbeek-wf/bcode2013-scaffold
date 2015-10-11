package team004.routine.core;

import battlecode.common.GameActionException;
import team004.robot.IRobot;

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
            setRobot(robot);
            return doRoutine();
        }
        catch (GameActionException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    protected void setRobot(IRobot robot)
    {
        this.robot = robot;
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
