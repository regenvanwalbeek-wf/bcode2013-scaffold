package team029.robot.soldier;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import team029.robot.IRobot;

import java.util.Random;

public interface ISoldier extends IRobot
{
    int getId();

    // Random functionality
    Random getRandom();

    // Location functionality
    MapLocation getLocation();

    boolean canMove(Direction direction);

    void move(Direction direction) throws GameActionException;

    MapLocation getPreviousLocation();

    void defuseMine(MapLocation mapLocation) throws  GameActionException;
}
