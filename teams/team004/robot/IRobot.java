package team004.robot;

import battlecode.common.*;

/**
 * Interface that allows passing around of data between different pieces of the AI and for convenient caching
 * on the robot. It might be a waste...
 */
public interface IRobot extends IMineSensor, IMover
{
    //////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Convenience functions - because robot.getController().doSomething() is too hard to type
    //
    //////////////////////////////////////////////////////////////////////////////////////////////

    void yield();

    boolean canMove(Direction direction);

    boolean isActive();

    //////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Caching optimizations - so I don't waste bytecode on things that don't change.
    // Also for convenience. Cause I'm lazy.
    //
    //////////////////////////////////////////////////////////////////////////////////////////////

    Team getTeam();

    MapLocation getEnemyHQLocation();

    MapLocation getFriendlyHQLocation();

    MapLocation getLocation();

    MapLocation getPreviousLocation();

    //////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Helper functions with minor logic
    //
    //////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Tries to detect an enemy mine or neutral mine. Reminder: Can return a false negative! If an
     * enemy mine lies waiting on an untraveled square, then this will incorrectly return false.
     */
    boolean hasDangerousMine(MapLocation location) throws GameActionException;
}
