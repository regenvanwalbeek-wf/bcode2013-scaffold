package team004.ai.factory;

import battlecode.common.RobotController;
import team004.ai.IRobotAI;

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
