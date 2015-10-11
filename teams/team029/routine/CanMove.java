package team029.routine;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import team029.routine.soldier.SoldierRoutine;

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
