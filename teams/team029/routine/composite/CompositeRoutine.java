package team029.routine.composite;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;
import team029.routine.IRoutine;
import team029.routine.Routine;

import java.util.ArrayList;

public abstract class CompositeRoutine extends Routine
{
    protected ArrayList<IRoutine> routines;

    public CompositeRoutine()
    {
        routines = new ArrayList<IRoutine>();
    }

    public void pushRoutine(IRoutine routine)
    {
        routines.add(routine);
    }

    @Override
    abstract protected boolean doRoutine() throws GameActionException;
}
