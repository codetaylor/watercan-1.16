package com.codetaylor.mc.watercan.client;

import com.codetaylor.mc.watercan.common.CommonProxy;
import net.minecraft.client.Minecraft;

public class ClientProxy
    extends CommonProxy {

  @Override
  public boolean isIntegratedServerRunning() {

    return Minecraft.getInstance().isIntegratedServerRunning();
  }
}
