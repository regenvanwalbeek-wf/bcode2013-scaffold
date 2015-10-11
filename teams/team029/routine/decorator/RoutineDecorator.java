package team029.routine.decorator;

import team029.routine.IRoutine;
import team029.routine.Routine;

public abstract class RoutineDecorator extends Routine
{
    protected IRoutine routine;

    public RoutineDecorator(IRoutine routine)
    {
        this.routine = routine;
    }

}
