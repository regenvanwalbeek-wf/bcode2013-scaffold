package team029.robot.soldier;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;
import team029.robot.AbstractRobot;

import java.util.Random;

public class Soldier extends AbstractRobot implements ISoldier
{
    public Soldier(RobotController robotController)
    {
        super(robotController);
        this.id = robotController.getRobot().getID();
        this.random = new Random(id);
    }

    /**
     * ID
     */
    private final int id;

    @Override
    public int getId()
    {
        return id;
    }

    /**
     * Random
     */
    private final Random random;

    @Override
    public Random getRandom()
    {
        return random;
    }

    /**
     * Location
     */
    private MapLocation location = null;

    private Boolean locationDirty = true;

    @Override
    public MapLocation getLocation()
    {
        if (locationDirty)
        {
            location = this.robotController.getLocation();
            locationDirty = false;
        }

        return location;
    }

    private MapLocation previousLocation;

    @Override
    public MapLocation getPreviousLocation()
    {
        return previousLocation;
    }

    /**
     * canMove
     */
    @Override
    public boolean canMove(Direction direction)
    {
        return robotController.canMove(direction);
    }

    /**
     * Move
     */
    @Override
     public void move(Direction direction) throws GameActionException
     {
         previousLocation = getLocation();
         robotController.move(direction);
         locationDirty = true;
     }

    @Override
    public void defuseMine(MapLocation targetLocation) throws GameActionException
    {
        robotController.defuseMine(targetLocation);
    }
}
