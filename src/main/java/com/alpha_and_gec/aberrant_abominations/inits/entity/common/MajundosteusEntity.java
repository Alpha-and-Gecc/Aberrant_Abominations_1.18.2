package com.alpha_and_gec.aberrant_abominations.inits.entity.common;

import com.alpha_and_gec.aberrant_abominations.inits.entity.HybridEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.EnumSet;
import java.util.Optional;
import java.util.UUID;

public class MajundosteusEntity extends Animal implements IAnimatable, NeutralMob {
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    private static final EntityDataAccessor<Boolean> HAS_TARGET = SynchedEntityData.defineId(MajundosteusEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> FEEDING = SynchedEntityData.defineId(MajundosteusEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> FEEDING_TIME = SynchedEntityData.defineId(MajundosteusEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Optional<BlockPos>> FEEDING_POS = SynchedEntityData.defineId(MajundosteusEntity.class, EntityDataSerializers.OPTIONAL_BLOCK_POS);
    private UUID persistentAngerTarget;
    private int remainingPersistentAngerTime;
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    public float feedcooldown;
    public float lastfeedcooldown;

    public boolean canBreatheUnderwater() {
        return true;
    }

    public MajundosteusEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.WALKABLE, 0.0F);
        this.maxUpStep = 1.0f;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.ARMOR, 5.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ATTACK_DAMAGE, 6.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.8D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));

        this.goalSelector.addGoal(1, new FollowParentGoal(this, 1.1));
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1.0D, 10));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1.1));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 6.0f));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.0D, true));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
        this.targetSelector.addGoal(3, new ResetUniversalAngerTargetGoal<>(this, true));
    }
    //TODO: figure out how goal priority works
    //TODO: make it so that majundost tries to find water
    //TODO: make majundost only able to breath water

    public void travel(Vec3 travelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.setDeltaMovement(this.getDeltaMovement().scale(0.5D));
        } else {
            super.travel(travelVector);
        }
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return HybridEntities.MAJUNDOSTEUS.get().create(serverLevel);
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return this.remainingPersistentAngerTime;
    }

    @Override
    public void setRemainingPersistentAngerTime(int p_21673_) {
        this.remainingPersistentAngerTime = p_21673_;
    }

    @Override
    public UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }

    @Override
    public void setPersistentAngerTarget(@org.jetbrains.annotations.Nullable UUID p_21672_) {
        this.persistentAngerTarget = p_21672_;
    }

    @Override
    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (!event.isMoving() || this.isDescending()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.majundosteus.idle", true));
        } else {
            if (this.isUnderWater()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.majundosteus.waterwalk", true));
            } else {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.majundosteus.walk", true));
            }
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.setResetSpeedInTicks(5);
        AnimationController<MajundosteusEntity> controller = new AnimationController<>(this, "controller", 5, this::predicate);
        data.addAnimationController(controller);
    }

    /*
    private class TrackUsedBlock extends Goal {

        private final int searchLength;
        private final int verticalSearchRange;
        protected BlockPos destinationBlock;
        private MajundosteusEntity majundost;
        private int runDelay = 70;
        private int maxFeedTime = 200;
        private static final int MAX_TRAVELLING_TICKS = 600;

        private boolean edible(Level world, BlockPos.MutableBlockPos pos) {
            return world.getBlockState(pos).is();
        }
        int travellingTicks = MajundosteusEntity.this.level.random.nextInt(10);

        TrackUsedBlock() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean canContinueToUse() {
            return destinationBlock != null && isMossBlock(pupfish.level, destinationBlock.mutable()) && isCloseToMoss(16);
        }

        public boolean isCloseToMoss(double dist) {
            return destinationBlock == null || pupfish.distanceToSqr(Vec3.atCenterOf(destinationBlock)) < dist * dist;
        }

        @Override
        public boolean canUse() {
            if (!Mob.isInWaterOrBubble()) {
                return false;
            }
            if (this.runDelay > 0) {
                --this.runDelay;
                return false;
            } else {
                this.runDelay = 200 + MajundosteusEntity.random.nextInt(150);
                return this.searchForDestination();
            }
        }

        public void start() {
            this.travellingTicks = 0;
            super.start();
        }

        public void stop() {
            this.travellingTicks = 0;
            MajundosteusEntity.this.navigation.stop();
            MajundosteusEntity.this.navigation.resetMaxVisitedNodesMultiplier();
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
}
*/
}
