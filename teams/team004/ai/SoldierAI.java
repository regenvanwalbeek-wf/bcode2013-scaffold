package team004.ai;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import team004.robot.IRobot;
import team004.routine.behaviors.WalkSafelyOffMineRoutine;
import team004.routine.core.IRoutine;
import team004.routine.core.composite.Selector;
import team004.routine.core.composite.Sequence;
import team004.routine.robot.Yield;
import team004.routine.soldier.MoveToward;
import team004.routine.soldier.defuse.ClearDangerousMinesOnLocationSequence;

public class SoldierAI extends AbstractRobotAI
{
    public SoldierAI(IRobot robot)
    {
        super(robot);
    }

    private IRoutine rushEnemyHQAndDiffuseMinesAlongTheWayRoutine()
    {
        Direction targetDirection = robot.getLocation().directionTo(robot.getEnemyHQLocation());
        MapLocation targetLocation = robot.getLocation().add(targetDirection);
        Sequence sequence = new Sequence();
        sequence.pushRoutine(new ClearDangerousMinesOnLocationSequence(targetLocation));
        sequence.pushRoutine(new MoveToward(targetLocation));
        sequence.pushRoutine(new Yield());
        sequence.pushRoutine(new WalkSafelyOffMineRoutine()); // TODO this is kinda overkill now...well, not if there are enemy mines

        return sequence;
    }

    @Override
    protected boolean doRoutine() throws GameActionException
    {
        Selector yieldIfNothingWorks = new Selector();
        yieldIfNothingWorks.pushRoutine(rushEnemyHQAndDiffuseMinesAlongTheWayRoutine());
        yieldIfNothingWorks.pushRoutine(new Yield());
        return yieldIfNothingWorks.run(robot);
    }
}
