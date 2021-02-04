package com.codetaylor.mc.watercan.common.item;

import com.codetaylor.mc.watercan.WatercanModCommonConfig;

public class WatercanWoodItem
    extends WatercanBaseItem {

  public static final String NAME = "watercan_wood";

  public WatercanWoodItem() {

    super(new Properties().maxDamage(WatercanModCommonConfig.WOODEN_WATERCAN.capacity), NAME);
  }

  @Override
  protected boolean isDispensable() {

    return WatercanModCommonConfig.WOODEN_WATERCAN.isDispensable;
  }

  @Override
  protected boolean canExtinguishFire() {

    return WatercanModCommonConfig.WOODEN_WATERCAN.extinguishFire;
  }

  @Override
  protected boolean canMoisturizeFarmland() {

    return WatercanModCommonConfig.WOODEN_WATERCAN.moisturizeFarmland;
  }

  @Override
  protected boolean canSpawnFlowers() {

    return WatercanModCommonConfig.WOODEN_WATERCAN.spawnFlowers;
  }

  @Override
  protected boolean canSpreadGrass() {

    return WatercanModCommonConfig.WOODEN_WATERCAN.spreadGrass;
  }

  @Override
  protected boolean canSpreadMycelium() {

    return WatercanModCommonConfig.WOODEN_WATERCAN.spreadMycelium;
  }

  @Override
  protected boolean canGrowCrops() {

    return WatercanModCommonConfig.WOODEN_WATERCAN.growCrops;
  }

  @Override
  protected boolean canGrowSaplings() {

    return WatercanModCommonConfig.WOODEN_WATERCAN.growSaplings;
  }

  @Override
  protected int getDelayModifier() {

    return WatercanModCommonConfig.WOODEN_WATERCAN.delayModifier;
  }

  @Override
  protected boolean consumeWaterSource() {

    return WatercanModCommonConfig.WOODEN_WATERCAN.consumeWaterSource;
  }

  @Override
  protected int getRange() {

    return WatercanModCommonConfig.WOODEN_WATERCAN.range;
  }

  @Override
  protected int getFlowerChance() {

    return WatercanModCommonConfig.WOODEN_WATERCAN.flowerChance;
  }
}
