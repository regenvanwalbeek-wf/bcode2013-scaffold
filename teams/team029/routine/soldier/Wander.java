package team029.routine.soldier;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import team029.DirectionUtil;
import team029.robot.soldier.ISoldier;
import team029.routine.IRoutine;
import team029.routine.Routine;
import team029.routine.soldier.MoveDirection;

public class Wander extends SoldierRoutine
{
    @Override
    protected boolean doRoutine() throws GameActionException
    {
        ISoldier soldier = getSoldier();
        Direction direction = DirectionUtil.getRandomMovableDirection(soldier.getRandom());
        IRoutine moveDirectionRoutine = new MoveDirection(direction);
        return moveDirectionRoutine.run(robot);
    }
}
