package com.codetaylor.mc.watercan.common;

import com.codetaylor.mc.athenaeum.network.api.NetworkAPI;
import com.codetaylor.mc.athenaeum.network.spi.packet.IPacketService;
import com.codetaylor.mc.athenaeum.util.ConfigHelper;
import com.codetaylor.mc.watercan.IProxy;
import com.codetaylor.mc.watercan.WatercanMod;
import com.codetaylor.mc.watercan.WatercanModCommonConfig;
import com.codetaylor.mc.watercan.common.event.ItemRegistrationEventHandler;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CommonProxy
    implements IProxy {

  protected IPacketService packetService;

  @Override
  public void initialize() {

    String modId = WatercanMod.MOD_ID;
    Path configPath = FMLPaths.CONFIGDIR.get();
    Path modConfigPath = configPath.resolve(modId);

    try {
      Files.createDirectories(modConfigPath);

    } catch (IOException e) {
      WatercanMod.LOGGER.error("Error creating folder: " + modConfigPath, e);
    }

    ModLoadingContext modLoadingContext = ModLoadingContext.get();
    String configFilenameCommon = modId + "-common.toml";
    modLoadingContext.registerConfig(ModConfig.Type.COMMON, WatercanModCommonConfig.CONFIG_SPEC, modId + "/" + configFilenameCommon);
    ConfigHelper.loadConfig(WatercanModCommonConfig.CONFIG_SPEC, modConfigPath.resolve(configFilenameCommon));
    WatercanModCommonConfig.bake();

    this.packetService = NetworkAPI.createPacketService(WatercanMod.MOD_ID, WatercanMod.MOD_ID, WatercanMod.PACKET_SERVICE_PROTOCOL_VERSION);
  }

  @Override
  public void registerModEventHandlers(IEventBus eventBus) {

    eventBus.register(new ItemRegistrationEventHandler());

  }

  @Override
  public void registerForgeEventHandlers(IEventBus eventBus) {

  }

  @Override
  public IPacketService getPacketService() {

    return this.packetService;
  }

  @Override
  public boolean isIntegratedServerRunning() {

    return false;
  }
}
