package com.matthewperiut.clay.entity.soldier;

import com.matthewperiut.clay.Clay;
import com.matthewperiut.clay.entity.ai.goal.MeleeAttackTinyGoal;
import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.IAnimationTickable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import static com.matthewperiut.clay.entity.soldier.Targets.AddTargets;

public class ClaySoldierEntity extends PathAwareEntity implements IAnimatable, IAnimationTickable
{
    public static final Identifier TEXTURE_ID = new Identifier(Clay.MOD_ID, "textures/entity/soldier/lightgray.png");
    private AnimationFactory factory = GeckoLibUtil.createFactory(this);
    private boolean isAnimating = false;

    public boolean hasWeapon = true;

    public ClaySoldierEntity(EntityType<? extends PathAwareEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    public static DefaultAttributeContainer setAttributes()
    {
        return PathAwareEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5.00f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 0.5f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25f)
                 .build();
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
    {
        if (this.hasVehicle())
        {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.clay_soldier.ride"));
            return PlayState.CONTINUE;
        }
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
        if (this.handSwinging)
        {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.clay_soldier.attack"));
            this.handSwinging = false;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.clay_soldier.idle"));
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
        animationData.addAnimationController(new AnimationController(this, "attackController", 0, this::attackPredicate));
    }

    @Override
    public AnimationFactory getFactory()
    {
        return this.factory;
    }

    protected void selectTargets()
    {
        AddTargets(this, this.targetSelector);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1, 1));
        this.goalSelector.add(3, new MeleeAttackTinyGoal(this, 1, false));

        selectTargets();

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
        {
            kill();
        }

        return super.handleAttack(attacker);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource src) {
        return SoundEvents.BLOCK_GRAVEL_BREAK;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_GRAVEL_STEP;
    }

    @Override
    public boolean collidesWith(Entity other)
    {
        //this.startRiding(other);
        if (other instanceof HorseDollEntity)
        {
            if (!other.hasPassengers())
                this.startRiding(other);
        }
        return super.collidesWith(other);
    }

    @Override
    public void onPlayerCollision(PlayerEntity player) {
        //this.setStackInHand(Hand.MAIN_HAND, new ItemStack(Items.SHEARS, 1));
        super.onPlayerCollision(player);
    }


    boolean dropBrick = false;
    @Override
    protected Identifier getLootTableId() {
        if (dropBrick)
            return new Identifier("clay:entities/soldier/brick");
        return super.getLootTableId();
    }

    @Override
    public void onDeath(DamageSource damageSource)
    {
        if(damageSource.isFire())
            dropBrick = true;
        super.onDeath(damageSource);
    }
}