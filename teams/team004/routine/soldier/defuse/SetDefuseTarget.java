package team004.routine.soldier.defuse;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import team004.routine.soldier.SoldierRoutine;

public class SetDefuseTarget extends SoldierRoutine
{
    private Direction direction;

    public SetDefuseTarget(Direction direction)
    {
        this.direction = direction;
    }

    @Override
    protected boolean doRoutine() throws GameActionException
    {
        MapLocation defuseTargetLocation = soldier.getLocation().add(direction);

        soldier.setDefuseTargetLocation(defuseTargetLocation);
        return true;
    }
}
