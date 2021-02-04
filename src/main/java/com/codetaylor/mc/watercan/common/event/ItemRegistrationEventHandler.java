package com.codetaylor.mc.watercan.common.event;

import com.codetaylor.mc.watercan.common.item.*;
import net.minecraft.block.DispenserBlock;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemRegistrationEventHandler {

  @SubscribeEvent
  public void on(RegistryEvent.Register<Item> event) {

    IForgeRegistry<Item> registry = event.getRegistry();

    this.register(registry, new WatercanWoodItem());
    this.register(registry, new WatercanStoneItem());
    this.register(registry, new WatercanIronItem());
    this.register(registry, new WatercanGoldItem());
    this.register(registry, new WatercanDiamondItem());
  }

  private void register(IForgeRegistry<Item> registry, WatercanBaseItem item) {

    registry.register(item);
    DispenserBlock.registerDispenseBehavior(() -> item, WatercanBaseItem.DispenserBehavior.INSTANCE);
  }
}
