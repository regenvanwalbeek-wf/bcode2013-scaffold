package team004.ai;

import team004.robot.IRobot;
import team004.routine.core.IRoutine;

public interface IRobotAI extends IRoutine
{
    /**
     * Gets the controller the robot uses to interact with the game world
     */
    IRobot getRobot();

}
