package team029.ai;

import battlecode.common.RobotController;
import team029.robot.IRobot;
import team029.routine.IRoutine;

public interface IRobotAI extends IRoutine
{
    /**
     * Gets the controller the robot uses to interact with the game world
     */
    IRobot getRobot();

}
