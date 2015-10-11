package team004.routine.soldier;

import battlecode.common.Direction;
import battlecode.common.GameActionException;

public class MoveDirection extends SoldierRoutine
{
    private Direction direction;

    public MoveDirection(Direction direction)
    {
        this.direction = direction;
    }

    @Override
    protected boolean doRoutine() throws GameActionException
    {
        if (!soldier.canMove(direction))
            return false;

        soldier.setTargetMovementDirection(direction);
        soldier.move();
        return true;
    }
}
