package com.codetaylor.mc.watercan;

import com.codetaylor.mc.athenaeum.network.spi.packet.IPacketService;
import net.minecraftforge.eventbus.api.IEventBus;

public interface IProxy {

  void initialize();

  void registerModEventHandlers(IEventBus eventBus);

  void registerForgeEventHandlers(IEventBus eventBus);

  IPacketService getPacketService();

  boolean isIntegratedServerRunning();

}
