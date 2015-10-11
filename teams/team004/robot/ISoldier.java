package team004.robot;

import battlecode.common.Direction;
import team004.robot.soldier.IDefuser;

import java.util.Random;

public interface ISoldier extends IRobot, IDefuser
{
    int getId();

    // Random functionality
    Random getRandom();

    boolean canMove(Direction direction);
}
