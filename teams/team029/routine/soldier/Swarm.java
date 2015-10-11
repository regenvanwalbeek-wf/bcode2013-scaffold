package team029.routine.soldier;

import battlecode.common.GameActionException;
import battlecode.common.MapLocation;

public class Swarm extends SoldierRoutine
{

    private MapLocation swarmLocation;

    public Swarm(MapLocation swarmLocation)
    {
        this.swarmLocation = swarmLocation;
    }


    @Override
    protected boolean doRoutine() throws GameActionException
    {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
