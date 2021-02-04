package com.codetaylor.mc.watercan.common.item;

import com.codetaylor.mc.watercan.WatercanModCommonConfig;

public class WatercanGoldItem
    extends WatercanBaseItem {

  public static final String NAME = "watercan_gold";

  public WatercanGoldItem() {

    super(new Properties().maxDamage(WatercanModCommonConfig.GOLD_WATERCAN.capacity), NAME);
  }

  @Override
  protected boolean isDispensable() {

    return WatercanModCommonConfig.GOLD_WATERCAN.isDispensable;
  }

  @Override
  protected boolean canExtinguishFire() {

    return WatercanModCommonConfig.GOLD_WATERCAN.extinguishFire;
  }

  @Override
  protected boolean canMoisturizeFarmland() {

    return WatercanModCommonConfig.GOLD_WATERCAN.moisturizeFarmland;
  }

  @Override
  protected boolean canSpawnFlowers() {

    return WatercanModCommonConfig.GOLD_WATERCAN.spawnFlowers;
  }

  @Override
  protected boolean canSpreadGrass() {

    return WatercanModCommonConfig.GOLD_WATERCAN.spreadGrass;
  }

  @Override
  protected boolean canSpreadMycelium() {

    return WatercanModCommonConfig.GOLD_WATERCAN.spreadMycelium;
  }

  @Override
  protected boolean canGrowCrops() {

    return WatercanModCommonConfig.GOLD_WATERCAN.growCrops;
  }

  @Override
  protected boolean canGrowSaplings() {

    return WatercanModCommonConfig.GOLD_WATERCAN.growSaplings;
  }

  @Override
  protected int getDelayModifier() {

    return WatercanModCommonConfig.GOLD_WATERCAN.delayModifier;
  }

  @Override
  protected boolean consumeWaterSource() {

    return WatercanModCommonConfig.GOLD_WATERCAN.consumeWaterSource;
  }

  @Override
  protected int getRange() {

    return WatercanModCommonConfig.GOLD_WATERCAN.range;
  }

  @Override
  protected int getFlowerChance() {

    return WatercanModCommonConfig.GOLD_WATERCAN.flowerChance;
  }
}
