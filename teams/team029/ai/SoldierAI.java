package team029.ai;

import battlecode.common.*;
import team029.robot.IRobot;
import team029.routine.IRoutine;

import team029.routine.behaviors.WalkSafelyOffMineRoutine;
import team029.routine.composite.Selector;
import team029.routine.composite.Sequence;
import team029.routine.leaf.Yield;
import team029.routine.soldier.MoveToward;

public class SoldierAI extends AbstractRobotAI
{
    public SoldierAI(IRobot robot)
    {
        super(robot);
    }

    private IRoutine rushEnemyHQAndDiffuseMinesAlongTheWayRoutine()
    {
        Sequence sequence = new Sequence();
        sequence.pushRoutine(new MoveToward(robot.getEnemyHQLocation()));
        sequence.pushRoutine(new Yield());
        sequence.pushRoutine(new WalkSafelyOffMineRoutine());

        return sequence;
    }

    @Override
    protected boolean doRoutine() throws GameActionException
    {
        Selector masterSelector = new Selector();
        masterSelector.pushRoutine(rushEnemyHQAndDiffuseMinesAlongTheWayRoutine());
        masterSelector.pushRoutine(new Yield());
        return masterSelector.run(robot);
    }
}
