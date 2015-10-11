package swarm.common;

import battlecode.common.Clock;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;

public class Radio {
    public static final int ENEMY = 0;
    public static final int CANARY = 1;
    public static final int OUTPOST = 2;
    public static final int MEDBAY = 3;
    public static final int NUM_SOLDIERS = 4;
    public static final int NUM_ENCAMPMENTS = 5;
    public static final int STRATEGY = 6;

    private static int getBroadcastChannel(int purpose, int roundNum) {
        int channel;
        switch(purpose) {
            case Radio.ENEMY: channel = 44345; break;
            case Radio.CANARY: channel = 44376; break;
            case Radio.OUTPOST: channel = 44388; break;
            case Radio.MEDBAY: channel = 44399; break;
            case Radio.NUM_SOLDIERS: channel = 44403; break;
            case Radio.NUM_ENCAMPMENTS: channel = 44407; break;
            case Radio.STRATEGY: channel = 44410; break;
            default: channel = 44421;
        }
        return (channel * roundNum) % 65535;
    }

    private static void send(RobotController rc, int channel, int message) throws GameActionException {
        int roundNum = Clock.getRoundNum();
        rc.broadcast(Radio.getBroadcastChannel(channel, roundNum), message);
        rc.broadcast(Radio.getBroadcastChannel(channel, roundNum + 1), message);
    }

    public static void updateData(RobotController rc, int channel, int data) throws GameActionException {
        int currentData = Radio.readData(rc, channel);
        Radio.send(rc, channel, currentData + data);
    }

    public static int readOldData(RobotController rc, int channel) throws GameActionException {
        return rc.readBroadcast(Radio.getBroadcastChannel(channel, Clock.getRoundNum() - 1));
    }

    public static int readData(RobotController rc, int channel) throws GameActionException {
        return rc.readBroadcast(Radio.getBroadcastChannel(channel, Clock.getRoundNum()));
    }

    public static void writeData(RobotController rc, int channel, int data) throws GameActionException {
        Radio.send(rc, channel, data);
    }

    public static boolean readStatus(RobotController rc, int channel) throws GameActionException {
        int status = rc.readBroadcast(Radio.getBroadcastChannel(channel, Clock.getRoundNum()));
        return status == 1;
    }

    public static void writeStatus(RobotController rc, int channel, boolean status) throws GameActionException {
        int message = status ? 1 : 0;
        Radio.send(rc, channel, message);
    }

    public static void writeLocation(RobotController rc, int channel, MapLocation loc) throws GameActionException {
        int x = ((loc.x << 8) & 0xFF00);
        int y = loc.y & 0x00FF;
        int encodedLocation = x | y;
        Radio.send(rc, channel, encodedLocation);
    }

    public static void writeOldLocation(RobotController rc, int channel, MapLocation loc, int numRoundsOld) throws GameActionException {
        int x = ((loc.x << 8) & 0xFF00);
        int y = loc.y & 0x00FF;
        int encodedLocation = x | y;
        int roundNum = Clock.getRoundNum();

        rc.broadcast(Radio.getBroadcastChannel(channel, roundNum - numRoundsOld), encodedLocation);
    }

    public static MapLocation readLocation(RobotController rc, int channel) throws GameActionException {
        int message = rc.readBroadcast(Radio.getBroadcastChannel(channel, Clock.getRoundNum()));
        if (message == 0) {
            return null;
        }
        int x = (message & 0xFF00) >> 8;
        int y = message & 0x00FF;
        return new MapLocation(x, y);
    }
}
