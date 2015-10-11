package team029.routine.soldier;

import team029.robot.soldier.ISoldier;
import team029.routine.Routine;

public abstract class SoldierRoutine extends Routine implements ISoldierRoutine
{
    @Override
    public ISoldier getSoldier()
    {
        return (ISoldier) robot;
    }

}
