package com.alpha_and_gec.aberrant_abominations.common.entity.ai;


public class TrackCertainBlockGoal {

    /*
    private static final int MAX_TRAVELLING_TICKS = 600;
    int travellingTicks = Entity.this.level.random.nextInt(10);

    TrackCertainBlockGoal() {
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        if (!Entity.isInWater()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean canBeeUse() {
        return Entity.this.savedFlowerPos != null && !Bee.this.hasRestriction() && this.wantsToGoToKnownFlower() && Bee.this.isFlowerValid(Bee.this.savedFlowerPos) && !Bee.this.closerThan(Bee.this.savedFlowerPos, 2);
    }

    public boolean canBeeContinueToUse() {
        return this.canBeeUse();
    }

    public void start() {
        this.travellingTicks = 0;
        super.start();
    }

    public void stop() {
        this.travellingTicks = 0;
        Bee.this.navigation.stop();
        Bee.this.navigation.resetMaxVisitedNodesMultiplier();
    }

    public void tick() {
        if (Bee.this.savedFlowerPos != null) {
            ++this.travellingTicks;
            if (this.travellingTicks > this.adjustedTickDelay(600)) {
                Bee.this.savedFlowerPos = null;
            } else if (!Bee.this.navigation.isInProgress()) {
                if (Bee.this.isTooFarAway(Bee.this.savedFlowerPos)) {
                    Bee.this.savedFlowerPos = null;
                } else {
                    Bee.this.pathfindRandomlyTowards(Bee.this.savedFlowerPos);
                }
            }
        }
    }

    private boolean wantsToGoToKnownFlower() {
        return Bee.this.ticksWithoutNectarSinceExitingHive > 2400;
    }
     */
}