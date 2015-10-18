package teamxxx.robot;

import battlecode.common.*;
import teamxxx.util.DirectionIterator;

import java.util.Iterator;

public class HeadquartersAI extends AbstractRobotAI
{
    private static final int LARGE_MAP_THRESHOLD = 10;

    private static final int INITIAL_ARMY_SIZE = 5;

    private boolean isLargeMap = false;



    public HeadquartersAI(RobotController robotController)
    {
        super(robotController);
    }

    @Override
    public boolean run() throws GameActionException {
        initMapSize();


        for (int soldiersCreated = 0; soldiersCreated < INITIAL_ARMY_SIZE; soldiersCreated++)
        {
            boolean soldierSpawned = spawnSoldier();
            // TODO what happens in !soldierSpawned? This is where the research/selectors would be useful
        }

        if (isLargeMap) {
            researchPickaxe();
            researchDefusion();
        }


        while (true) {
            spawnSoldier();
        }


//        return true;
    }

    private boolean spawnSoldier() throws GameActionException {
        Direction spawnDirection = getSpawnDirection();
        if (spawnDirection == null)
            return false;

        robotController.spawn(spawnDirection);

        yield(GameConstants.HQ_SPAWN_DELAY); // TODO yielding will change if builiding suppliers...equation...or maybe just use isActive and dont worry about ever yielding..
        return true;
    }


    private Direction getSpawnDirection() throws GameActionException {
        // Try to spawn in the direction toward the enemy. Else get the next available square.
        Direction towardEnemyHQ = calcDirectionClosestToEnemyHQ();

        Iterator iter = new DirectionIterator(towardEnemyHQ);
        while (iter.hasNext()) {
            Direction nextDirection = (Direction) iter.next();
            if (canSpawnRobotInDirection(nextDirection))
                return nextDirection;
        }

        return null;
    }

    private Direction calcDirectionClosestToEnemyHQ() {
        return robotController.getLocation().directionTo(getEnemyHQLocation());
    }

    private boolean canSpawnRobotInDirection(Direction direction) throws GameActionException {
        if (!robotController.canMove(direction))
            return false;

        boolean dangerousMine = hasDangerousMine(robotController.getLocation().add(direction));
        if (dangerousMine)
            return false;

        return true;
    }

    private void researchPickaxe() throws GameActionException {
        for (int turnsResarched = 0; turnsResarched < Upgrade.PICKAXE.numRounds; turnsResarched++) {
            robotController.researchUpgrade(Upgrade.PICKAXE);
            yield(1);
        }
    }

    private void researchDefusion() throws GameActionException {
        for (int turnsResarched = 0; turnsResarched < Upgrade.DEFUSION.numRounds; turnsResarched++) {
            robotController.researchUpgrade(Upgrade.DEFUSION);
            yield(1);
        }
    }

    private void initMapSize() {
        MapLocation enemyLocation = getEnemyHQLocation();
        MapLocation friendlyLocation = robotController.getLocation();
        int distanceToEnemy = friendlyLocation.distanceSquaredTo(enemyLocation);
        if (distanceToEnemy > LARGE_MAP_THRESHOLD)
            isLargeMap = true;

        robotController.setIndicatorString(2, "" + isLargeMap);
    }
}
