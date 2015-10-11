package team004.routine.core.decorator;

import team004.routine.core.IRoutine;
import team004.routine.core.Routine;

public abstract class RoutineDecorator extends Routine
{
    protected IRoutine routine;

    public RoutineDecorator(IRoutine routine)
    {
        this.routine = routine;
    }

}
