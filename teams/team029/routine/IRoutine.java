package team029.routine;

import team029.robot.IRobot;

public interface IRoutine
{
    IRobot getRobot();

    /**
     * Runs a routine for a behavior tree
     * @param robot
     *      The robot used to interact with the game world and get cached data
     * @return
     *      Returns if the routine completed successfully
     */
    boolean run(IRobot robot);
}