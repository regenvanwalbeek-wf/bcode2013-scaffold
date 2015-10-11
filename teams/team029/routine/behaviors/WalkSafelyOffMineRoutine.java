package team029.routine.behaviors;

import battlecode.common.GameConstants;
import battlecode.common.MapLocation;
import team029.robot.soldier.ISoldier;
import team029.routine.IRoutine;
import team029.routine.composite.Sequence;
import team029.routine.decorator.LimitedRepeater;
import team029.routine.leaf.Yield;
import team029.routine.soldier.Defuse;
import team029.routine.soldier.MoveToPreviousLocation;
import team029.routine.soldier.WanderCardinally;
import team029.routine.soldier.IsOnTopOfNonFriendlyMine;

public class WalkSafelyOffMineRoutine extends Sequence
{
    public WalkSafelyOffMineRoutine()
    {
        pushRoutine(new IsOnTopOfNonFriendlyMine());
        pushRoutine(new MoveToPreviousLocation());
//        pushRoutine(new WanderCardinally());
        pushRoutine(new Yield());

        pushRoutine(new Defuse(new PreviousLocationTargeting()));
        pushRoutine(new LimitedRepeater(new Yield(), GameConstants.MINE_DEFUSE_DELAY)); // TODO query this somewhere);

    }
}

class PreviousLocationTargeting implements ILocationTargeting
{
    @Override
    public MapLocation getTargetLocation(ISoldier robot)
    {
        return robot.getPreviousLocation();
    }
}
