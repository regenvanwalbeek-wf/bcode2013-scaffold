package team004.robot.soldier;

import battlecode.common.GameActionException;
import battlecode.common.MapLocation;

public interface IDefuser
{
    void setDefuseTargetLocation(MapLocation target);

    void defuseMine() throws GameActionException;
}
