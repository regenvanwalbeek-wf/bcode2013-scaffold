package team004.robot;

import battlecode.common.Direction;
import battlecode.common.GameActionException;

public interface IMover {
    void setTargetMovementDirection(Direction target);

    void move() throws GameActionException;
}
