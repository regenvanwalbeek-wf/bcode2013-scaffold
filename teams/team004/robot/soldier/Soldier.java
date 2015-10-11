package team004.robot.soldier;

import battlecode.common.GameActionException;
import battlecode.common.GameActionExceptionType;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;
import team004.robot.AbstractRobot;
import team004.robot.ISoldier;

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
     * Where the soldier wants to go
     */
    public MapLocation defuseTargetLocation;

    @Override
    public void setDefuseTargetLocation(MapLocation target) {
        this.defuseTargetLocation = target;
    }

    @Override
    public void defuseMine() throws GameActionException
    {
        if (defuseTargetLocation == null)
            throw new GameActionException(GameActionExceptionType.CANT_DO_THAT_BRO, "You need to set a target location before defusing");

        robotController.defuseMine(defuseTargetLocation);
        defuseTargetLocation = null;
    }

}
