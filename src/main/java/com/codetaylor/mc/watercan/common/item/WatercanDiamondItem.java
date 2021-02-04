package com.codetaylor.mc.watercan.common.item;

import com.codetaylor.mc.watercan.WatercanModCommonConfig;

public class WatercanDiamondItem
    extends WatercanBaseItem {

  public static final String NAME = "watercan_diamond";

  public WatercanDiamondItem() {

    super(new Properties().maxDamage(WatercanModCommonConfig.DIAMOND_WATERCAN.capacity), NAME);
  }

  @Override
  protected boolean isDispensable() {

    return WatercanModCommonConfig.DIAMOND_WATERCAN.isDispensable;
  }

  @Override
  protected boolean canExtinguishFire() {

    return WatercanModCommonConfig.DIAMOND_WATERCAN.extinguishFire;
  }

  @Override
  protected boolean canMoisturizeFarmland() {

    return WatercanModCommonConfig.DIAMOND_WATERCAN.moisturizeFarmland;
  }

  @Override
  protected boolean canSpawnFlowers() {

    return WatercanModCommonConfig.DIAMOND_WATERCAN.spawnFlowers;
  }

  @Override
  protected boolean canSpreadGrass() {

    return WatercanModCommonConfig.DIAMOND_WATERCAN.spreadGrass;
  }

  @Override
  protected boolean canSpreadMycelium() {

    return WatercanModCommonConfig.DIAMOND_WATERCAN.spreadMycelium;
  }

  @Override
  protected boolean canGrowCrops() {

    return WatercanModCommonConfig.DIAMOND_WATERCAN.growCrops;
  }

  @Override
  protected boolean canGrowSaplings() {

    return WatercanModCommonConfig.DIAMOND_WATERCAN.growSaplings;
  }

  @Override
  protected int getDelayModifier() {

    return WatercanModCommonConfig.DIAMOND_WATERCAN.delayModifier;
  }

  @Override
  protected boolean consumeWaterSource() {

    return WatercanModCommonConfig.DIAMOND_WATERCAN.consumeWaterSource;
  }

  @Override
  protected int getRange() {

    return WatercanModCommonConfig.DIAMOND_WATERCAN.range;
  }

  @Override
  protected int getFlowerChance() {

    return WatercanModCommonConfig.DIAMOND_WATERCAN.flowerChance;
  }
}
