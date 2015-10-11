package team029.ai.factory;

import battlecode.common.RobotController;
import team029.ai.*;
import team029.robot.artillery.Artillery;
import team029.robot.hq.Headquarters;
import team029.robot.soldier.Soldier;
import team029.routine.IRoutine;
import team029.routine.decorator.Repeater;

public class AIFactory implements IRobotAIFactory
{
    @Override
    public IRobotAI createAI(RobotController robotController)
    {
        IRobotAI routine = null;
        switch (robotController.getType())
        {
            case HQ:
                routine = new HeadquartersAI(new Headquarters(robotController));
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
