package team004.routine.core.composite;

import battlecode.common.GameActionException;
import team004.routine.core.IRoutine;
import team004.routine.core.Routine;

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
