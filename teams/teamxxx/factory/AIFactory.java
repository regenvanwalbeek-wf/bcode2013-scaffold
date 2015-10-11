package teamxxx.factory;

import battlecode.common.RobotController;
import teamxxx.robot.ArtilleryAI;
import teamxxx.robot.HeadquartersAI;
import teamxxx.robot.IRobotAI;
import teamxxx.robot.SoldierAI;

public class AIFactory implements IRobotAIFactory
{
    @Override
    public IRobotAI createAI(RobotController robotController)
    {
        IRobotAI routine = null;
        switch (robotController.getType())
        {
            case HQ:
                routine = new HeadquartersAI(robotController);
                break;
            case SOLDIER:
                routine = new SoldierAI(robotController);
                break;
            case ARTILLERY:
                routine = new ArtilleryAI(robotController);
                break;
        }
        return routine;
    }
}
