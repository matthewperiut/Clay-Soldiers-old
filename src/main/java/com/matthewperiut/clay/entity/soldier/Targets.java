package com.matthewperiut.clay.entity.soldier;

import com.matthewperiut.clay.entity.soldier.variant.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.mob.MobEntity;

public class Targets
{
    public boolean checker(Object obj, Class someClass) {
        return someClass.isInstance(obj);
    }

    private static void add(Class soldierType, Object entity, GoalSelector targetSelector)
    {
        if (!soldierType.isInstance(entity))
        {
            MobEntity mob = (MobEntity) entity;
            targetSelector.add(2, new ActiveTargetGoal<>(mob, soldierType, true));
        }
    }

    public static void AddTargets(MobEntity you, GoalSelector targetSelector)
    {
        add(RegularSoldier.class, you, targetSelector);
        add(RedSoldier.class, you, targetSelector);
        add(YellowSoldier.class, you, targetSelector);
        add(GreenSoldier.class, you, targetSelector);
        add(BlueSoldier.class, you, targetSelector);
        add(OrangeSoldier.class, you, targetSelector);
        add(MagentaSoldier.class, you, targetSelector);
        add(LightblueSoldier.class, you, targetSelector);
        add(LimeSoldier.class, you, targetSelector);
        add(PinkSoldier.class, you, targetSelector);
        add(CyanSoldier.class, you, targetSelector);
        add(PurpleSoldier.class, you, targetSelector);
        add(BrownSoldier.class, you, targetSelector);
        add(BlackSoldier.class, you, targetSelector);
        add(GraySoldier.class, you, targetSelector);
        add(WhiteSoldier.class, you, targetSelector);
    }
}
