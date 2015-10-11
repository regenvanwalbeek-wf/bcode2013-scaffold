package team004.routine;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import team004.routine.core.composite.Sequence;
import team004.routine.core.IRoutine;
import team004.routine.core.Routine;
import team004.routine.core.decorator.Inverter;
import team004.routine.core.decorator.RepeatUntilFail;
import team004.routine.robot.Yield;


public class YieldUntilCanMove extends Routine
{
    IRoutine routine;

    public YieldUntilCanMove(Direction targetDirection)
    {
        Sequence sequence = new Sequence();
        sequence.pushRoutine(new Inverter(new CanMove(targetDirection)));
        sequence.pushRoutine(new Yield());
        routine = new RepeatUntilFail(sequence);
    }

    @Override
    protected boolean doRoutine() throws GameActionException
    {
        return routine.run(robot);
    }
}
