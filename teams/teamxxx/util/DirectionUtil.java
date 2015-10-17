package teamxxx.util;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;

import java.util.ArrayList;

public class DirectionUtil {

    public static ArrayList<Direction> getDirectionsCloserAndEquidistantToTarget(MapLocation fromLocation, MapLocation targetLocation) throws GameActionException {

        ArrayList<Direction> directions = new ArrayList<Direction>();

        if (targetLocation.x > fromLocation.x && targetLocation.y == fromLocation.y) { // Target East of current
            directions.add(Direction.EAST);
            directions.add(Direction.NORTH_EAST);
            directions.add(Direction.SOUTH_EAST);
        } else if (targetLocation.x > fromLocation.x && targetLocation.y > fromLocation.y){ // Target Southeast of current
            directions.add(Direction.SOUTH_EAST);
            directions.add(Direction.EAST);
            directions.add(Direction.SOUTH);
        } else if (targetLocation.x == fromLocation.x && targetLocation.y > fromLocation.y) { // Target South of current
            directions.add(Direction.SOUTH);
            directions.add(Direction.SOUTH_EAST);
            directions.add(Direction.SOUTH_WEST);
        } else if (targetLocation.x < fromLocation.x && targetLocation.y > fromLocation.y) { // Target Southwest of current
            directions.add(Direction.SOUTH_WEST);
            directions.add(Direction.SOUTH);
            directions.add(Direction.WEST);
        } else if (targetLocation.x < fromLocation.x && targetLocation.y == fromLocation.y) { // Target West of current
            directions.add(Direction.WEST);
            directions.add(Direction.SOUTH_WEST);
            directions.add(Direction.NORTH_WEST);
        } else if (targetLocation.x < fromLocation.x && targetLocation.y < fromLocation.y) { // Target Northwest of current
            directions.add(Direction.NORTH_WEST);
            directions.add(Direction.WEST);
            directions.add(Direction.NORTH);
        } else if (targetLocation.x == fromLocation.x && targetLocation.y < fromLocation.y) { // Target North of current
            directions.add(Direction.NORTH);
            directions.add(Direction.NORTH_WEST);
            directions.add(Direction.NORTH_EAST);
        } else if (targetLocation.x > fromLocation.x && targetLocation.y < fromLocation.y) { // Target Northeast of current
            directions.add(Direction.NORTH_EAST);
            directions.add(Direction.NORTH);
            directions.add(Direction.EAST);
        }
        
        return directions;
    }

}
