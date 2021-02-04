package com.codetaylor.mc.watercan;

import com.codetaylor.mc.watercan.client.ClientProxy;
import com.codetaylor.mc.watercan.common.CommonProxy;
import com.codetaylor.mc.watercan.common.item.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(WatercanMod.MOD_ID)
public class WatercanMod {

  public static final String MOD_ID = "watercan";
  public static final String PACKET_SERVICE_PROTOCOL_VERSION = "1";
  public static final Logger LOGGER = LogManager.getLogger(WatercanMod.class);

  private static WatercanMod instance;

  private final IProxy proxy;

  public WatercanMod() {

    WatercanMod.instance = this;

    this.proxy = DistExecutor.unsafeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
    this.proxy.initialize();
    this.proxy.registerModEventHandlers(FMLJavaModLoadingContext.get().getModEventBus());
    this.proxy.registerForgeEventHandlers(MinecraftForge.EVENT_BUS);
  }

  public static WatercanMod getInstance() {

    return WatercanMod.instance;
  }

  public static IProxy getProxy() {

    return WatercanMod.getInstance().proxy;
  }

  @ObjectHolder(WatercanMod.MOD_ID)
  public static class Items {

    @ObjectHolder(WatercanWoodItem.NAME)
    public static final WatercanWoodItem WATERCAN_WOOD;

    @ObjectHolder(WatercanStoneItem.NAME)
    public static final WatercanStoneItem WATERCAN_STONE;

    @ObjectHolder(WatercanGoldItem.NAME)
    public static final WatercanGoldItem WATERCAN_GOLD;

    @ObjectHolder(WatercanIronItem.NAME)
    public static final WatercanIronItem WATERCAN_IRON;

    @ObjectHolder(WatercanDiamondItem.NAME)
    public static final WatercanDiamondItem WATERCAN_DIAMOND;

    static {
      WATERCAN_WOOD = null;
      WATERCAN_STONE = null;
      WATERCAN_GOLD = null;
      WATERCAN_IRON = null;
      WATERCAN_DIAMOND = null;
    }
  }
}
