package team004.routine.hq;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import team004.robot.IRobot;

public interface IHQ extends IRobot
{
    void spawn(Direction direction) throws GameActionException;
}
