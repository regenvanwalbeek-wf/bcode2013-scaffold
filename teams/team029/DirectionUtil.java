package team029;

import battlecode.common.Direction;

import java.util.Random;

public class DirectionUtil
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

    private static final int NUM_MOVABLE_DIRECTIONS = MOVABLE_DIRECTIONS.length;

    private static final Direction[] CARDINAL_DIRECTIONS =
            {
                    Direction.NORTH,
                    Direction.EAST,
                    Direction.SOUTH,
                    Direction.WEST
            };

    private static final int NUM_CARDINAL_DIRECTIONS = CARDINAL_DIRECTIONS.length;

    public static Direction getRandomMovableDirection(Random random)
    {
        return MOVABLE_DIRECTIONS[random.nextInt(NUM_MOVABLE_DIRECTIONS)];
    }

    public static Direction getRandomCardinalDirection(Random random)
    {
        int nextRandom = Math.abs(random.nextInt() % 4);
        System.out.println(nextRandom);
        return CARDINAL_DIRECTIONS[nextRandom];
    }

}
