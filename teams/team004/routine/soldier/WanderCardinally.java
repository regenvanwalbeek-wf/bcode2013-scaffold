package team004.routine.soldier;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import team004.util.DirectionUtil;
import team004.robot.ISoldier;
import team004.routine.core.IRoutine;

public class WanderCardinally extends SoldierRoutine
{
    @Override
    protected boolean doRoutine() throws GameActionException
    {
        ISoldier soldier = getSoldier();
        Direction direction = DirectionUtil.getRandomCardinalDirection(soldier.getRandom());
        IRoutine moveDirectionRoutine = new MoveDirection(direction);
        return moveDirectionRoutine.run(soldier);
    }
}
