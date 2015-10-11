package team029.robot;

import battlecode.common.MapLocation;
import battlecode.common.RobotController;
import battlecode.common.Team;

public abstract class AbstractRobot implements IRobot
{
    protected final RobotController robotController;

    protected Team team = null;

    protected MapLocation enemyHQLocation = null;

    protected MapLocation friendlyHQLocation = null;

    public AbstractRobot(RobotController robotController)
    {
        this.robotController = robotController;
    }

    @Override
    public Team getTeam()
    {
        if (team == null)
            team = robotController.getTeam();

        return team;
    }

    @Override
    public RobotController getRobotController()
    {
        return robotController;
    }

    @Override
    public void yield()
    {
        robotController.yield();
    }

    @Override
    public Team senseMine(MapLocation location)
    {
        return robotController.senseMine(location);
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
}
