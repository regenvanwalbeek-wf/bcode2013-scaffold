package team029.ai.factory;

import battlecode.common.RobotController;
import team029.ai.IRobotAI;
import team029.routine.IRoutine;

public interface IRobotAIFactory
{
    /**
     * Creates the AI for a Robot based on the robot's controller
     * @param robotController
     *      The robot's controller
     * @return
     *      The robot's AI
     */
    IRobotAI createAI(RobotController robotController);
}
