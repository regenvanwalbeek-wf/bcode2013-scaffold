package team004;

import battlecode.common.RobotController;
import team004.ai.factory.AIFactory;
import team004.ai.factory.IRobotAIFactory;
import team004.routine.core.IRoutine;
import team004.routine.core.decorator.Repeater;

/**
 * The ultimate robot. Its skill is unrivaled.
 */
public class RobotPlayer
{
    public static void run(RobotController rc)
    {
        IRobotAIFactory aiFactory = new AIFactory();
        IRoutine robotAI = aiFactory.createAI(rc);
        Repeater repeatedRobotAI = new Repeater(robotAI);

        repeatedRobotAI.run(robotAI.getRobot());
    }
}
