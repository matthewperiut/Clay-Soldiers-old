package com.matthewperiut.clay.entity.client;

import com.matthewperiut.clay.entity.soldier.ClaySoldierEntity;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.ExtendedGeoEntityRenderer;

public class ClaySoldierRenderer extends ExtendedGeoEntityRenderer<ClaySoldierEntity>
{
    protected ItemStack mainHandItem, offHandItem, helmetItem, chestplateItem, leggingsItem, bootsItem;
    public Identifier texture_id;
    public ClaySoldierRenderer(EntityRendererFactory.Context renderManager, AnimatedGeoModel<ClaySoldierEntity> modelProvider, Identifier texture_id)
    {
        super(renderManager, modelProvider);
        this.texture_id = texture_id;
        this.shadowRadius = 0.1f;
    }

    @Override
    public Identifier getTextureResource(ClaySoldierEntity animatable)
    {
        return texture_id;
    }

    @Override
    protected boolean isArmorBone(GeoBone bone)
    {
        return false;
    }

    @Override
    public void renderEarly(ClaySoldierEntity animatable, MatrixStack poseStack, float partialTick, VertexConsumerProvider bufferSource,
                            VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float partialTicks)
    {
        super.renderEarly(animatable, poseStack, partialTick, bufferSource, buffer, packedLight, packedOverlay, red, green, blue, partialTicks);

        this.mainHandItem = animatable.getEquippedStack(EquipmentSlot.MAINHAND);
        this.offHandItem = animatable.getEquippedStack(EquipmentSlot.OFFHAND);
        this.helmetItem = animatable.getEquippedStack(EquipmentSlot.HEAD);
        this.chestplateItem = animatable.getEquippedStack(EquipmentSlot.CHEST);
        this.leggingsItem = animatable.getEquippedStack(EquipmentSlot.LEGS);
        this.bootsItem = animatable.getEquippedStack(EquipmentSlot.FEET);
    }

    @Nullable
    @Override
    protected Identifier getTextureForBone(String boneName, ClaySoldierEntity currentEntity)
    {
        return null;
    }

    @Nullable
    @Override
    protected ItemStack getHeldItemForBone(String boneName, ClaySoldierEntity currentEntity) {

        return switch (boneName) {
            case "larm" -> currentEntity.isLeftHanded() ? mainHandItem : offHandItem;
            case "rarm" -> currentEntity.isLeftHanded() ? offHandItem : mainHandItem;
            default -> null;
        };
    }

    @Override
    protected ModelTransformation.Mode getCameraTransformForItemAtBone(ItemStack boneItem, String boneName) {
        return switch (boneName) {
            case "larm", "rarm" -> ModelTransformation.Mode.THIRD_PERSON_RIGHT_HAND; // Do Defaults
            default -> ModelTransformation.Mode.NONE;
        };
    }

    @Nullable
    @Override
    protected BlockState getHeldBlockForBone(String boneName, ClaySoldierEntity currentEntity) {
        return null;
    }

    @Override
    protected void preRenderItem(MatrixStack PoseStack, ItemStack item, String boneName, ClaySoldierEntity currentEntity, IBone bone) {
        PoseStack.scale(0.4f,0.4f,0.4f);
        PoseStack.translate(0f,-0.4f,0f);
    }

    @Override
    protected void preRenderBlock(MatrixStack PoseStack, BlockState block, String boneName, ClaySoldierEntity currentEntity) {

    }

    @Override
    protected void postRenderItem(MatrixStack PoseStack, ItemStack item, String boneName, ClaySoldierEntity currentEntity, IBone bone) {

    }

    @Override
    protected void postRenderBlock(MatrixStack PoseStack, BlockState block, String boneName, ClaySoldierEntity currentEntity) {

    }
}
