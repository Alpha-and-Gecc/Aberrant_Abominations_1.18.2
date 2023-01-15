package com.alpha_and_gec.aberrant_abominations.common.entityclasses;

import com.alpha_and_gec.aberrant_abominations.inits.entities.CustomEntities;
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

import java.util.UUID;

public class MajundosteusEntity extends Animal implements IAnimatable, NeutralMob{
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    private static final EntityDataAccessor<Boolean> HAS_TARGET = SynchedEntityData.defineId(MajundosteusEntity.class, EntityDataSerializers.BOOLEAN);
    private UUID persistentAngerTarget;
    private int remainingPersistentAngerTime;
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);

    public MajundosteusEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.maxUpStep = 1.0f;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 40.0D)
                .add(Attributes.ARMOR, 5.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.ATTACK_DAMAGE, 6.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.8D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0f));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(8, (new HurtByTargetGoal(this)));
        this.targetSelector.addGoal(9, new ResetUniversalAngerTargetGoal<>(this, true));
    }
    //TODO: figure out how goal priority works
    //TODO: make it so that majundost tries to find water
    //TODO: make majundost only able to breath water


    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return CustomEntities.MAJUNDOSTEUS.get().create(serverLevel);
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
        if (!event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.majundosteus.idle", true));
            return PlayState.CONTINUE;
        } else if (this.isInWater() && event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.majundosteus.waterwalk", true));
            return PlayState.CONTINUE;
        } else if (!this.isInWater() && event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.majundosteus.walk", true));
            return PlayState.CONTINUE;
        }

        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.setResetSpeedInTicks(5);
        AnimationController<MajundosteusEntity> controller = new AnimationController<>(this, "controller", 5, this::predicate);
        data.addAnimationController(controller);
    }
}
