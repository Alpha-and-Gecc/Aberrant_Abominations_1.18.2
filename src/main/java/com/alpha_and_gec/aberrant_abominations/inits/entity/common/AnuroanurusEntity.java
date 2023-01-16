package com.alpha_and_gec.aberrant_abominations.inits.entity.common;

import com.alpha_and_gec.aberrant_abominations.inits.entity.HybridEntities;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.UUID;

public class AnuroanurusEntity extends Animal implements IAnimatable, NeutralMob {


    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    private static final EntityDataAccessor<Boolean> FLYING = SynchedEntityData.defineId(AnuroanurusEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> HAS_TARGET = SynchedEntityData.defineId(AnuroanurusEntity.class, EntityDataSerializers.BOOLEAN);
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    private UUID persistentAngerTarget;
    private int remainingPersistentAngerTime;
    private boolean isLandNavigator;
    public AnuroanurusEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        switchNavigator(true);
        this.moveControl = new AnuroanurusEntity.PhantomStyleMoveControl(this);
        this.lookControl = new AnuroanurusEntity.PhantomStyleLookControl(this);
        this.maxUpStep = 1.0f;
    }

    private void switchNavigator(boolean onLand) {
        if (onLand) {
            this.moveControl = new MoveControl(this);
            this.navigation = new GroundPathNavigation(this, level);
            this.isLandNavigator = true;
        } else {
            this.moveControl = new AnuroanurusEntity.PhantomStyleMoveControl(this);
            this.lookControl = new AnuroanurusEntity.PhantomStyleLookControl(this);
            this.navigation = new FlyingPathNavigation(this, level) {
                /* public boolean isStableDestination(BlockPos pos) {
                    return !this.level.getBlockState(pos.below(2)).isAir();
                */
            };
            navigation.setCanFloat(false);
            this.isLandNavigator = false;
        }
    }

    class PhantomStyleLookControl extends LookControl {
        public PhantomStyleLookControl(Mob p_33235_) {
            super(p_33235_);
        }

        public void tick() {
        }
    }

    class PhantomStyleMoveControl extends MoveControl {
        private float speed = 0.1F;

        public PhantomStyleMoveControl(Mob p_33241_) {
            super(p_33241_);
        }

        public void tick() {
            if (AnuroanurusEntity.this.horizontalCollision) {
                AnuroanurusEntity.this.setYRot(AnuroanurusEntity.this.getYRot() + 180.0F);
                this.speed = 0.1F;
            }
            //TODO: FIGURE OUT HOW PHANTOM MOVE CONTROL WORKS
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ATTACK_DAMAGE, 4.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(2, new FollowParentGoal(this, 1.1));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1.1));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        //this.goalSelector.addGoal(2, new LlamaFollowCaravanGoal(this, (double)2.1F));
        this.targetSelector.addGoal(0, (new HurtByTargetGoal(this)));
        this.targetSelector.addGoal(8, new ResetUniversalAngerTargetGoal<>(this, true));
    }
    //TODO: MAKE CUSTOM CARAVAN GOAL FOR ANUROANURUS


    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return HybridEntities.MAJUNDOSTEUS.get().create(serverLevel);
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
        if (!event.isMoving() && !this.isFlying()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.anuroanurus.idle", true));
            return PlayState.CONTINUE;
        } else if (!event.isMoving() && this.isFlying()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.majundosteus.hover", true));
            return PlayState.CONTINUE;
        } else if (event.isMoving() && !this.isFlying()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.majundosteus.walk", true));
            return PlayState.CONTINUE;
        } else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.majundosteus.fly", true));
            return PlayState.CONTINUE;
        }
    }

    public boolean isFlying() {
        return this.entityData.get(FLYING);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.setResetSpeedInTicks(5);
        AnimationController<AnuroanurusEntity> controller = new AnimationController<>(this, "controller", 5, this::predicate);
        data.addAnimationController(controller);
    }

}
