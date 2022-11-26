package com.matthewperiut.clay.entity.soldier;

import com.matthewperiut.clay.entity.ai.goal.ActiveTargetExludingOwnKindGoal;
import com.matthewperiut.clay.entity.ai.goal.MeleeAttackTinyGoal;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.IAnimationTickable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.CustomInstructionKeyframeEvent;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class ClaySoldierEntity extends PathAwareEntity implements IAnimatable, IAnimationTickable {

    public int type = SoldierTypes.regular.ordinal();
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    private boolean isAnimating = false;

    public ClaySoldierEntity(EntityType<? extends PathAwareEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    public static DefaultAttributeContainer setAttributes()
    {
        return PathAwareEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.00)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 2.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25f)
                 .build();
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        if (event.isMoving())
        {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.clay_soldier.run"));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.clay_soldier.idle"));

        return PlayState.CONTINUE;
    }

    private PlayState attackPredicate(AnimationEvent event)
    {
        if (this.handSwinging && event.getController().getAnimationState().equals(AnimationState.Stopped))
        {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.chomper.attack"));
            this.handSwinging = false;
        }
        return PlayState.CONTINUE;
    }

    @Override
    public ActionResult interactAt(PlayerEntity player, Vec3d hitPos, Hand hand) {
        if (hand == Hand.MAIN_HAND) {
            this.isAnimating = !this.isAnimating;
        }
        return super.interactAt(player, hitPos, hand);
    }

    @Override
    public void registerControllers(AnimationData animationData)
    {
        animationData.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }
/*
    @Override
    public void registerControllers(AnimationData data) {
        AnimationController<ClaySoldierEntity> controller = new AnimationController<>(this, "controller", 0,
                this::predicate);
        AnimationController<ClaySoldierEntity> controllerspin = new AnimationController<>(this, "controllerspin", 0,
                this::predicateSpin);
        controller.registerCustomInstructionListener(this::customListener);
        data.addAnimationController(controller);
        data.addAnimationController(controllerspin);
    }

    private <ENTITY extends IAnimatable> void customListener(CustomInstructionKeyframeEvent<ENTITY> event) {
        final ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null) {
            player.sendMessage(Text.translatable("KeyFraming"), true);
        }
    }
*/
    @Override
    public AnimationFactory getFactory()
    {
        return this.factory;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1, 1));
        this.goalSelector.add(3, new MeleeAttackTinyGoal(this, 1, false));

        this.targetSelector.add(2, new ActiveTargetExludingOwnKindGoal<>(this, ClaySoldierEntity.class, true));

        super.initGoals();
    }

    @Override
    public int tickTimer() {
        return age;
    }

    @Override
    public boolean handleAttack(Entity attacker)
    {
        if (attacker instanceof PlayerEntity)
            kill();
        return super.handleAttack(attacker);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource src) {
        return SoundEvents.BLOCK_GRAVEL_BREAK;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_GRAVEL_STEP;
    }


}