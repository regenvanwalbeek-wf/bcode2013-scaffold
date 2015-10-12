package teamxxx.robot;

import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;
import battlecode.common.Team;

public abstract class AbstractRobotAI implements IRobotAI
{
    protected RobotController robotController;

    public AbstractRobotAI(RobotController robotController)
    {
        this.robotController = robotController;
    }

    ////////////////////////////////////////
    //
    // Convenience functions
    //
    ////////////////////////////////////////

    public boolean hasMine(MapLocation location) throws GameActionException
    {
        return (robotController.senseMine(location) == null);
    }

    public boolean hasDangerousMine(MapLocation location) throws GameActionException
    {
        Team mineTeam = robotController.senseMine(location);

        if (mineTeam == null || mineTeam == getTeam())
            return false;

        return true;
    }

    public void yield(int numTurnsToYield)
    {
        for (int turnsYielded = 0; turnsYielded < numTurnsToYield; turnsYielded++)
            robotController.yield();
    }

    ////////////////////////////////////////
    //
    // Caches
    //
    ////////////////////////////////////////

    private Team cachedTeam;
    protected Team getTeam()
    {
        if (cachedTeam == null)
            cachedTeam = robotController.getTeam();

        return cachedTeam;
    }

    private MapLocation cachedEnemyHQLocation;
    protected MapLocation getEnemyHQLocation()
    {
        if (cachedEnemyHQLocation == null)
            cachedEnemyHQLocation = robotController.senseEnemyHQLocation();

        return cachedEnemyHQLocation;
    }
}
