package team004.ai.factory;

import battlecode.common.RobotController;
import team004.ai.ArtilleryAI;
import team004.ai.HeadquartersAI;
import team004.ai.IRobotAI;
import team004.ai.SoldierAI;
import team004.robot.artillery.Artillery;
import team004.robot.hq.HQ;
import team004.robot.soldier.Soldier;

public class AIFactory implements IRobotAIFactory
{
    @Override
    public IRobotAI createAI(RobotController robotController)
    {
        IRobotAI routine = null;
        switch (robotController.getType())
        {
            case HQ:
                routine = new HeadquartersAI(new HQ(robotController));
                break;
            case SOLDIER:
                routine = new SoldierAI(new Soldier(robotController));
                break;
            case ARTILLERY:
                routine = new ArtilleryAI(new Artillery(robotController));
                break;
        }
        return routine;
    }
}
