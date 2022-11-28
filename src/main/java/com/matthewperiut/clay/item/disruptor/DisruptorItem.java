package com.matthewperiut.clay.item.disruptor;

import com.matthewperiut.clay.entity.horse.HorseDollEntity;
import com.matthewperiut.clay.entity.soldier.ClaySoldierEntity;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DisruptorItem extends ToolItem
{
    public DisruptorItem(ToolMaterial material, Settings settings)
    {
        super(material, settings);
    }

    boolean unlimited = false;
    public DisruptorItem(Settings settings)
    {
        super(new ClayMaterial(), settings);
        unlimited = true;
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
            if (!unlimited)
                itemStack.damage(1, user, (e) -> { e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND); });
            user.getItemCooldownManager().set(this, 20);
            return TypedActionResult.consume(itemStack);
        }

        return TypedActionResult.fail(itemStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.clay.disruptor.range").formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
