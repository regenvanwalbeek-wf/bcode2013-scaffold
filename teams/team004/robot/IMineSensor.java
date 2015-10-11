package team004.robot;

import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.Team;

public interface IMineSensor {
    void setMineSensingTargetLocation(MapLocation targetLocation);
    Team senseMine() throws GameActionException;
}
