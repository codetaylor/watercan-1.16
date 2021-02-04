package com.codetaylor.mc.watercan.common.item;

import com.codetaylor.mc.watercan.WatercanModCommonConfig;

public class WatercanIronItem
    extends WatercanBaseItem {

  public static final String NAME = "watercan_iron";

  public WatercanIronItem() {

    super(new Properties().maxDamage(WatercanModCommonConfig.IRON_WATERCAN.capacity), NAME);
  }

  @Override
  protected boolean isDispensable() {

    return WatercanModCommonConfig.IRON_WATERCAN.isDispensable;
  }

  @Override
  protected boolean canExtinguishFire() {

    return WatercanModCommonConfig.IRON_WATERCAN.extinguishFire;
  }

  @Override
  protected boolean canMoisturizeFarmland() {

    return WatercanModCommonConfig.IRON_WATERCAN.moisturizeFarmland;
  }

  @Override
  protected boolean canSpawnFlowers() {

    return WatercanModCommonConfig.IRON_WATERCAN.spawnFlowers;
  }

  @Override
  protected boolean canSpreadGrass() {

    return WatercanModCommonConfig.IRON_WATERCAN.spreadGrass;
  }

  @Override
  protected boolean canSpreadMycelium() {

    return WatercanModCommonConfig.IRON_WATERCAN.spreadMycelium;
  }

  @Override
  protected boolean canGrowCrops() {

    return WatercanModCommonConfig.IRON_WATERCAN.growCrops;
  }

  @Override
  protected boolean canGrowSaplings() {

    return WatercanModCommonConfig.IRON_WATERCAN.growSaplings;
  }

  @Override
  protected int getDelayModifier() {

    return WatercanModCommonConfig.IRON_WATERCAN.delayModifier;
  }

  @Override
  protected boolean consumeWaterSource() {

    return WatercanModCommonConfig.IRON_WATERCAN.consumeWaterSource;
  }

  @Override
  protected int getRange() {

    return WatercanModCommonConfig.IRON_WATERCAN.range;
  }

  @Override
  protected int getFlowerChance() {

    return WatercanModCommonConfig.IRON_WATERCAN.flowerChance;
  }
}
