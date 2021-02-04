package com.codetaylor.mc.watercan.common.item;

import com.codetaylor.mc.watercan.WatercanModCommonConfig;

public class WatercanStoneItem
    extends WatercanBaseItem {

  public static final String NAME = "watercan_stone";

  public WatercanStoneItem() {

    super(new Properties().maxDamage(WatercanModCommonConfig.STONE_WATERCAN.capacity), NAME);
  }

  @Override
  protected boolean isDispensable() {

    return WatercanModCommonConfig.STONE_WATERCAN.isDispensable;
  }

  @Override
  protected boolean canExtinguishFire() {

    return WatercanModCommonConfig.STONE_WATERCAN.extinguishFire;
  }

  @Override
  protected boolean canMoisturizeFarmland() {

    return WatercanModCommonConfig.STONE_WATERCAN.moisturizeFarmland;
  }

  @Override
  protected boolean canSpawnFlowers() {

    return WatercanModCommonConfig.STONE_WATERCAN.spawnFlowers;
  }

  @Override
  protected boolean canSpreadGrass() {

    return WatercanModCommonConfig.STONE_WATERCAN.spreadGrass;
  }

  @Override
  protected boolean canSpreadMycelium() {

    return WatercanModCommonConfig.STONE_WATERCAN.spreadMycelium;
  }

  @Override
  protected boolean canGrowCrops() {

    return WatercanModCommonConfig.STONE_WATERCAN.growCrops;
  }

  @Override
  protected boolean canGrowSaplings() {

    return WatercanModCommonConfig.STONE_WATERCAN.growSaplings;
  }

  @Override
  protected int getDelayModifier() {

    return WatercanModCommonConfig.STONE_WATERCAN.delayModifier;
  }

  @Override
  protected boolean consumeWaterSource() {

    return WatercanModCommonConfig.STONE_WATERCAN.consumeWaterSource;
  }

  @Override
  protected int getRange() {

    return WatercanModCommonConfig.STONE_WATERCAN.range;
  }

  @Override
  protected int getFlowerChance() {

    return WatercanModCommonConfig.STONE_WATERCAN.flowerChance;
  }
}
