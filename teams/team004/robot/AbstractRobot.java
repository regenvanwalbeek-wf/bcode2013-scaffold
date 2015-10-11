package team004.robot;

import battlecode.common.*;

public abstract class AbstractRobot implements IRobot
{
    protected final RobotController robotController;

    protected Team team = null;
    protected MapLocation enemyHQLocation = null;
    protected MapLocation friendlyHQLocation = null;

    protected MapLocation location = null;
    protected Boolean locationDirty = true;
    protected MapLocation previousLocation;

    public AbstractRobot(RobotController robotController)
    {
        this.robotController = robotController;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Convenience functions
    //
    //////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void yield()
    {
        robotController.yield();
    }

    @Override
    public boolean canMove(Direction direction)
    {
        return robotController.canMove(direction);
    }

    @Override
    public boolean isActive()
    {
        return robotController.isActive();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Caching optimizations
    //
    //////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public Team getTeam() {
        if (team == null)
            team = robotController.getTeam();

        return team;
    }

    @Override
    public MapLocation getEnemyHQLocation()
    {
        if (enemyHQLocation == null)
            enemyHQLocation = robotController.senseEnemyHQLocation();

        return enemyHQLocation;
    }

    @Override
    public MapLocation getFriendlyHQLocation()
    {
        if (friendlyHQLocation == null)
            friendlyHQLocation = robotController.senseHQLocation();

        return friendlyHQLocation;
    }

    @Override
    public MapLocation getLocation() {
        if (locationDirty)
        {
            location = this.robotController.getLocation();
            locationDirty = false;
        }

        return location;
    }

    public MapLocation getPreviousLocation()
    {
        return previousLocation;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    //
    // Helper functions
    //
    //////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public boolean hasDangerousMine(MapLocation location) throws GameActionException
    {
        setMineSensingTargetLocation(location);
        Team mineTeam = senseMine();
        if (mineTeam == null || mineTeam == team)
            return false;

        return true;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    //
    // IMineSensor
    //
    //////////////////////////////////////////////////////////////////////////////////////////////
    private MapLocation mineSensingTargetLocation;

    @Override
    public void setMineSensingTargetLocation(MapLocation targetLocation)
    {
        mineSensingTargetLocation = targetLocation;
    }

    @Override
    public Team senseMine() throws GameActionException
    {
        if (mineSensingTargetLocation == null)
            throw new GameActionException(GameActionExceptionType.CANT_DO_THAT_BRO, "Call setMineSensingTargetLocation first");

        Team team = robotController.senseMine(location);
        mineSensingTargetLocation = null;
        return team;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    //
    // IMover
    //
    //////////////////////////////////////////////////////////////////////////////////////////////
    public Direction targetMoveDirection;

    @Override
    public void setTargetMovementDirection(Direction target)
    {
        targetMoveDirection = target;
    }

    public void move() throws GameActionException
    {
        if (targetMoveDirection == null)
            throw new GameActionException(GameActionExceptionType.CANT_DO_THAT_BRO, "Call setTargetMovementDirection first");

        previousLocation = getLocation();
        robotController.move(targetMoveDirection);
        targetMoveDirection = null;
        locationDirty = true;
    }
}
