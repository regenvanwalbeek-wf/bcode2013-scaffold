package team004.routine.behaviors;

import battlecode.common.Direction;
import battlecode.common.GameConstants;
import team004.routine.core.composite.Sequence;
import team004.routine.core.decorator.LimitedRepeater;
import team004.routine.robot.Yield;
import team004.routine.soldier.IsOnTopOfDangerousMine;
import team004.routine.soldier.MoveToPreviousLocation;
import team004.routine.soldier.defuse.Defuse;
import team004.routine.soldier.defuse.SetDefuseTarget;

public class WalkSafelyOffMineRoutine extends Sequence
{
    public WalkSafelyOffMineRoutine()
    {
        pushRoutine(new IsOnTopOfDangerousMine());
        pushRoutine(new SetDefuseTarget(Direction.NONE));
        pushRoutine(new MoveToPreviousLocation());
        pushRoutine(new Yield());

        pushRoutine(new Defuse());
        pushRoutine(new LimitedRepeater(new Yield(), GameConstants.MINE_DEFUSE_DELAY));

    }
}
