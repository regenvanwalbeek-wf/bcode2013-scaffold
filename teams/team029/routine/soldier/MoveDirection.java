package team029.routine.soldier;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import team029.robot.soldier.ISoldier;

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
        ISoldier soldier = getSoldier();
        if (!soldier.canMove(direction))
            return false;

        soldier.move(direction);
        return true;
    }
}
