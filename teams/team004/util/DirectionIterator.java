package team004.util;

import battlecode.common.Direction;

import java.util.Iterator;

public class DirectionIterator implements Iterator
{
    private int directionIndex = 0;

    @Override
    public boolean hasNext()
    {
        return directionIndex < DirectionUtil.MOVABLE_DIRECTIONS.length;
    }

    @Override
    public Object next()
    {
        Direction nextDirection = DirectionUtil.MOVABLE_DIRECTIONS[directionIndex];
        directionIndex++;
        return nextDirection;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("You can't move a direction!");
    }
}
