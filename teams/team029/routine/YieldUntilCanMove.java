package team029.routine;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import team029.routine.composite.Sequence;
import team029.routine.decorator.Inverter;
import team029.routine.decorator.RepeatUntilFail;
import team029.routine.decorator.Repeater;
import team029.routine.leaf.Yield;


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
