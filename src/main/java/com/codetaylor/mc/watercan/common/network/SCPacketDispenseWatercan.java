package com.codetaylor.mc.watercan.common.network;

import com.codetaylor.mc.athenaeum.network.spi.packet.IMessage;
import com.codetaylor.mc.athenaeum.network.spi.packet.IMessageHandler;
import com.codetaylor.mc.watercan.common.item.WatercanBaseItem;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class SCPacketDispenseWatercan
    implements IMessage<SCPacketDispenseWatercan>,
    IMessageHandler<SCPacketDispenseWatercan, SCPacketDispenseWatercan> {

  private ItemStack itemStack;
  private BlockPos blockPos;

  @SuppressWarnings("unused")
  public SCPacketDispenseWatercan() {
    // serialization
  }

  public SCPacketDispenseWatercan(ItemStack itemStack, BlockPos pos) {

    this.itemStack = itemStack;
    this.blockPos = pos;
  }

  @Override
  public void encode(SCPacketDispenseWatercan message, PacketBuffer packetBuffer) {

    packetBuffer.writeItemStack(message.itemStack);
    packetBuffer.writeBlockPos(message.blockPos);
  }

  @Override
  public SCPacketDispenseWatercan decode(SCPacketDispenseWatercan message, PacketBuffer packetBuffer) {

    message.itemStack = packetBuffer.readItemStack();
    message.blockPos = packetBuffer.readBlockPos();
    return message;
  }

  @Override
  public SCPacketDispenseWatercan onMessage(SCPacketDispenseWatercan message, Supplier<NetworkEvent.Context> contextSupplier) {

    return Handler.onMessage(message, contextSupplier);
  }

  public static class Handler {

    public static SCPacketDispenseWatercan onMessage(SCPacketDispenseWatercan message, Supplier<NetworkEvent.Context> contextSupplier) {

      NetworkEvent.Context context = contextSupplier.get();
      context.enqueueWork(() -> {

        ItemStack itemStack = message.itemStack;
        Item item = itemStack.getItem();

        if (item instanceof WatercanBaseItem) {
          double x = message.blockPos.getX() + 0.5;
          double y = message.blockPos.getY() + 0.5;
          double z = message.blockPos.getZ() + 0.5;
          World world = Minecraft.getInstance().world;
          WatercanBaseItem watercan = (WatercanBaseItem) item;

          if (watercan.getMaxDamage(itemStack) == 0
              || watercan.getMaxDamage(itemStack) - itemStack.getDamage() >= WatercanBaseItem.MILLI_BUCKETS_PER_USE) {
            watercan.spawnParticles(world, x, y, z);
          }
        }
      });
      context.setPacketHandled(true);
      return null;
    }
  }
}
