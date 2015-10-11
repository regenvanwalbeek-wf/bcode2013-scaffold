package team004.routine.soldier.defuse;

import battlecode.common.GameActionException;
import battlecode.common.GameConstants;
import battlecode.common.MapLocation;
import team004.routine.core.decorator.LimitedRepeater;
import team004.routine.robot.Yield;
import team004.routine.soldier.SoldierRoutine;

public class ClearDangerousMinesOnLocationSequence extends SoldierRoutine {

    MapLocation location;

    public ClearDangerousMinesOnLocationSequence(MapLocation location)
    {
        this.location = location;
    }

    @Override
    protected boolean doRoutine() throws GameActionException {
        boolean dangerousMine = soldier.hasDangerousMine(location);
        if (!dangerousMine)
            return true;

        soldier.setDefuseTargetLocation(location);
        soldier.defuseMine();

        return new LimitedRepeater(new Yield(), GameConstants.MINE_DEFUSE_DELAY).run(soldier);
    }
}
