package team004.ai;

import battlecode.common.GameActionException;
import team004.robot.IRobot;
import team004.routine.core.IRoutine;
import team004.routine.core.composite.CompositeRoutine;
import team004.routine.core.composite.Selector;
import team004.routine.core.composite.Sequence;
import team004.routine.hq.SpawnRobotAtValidPosition;
import team004.routine.robot.Yield;

public class HeadquartersAI extends AbstractRobotAI
{
    public HeadquartersAI(IRobot robot)
    {
        super(robot);
    }

    @Override
    protected boolean doRoutine() throws GameActionException
    {
        Selector yieldIfNothingWorks = new Selector();
        yieldIfNothingWorks.pushRoutine(getSpawnRoutine());
        yieldIfNothingWorks.pushRoutine(new Yield());
        return yieldIfNothingWorks.run(robot);
    }

    private IRoutine getSpawnRoutine()
    {
        CompositeRoutine sequence = new Sequence();
        sequence.pushRoutine(new SpawnRobotAtValidPosition());
        sequence.pushRoutine(new Yield());
        return sequence;
    }
}
