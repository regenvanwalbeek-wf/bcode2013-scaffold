package team029.routine.soldier;

import battlecode.common.GameActionException;
import battlecode.common.GameConstants;
import battlecode.common.MapLocation;
import team029.routine.IRoutine;
import team029.routine.behaviors.ILocationTargeting;
import team029.routine.decorator.LimitedRepeater;
import team029.routine.leaf.Yield;

/**
 * Responsibility: Defuse a mine with a robot at an adjacent target location
 */
public class Defuse extends SoldierRoutine
{
    private ILocationTargeting targeting;

    public Defuse(ILocationTargeting targeting)
    {
        this.targeting = targeting;
    }

    @Override
    public boolean doRoutine() throws GameActionException
    {
        MapLocation targetLocation = targeting.getTargetLocation(getSoldier());
        getSoldier().defuseMine(targetLocation);

        return true;
    }
}
