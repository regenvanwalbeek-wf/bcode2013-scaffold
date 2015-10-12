package teamxxx.util;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.GameActionExceptionType;

import java.util.Iterator;

// TODO make this smarter. If this passes in North, then iterate NE, NW, E, W, SW, SE, S...clever way?
public class DirectionIterator implements Iterator
{
    private static final Direction[] MOVABLE_DIRECTIONS =
            {
                    Direction.NORTH,
                    Direction.NORTH_EAST,
                    Direction.EAST,
                    Direction.SOUTH_EAST,
                    Direction.SOUTH,
                    Direction.SOUTH_WEST,
                    Direction.WEST,
                    Direction.NORTH_WEST
            };

    private final static int NUM_DIRECTIONS = MOVABLE_DIRECTIONS.length;

    private int directionIndex;

    public DirectionIterator(Direction startingDirection) throws GameActionException
    {
        directionIndex = indexOf(startingDirection);
    }

    @Override
    public boolean hasNext()
    {
        return directionIndex < MOVABLE_DIRECTIONS.length;
    }

    @Override
    public Object next()
    {
        Direction nextDirection = MOVABLE_DIRECTIONS[directionIndex % NUM_DIRECTIONS];
        directionIndex++;
        return nextDirection;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("You can't move a direction!");
    }

    private int indexOf(Direction direction) throws GameActionException
    {
        for (int directionIndex = 0; directionIndex < NUM_DIRECTIONS; directionIndex++)
        {
            if (MOVABLE_DIRECTIONS[directionIndex] == direction)
                return directionIndex;
        }

        throw new GameActionException(GameActionExceptionType.CANT_DO_THAT_BRO, "Invalid Starting Direction");
    }
}
