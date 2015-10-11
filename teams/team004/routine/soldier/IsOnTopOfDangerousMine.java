package team004.routine.soldier;

import battlecode.common.GameActionException;
import battlecode.common.Team;

public class IsOnTopOfDangerousMine extends SoldierRoutine
{
    @Override
    protected boolean doRoutine() throws GameActionException
    {;
        robot.setMineSensingTargetLocation(soldier.getLocation());
        Team mineTeam = robot.senseMine();

        if (mineTeam == null)
            return false;

        Team robotTeam = robot.getTeam();

        if (mineTeam == robotTeam)
            return false;
        else
            return true;
    }
}
