package team029;

import battlecode.common.RobotController;
import team029.ai.factory.AIFactory;
import team029.ai.factory.IRobotAIFactory;
import team029.routine.IRoutine;
import team029.routine.decorator.Repeater;

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
