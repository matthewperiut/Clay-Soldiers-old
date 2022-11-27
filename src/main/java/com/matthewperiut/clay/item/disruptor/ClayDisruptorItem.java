package com.matthewperiut.clay.item.disruptor;

import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.entity.soldier.ClaySoldierEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class ClayDisruptorItem extends ToolItem
{
    public ClayDisruptorItem(ToolMaterial material, Settings settings)
    {
        super(material, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        ItemStack itemStack = user.getStackInHand(hand);

        Box area = new Box(user.getPos().subtract(new Vec3d(16,16,16)),user.getPos().add(new Vec3d(16,16,16)));
        List<Entity> entityList = world.getOtherEntities(user, area);

        boolean found = false;
        for (Entity entity : entityList)
        {
            if (entity instanceof ClaySoldierEntity || entity instanceof HorseDollEntity)
            {
                entity.kill();
                found = true;
            }
        }

        if (found)
        {
            itemStack.damage(1, user, (e) -> { e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND); });
            user.getItemCooldownManager().set(this, 20);
            return TypedActionResult.consume(itemStack);
        }

        return TypedActionResult.fail(itemStack);
    }
}
