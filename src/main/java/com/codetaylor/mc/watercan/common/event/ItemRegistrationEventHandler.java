package com.codetaylor.mc.watercan.common.event;

import com.codetaylor.mc.watercan.common.item.*;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ItemRegistrationEventHandler {

  @SubscribeEvent
  public void on(RegistryEvent.Register<Item> event) {

    IForgeRegistry<Item> registry = event.getRegistry();

    registry.register(new WatercanWoodItem());
    registry.register(new WatercanStoneItem());
    registry.register(new WatercanIronItem());
    registry.register(new WatercanGoldItem());
    registry.register(new WatercanDiamondItem());
  }
}
