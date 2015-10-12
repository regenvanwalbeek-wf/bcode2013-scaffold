package teamxxx.robot;

import battlecode.common.GameActionException;

public interface IRobotAI
{
    /**
     * Runs the robot AI
     * @return True if the AI successfully found something to do. False otherwise.
     */
    boolean run() throws GameActionException;

}
