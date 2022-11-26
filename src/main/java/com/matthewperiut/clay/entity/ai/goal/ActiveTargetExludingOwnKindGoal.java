package com.matthewperiut.clay.entity.ai.goal;

import com.matthewperiut.clay.entity.soldier.ClaySoldierEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class ActiveTargetExludingOwnKindGoal<T extends LivingEntity> extends ActiveTargetGoal
{
    public ActiveTargetExludingOwnKindGoal(MobEntity mob, Class targetClass, boolean checkVisibility)
    {
        super(mob, targetClass, checkVisibility);
    }

    public ActiveTargetExludingOwnKindGoal(MobEntity mob, Class targetClass, boolean checkVisibility, Predicate targetPredicate)
    {
        super(mob, targetClass, checkVisibility, targetPredicate);
    }

    public ActiveTargetExludingOwnKindGoal(MobEntity mob, Class targetClass, boolean checkVisibility, boolean checkCanNavigate)
    {
        super(mob, targetClass, checkVisibility, checkCanNavigate);
    }

    public ActiveTargetExludingOwnKindGoal(MobEntity mob, Class targetClass, int reciprocalChance, boolean checkVisibility, boolean checkCanNavigate, @Nullable Predicate targetPredicate)
    {
        super(mob, targetClass, reciprocalChance, checkVisibility, checkCanNavigate, targetPredicate);
    }

    public boolean testClaySoldierSameTeam(Entity me, Entity them)
    {
        if (me instanceof ClaySoldierEntity && them instanceof ClaySoldierEntity)
        {
            ClaySoldierEntity one = (ClaySoldierEntity) me;
            ClaySoldierEntity two = (ClaySoldierEntity) them;

            return one.type == two.type;
        }
        else
            return false;
    }

    @Nullable <T extends LivingEntity> T getClosestEntityExcludingOwnType(List<? extends T> entityList, TargetPredicate targetPredicate, @Nullable LivingEntity entity, double x, double y, double z)
    {
        double d = -1.0;
        T livingEntity = null;
        Iterator entities = entityList.iterator();

        while(true)
        {
            LivingEntity livingEntity2;
            double e;
            do
            {
                do
                {
                    if (!entities.hasNext())
                    {
                        return livingEntity;
                    }

                    livingEntity2 = (LivingEntity)entities.next();
                }
                while(!targetPredicate.test(entity, livingEntity2) && testClaySoldierSameTeam(entity, livingEntity2));

                e = livingEntity2.squaredDistanceTo(x, y, z);
            }
            while(d != -1.0 && !(e < d));

            d = e;
            livingEntity = (T) livingEntity2;
        }
    }

    @Override
    protected void findClosestTarget() {
        if (this.targetClass != PlayerEntity.class && this.targetClass != ServerPlayerEntity.class)
        {
            this.targetEntity = getClosestEntityExcludingOwnType(
                    this.mob.world.getEntitiesByClass(this.targetClass, this.getSearchBox(this.getFollowRange()), (livingEntity) -> {
                return true;
            }), this.targetPredicate, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());
        } else {
            this.targetEntity = this.mob.world.getClosestPlayer(this.targetPredicate, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());
        }

    }
}
