package com.codetaylor.mc.watercan.client.event;

import com.codetaylor.mc.watercan.WatercanMod;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class RenderHandEventHandler {

  @SubscribeEvent
  public static void on(RenderHandEvent event) {

    ItemStack itemStack = event.getItemStack();

    if (!RenderHandEventHandler.isWatercan(itemStack)) {
      return;
    }

    Minecraft minecraft = Minecraft.getInstance();

    if (minecraft.mouseHelper.isLeftDown()) {
      return;
    }

    RenderHandEventHandler.renderItemInFirstPerson(
        minecraft.player,
        event.getPartialTicks(),
        event.getHand(),
        itemStack,
        event.getEquipProgress(),
        event.getMatrixStack(),
        event.getBuffers(),
        event.getLight()
    );

    event.setCanceled(true);
  }

  private static boolean isWatercan(ItemStack itemStack) {

    Item item = itemStack.getItem();

    return item == WatercanMod.Items.WATERCAN_WOOD
        || item == WatercanMod.Items.WATERCAN_STONE
        || item == WatercanMod.Items.WATERCAN_GOLD
        || item == WatercanMod.Items.WATERCAN_IRON
        || item == WatercanMod.Items.WATERCAN_DIAMOND;
  }

  private static void renderItemInFirstPerson(
      PlayerEntity clientPlayer,
      float partialTicks,
      Hand hand,
      @Nonnull ItemStack itemStack,
      float equipProgress,
      MatrixStack matrixStack,
      IRenderTypeBuffer buffers,
      int light
  ) {

    RayTraceResult rayTraceResult = RenderHandEventHandler.rayTrace(clientPlayer, 10.0, partialTicks);
    float equipProgressScalar = 0.1f;

    if (rayTraceResult != null
        && rayTraceResult.getType() == RayTraceResult.Type.BLOCK) {
      BlockPos blockPos = ((BlockRayTraceResult) rayTraceResult).getPos();
      BlockState blockState = clientPlayer.world.getBlockState(blockPos);

      if (blockState.getMaterial() == Material.WATER) {
        equipProgressScalar = 1;
      }

    } else {
      equipProgressScalar = 0;
    }

    boolean isMainHand = hand == Hand.MAIN_HAND;
    HandSide handSide = isMainHand ? clientPlayer.getPrimaryHand() : clientPlayer.getPrimaryHand().opposite();
    boolean isRightHand = (handSide == HandSide.RIGHT);

    matrixStack.push();
    transformSideFirstPerson(handSide, equipProgress * equipProgressScalar);
    transformFirstPerson(handSide);
    renderItemSide(
        matrixStack,
        clientPlayer,
        itemStack,
        isRightHand ? ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND : ItemCameraTransforms.TransformType.FIRST_PERSON_LEFT_HAND,
        !isRightHand,
        buffers,
        light
    );
    matrixStack.pop();
  }

  private static void transformFirstPerson(HandSide handSide) {

    int i = handSide == HandSide.RIGHT ? 1 : -1;
    RenderSystem.rotatef((float) i * 45.0F, 0.0F, 1.0F, 0.0F);
    RenderSystem.rotatef(0.0F, 0.0F, 0.0F, 1.0F);
    RenderSystem.rotatef(0.0F, 1.0F, 0.0F, 0.0F);
    RenderSystem.rotatef((float) i * -45.0F, 0.0F, 1.0F, 0.0F);
  }

  private static void transformSideFirstPerson(HandSide handSide, float equipProgress) {

    int i = handSide == HandSide.RIGHT ? 1 : -1;
    RenderSystem.translatef((float) i * 0.56F, -0.52F + equipProgress * -0.6F, -0.72F);
  }

  private static void renderItemSide(
      MatrixStack matrixStack,
      LivingEntity entityLivingBase,
      ItemStack heldStack,
      ItemCameraTransforms.TransformType transform,
      boolean isLeftHanded,
      IRenderTypeBuffer buffers,
      int light
  ) {

    if (heldStack != null) {
      matrixStack.push();

      ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
      RenderSystem.depthMask(false);
      itemRenderer.renderItem(entityLivingBase, heldStack, transform, isLeftHanded, matrixStack, buffers, entityLivingBase.world, light, OverlayTexture.NO_OVERLAY);
      RenderSystem.depthMask(true);

      matrixStack.pop();
    }
  }

  @Nullable
  @OnlyIn(Dist.CLIENT)
  private static RayTraceResult rayTrace(
      Entity entity,
      double blockReachDistance,
      float partialTicks
  ) {

    Vector3d vec3d = entity.getEyePosition(partialTicks);
    Vector3d vec3d1 = entity.getLook(partialTicks);
    Vector3d vec3d2 = vec3d.add(
        vec3d1.x * blockReachDistance,
        vec3d1.y * blockReachDistance,
        vec3d1.z * blockReachDistance
    );
    return entity.world.rayTraceBlocks(new RayTraceContext(vec3d, vec3d2, RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.SOURCE_ONLY, entity));
  }
}
