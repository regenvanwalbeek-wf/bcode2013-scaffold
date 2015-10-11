package team029.routine.behaviors;

import battlecode.common.MapLocation;
import team029.robot.soldier.ISoldier;
import team029.routine.IRoutine;

public interface ILocationTargeting
{
    MapLocation getTargetLocation(ISoldier robot);
}
