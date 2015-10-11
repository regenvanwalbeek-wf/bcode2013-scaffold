package team029.robot;

import battlecode.common.MapLocation;
import battlecode.common.RobotController;
import battlecode.common.Team;

public interface IRobot
{
    RobotController getRobotController();

    void yield();

    Team getTeam();

    Team senseMine(MapLocation location);

    MapLocation getEnemyHQLocation();

    MapLocation getFriendlyHQLocation();
}
