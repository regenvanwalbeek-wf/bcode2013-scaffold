package team004.routine;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import team004.routine.soldier.SoldierRoutine;

// TODO SoldierRoutine is stupid as hell. 1 year ago you was dumb. Deprecate that shiz
public class CanMove extends SoldierRoutine
{
    private Direction targetDirection;

    public CanMove(Direction targetDirection)
    {
        this.targetDirection = targetDirection;
    }

    @Override
    protected boolean doRoutine() throws GameActionException
    {
        return getSoldier().canMove(targetDirection);
    }
}
