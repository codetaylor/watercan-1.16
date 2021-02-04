package com.codetaylor.mc.watercan;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber(modid = WatercanMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WatercanModCommonConfig {

  public static ForgeConfigSpec CONFIG_SPEC;
  public static ConfigCommon CONFIG;

  static {
    ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    CONFIG = new ConfigCommon(builder);
    CONFIG_SPEC = builder.build();
  }

  @SubscribeEvent
  public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {

    if (configEvent.getConfig().getSpec() == WatercanModCommonConfig.CONFIG_SPEC) {
      WatercanModCommonConfig.bake();
    }
  }

  public static Watercan WOODEN_WATERCAN;
  public static Watercan STONE_WATERCAN;
  public static Watercan IRON_WATERCAN;
  public static Watercan GOLD_WATERCAN;
  public static Watercan DIAMOND_WATERCAN;

  public static void bake() {

    WOODEN_WATERCAN = CONFIG.woodenWatercan.bake();
    STONE_WATERCAN = CONFIG.stoneWatercan.bake();
    IRON_WATERCAN = CONFIG.ironWatercan.bake();
    GOLD_WATERCAN = CONFIG.goldWatercan.bake();
    DIAMOND_WATERCAN = CONFIG.diamondWatercan.bake();
  }

  public static class ConfigCommon {

    public Watercan woodenWatercan;
    public Watercan stoneWatercan;
    public Watercan ironWatercan;
    public Watercan goldWatercan;
    public Watercan diamondWatercan;

    public ConfigCommon(ForgeConfigSpec.Builder builder) {

      this.woodenWatercan = new Watercan(
          builder,
          "wooden_watercan",
          true,
          1000,
          0,
          0,
          5,
          false,
          true,
          true,
          true,
          true,
          true,
          true,
          true
      );
      this.stoneWatercan = new Watercan(
          builder,
          "stone_watercan",
          true,
          2000,
          1,
          1,
          15,
          false,
          true,
          true,
          true,
          true,
          true,
          true,
          true
      );
      this.ironWatercan = new Watercan(
          builder,
          "iron_watercan",
          true,
          4000,
          1,
          1,
          10,
          false,
          true,
          true,
          true,
          true,
          true,
          true,
          true
      );
      this.goldWatercan = new Watercan(
          builder,
          "gold_watercan",
          true,
          4000,
          1,
          50,
          40,
          false,
          true,
          true,
          true,
          true,
          true,
          true,
          true
      );
      this.diamondWatercan = new Watercan(
          builder,
          "diamond_watercan",
          true,
          0,
          2,
          2,
          10,
          false,
          true,
          true,
          true,
          true,
          true,
          true,
          true
      );
    }
  }

  public static class Watercan {

    public boolean isDispensable;
    public int capacity;
    public int range;
    public int flowerChance;
    public int delayModifier;
    public boolean consumeWaterSource;
    public boolean extinguishFire;
    public boolean moisturizeFarmland;
    public boolean spawnFlowers;
    public boolean growCrops;
    public boolean growSaplings;
    public boolean spreadGrass;
    public boolean spreadMycelium;

    public Watercan bake() {

      this.isDispensable = this._isDispensable.get();
      this.capacity = this._capacity.get();
      this.range = this._range.get();
      this.flowerChance = this._flowerChance.get();
      this.delayModifier = this._delayModifier.get();
      this.consumeWaterSource = this._consumeWaterSource.get();
      this.extinguishFire = this._extinguishFire.get();
      this.moisturizeFarmland = this._moisturizeFarmland.get();
      this.spawnFlowers = this._spawnFlowers.get();
      this.growCrops = this._growCrops.get();
      this.growSaplings = this._growSaplings.get();
      this.spreadGrass = this._spreadGrass.get();
      this.spreadMycelium = this._spreadMycelium.get();
      return this;
    }

    public final ForgeConfigSpec.BooleanValue _isDispensable;
    public final ForgeConfigSpec.IntValue _capacity;
    public final ForgeConfigSpec.IntValue _range;
    public final ForgeConfigSpec.IntValue _flowerChance;
    public final ForgeConfigSpec.IntValue _delayModifier;
    public final ForgeConfigSpec.BooleanValue _consumeWaterSource;
    public final ForgeConfigSpec.BooleanValue _extinguishFire;
    public final ForgeConfigSpec.BooleanValue _moisturizeFarmland;
    public final ForgeConfigSpec.BooleanValue _spawnFlowers;
    public final ForgeConfigSpec.BooleanValue _growCrops;
    public final ForgeConfigSpec.BooleanValue _growSaplings;
    public final ForgeConfigSpec.BooleanValue _spreadGrass;
    public final ForgeConfigSpec.BooleanValue _spreadMycelium;

    public Watercan(
        ForgeConfigSpec.Builder builder,
        String category,
        boolean isDispensable,
        int capacity,
        int range,
        int flowerChance,
        int delayModifier,
        boolean consumeWaterSource,
        boolean extinguishFire,
        boolean moisturizeFarmland,
        boolean spawnFlowers,
        boolean growCrops,
        boolean growSaplings,
        boolean spreadGrass,
        boolean spreadMycelium
    ) {

      builder.push(category);
      this._isDispensable = builder
          .comment(
              "If true, the watercan can be used in a dispenser.",
              "Default: " + isDispensable
          )
          .define("isDispensable", true);
      this._capacity = builder
          .comment(
              "Defines the capacity of the watercan in millibuckets.",
              "Set to zero to make the can never run out of water.",
              "Default: " + capacity
          )
          .defineInRange("capacity", capacity, 0, Short.MAX_VALUE);
      this._range = builder
          .comment(
              "Defines the range of the watercan.",
              "This is the radius that the water will spread out from the targeted block.",
              "For example, a radius of one will water a 3x3 area and a radius of two will water a 5x5 area.",
              "Default: " + range
          )
          .defineInRange("range", range, 0, 8);
      this._flowerChance = builder
          .comment(
              "The flower chance controls the spawn rate of flowers on watered grass blocks.",
              "The higher the number the higher the chance to spawn flowers while watering.",
              "Range: [0,100]",
              "Default: " + flowerChance
          )
          .defineInRange("flowerChance", flowerChance, 0, 100);
      this._delayModifier = builder
          .comment(
              "Use the delay modifier to speed up or slow down growth.",
              "Smaller is faster.",
              "Default: " + delayModifier
          )
          .defineInRange("delayModifier", delayModifier, 1, 40);
      this._consumeWaterSource = builder
          .comment(
              "Set to true to consume the water source block when filling the watercan.",
              "Default: " + consumeWaterSource
          )
          .define("consumeWaterSource", consumeWaterSource);
      this._extinguishFire = builder
          .comment(
              "Set to false to prevent the watercan from extinguishing fire.",
              "Default: " + extinguishFire
          )
          .define("extinguishFire", extinguishFire);
      this._moisturizeFarmland = builder
          .comment(
              "Set to false to prevent the watercan from moisturizing farmland.",
              "Default: " + moisturizeFarmland
          )
          .define("moisturizeFarmland", moisturizeFarmland);
      this._spawnFlowers = builder
          .comment(
              "Set to false to prevent the watercan from spawning flowers on grass.",
              "Default: " + spawnFlowers
          )
          .define("spawnFlowers", spawnFlowers);
      this._growCrops = builder
          .comment(
              "Set to false to prevent the watercan from growing crops / growables.",
              "Default: " + growCrops
          )
          .define("growCrops", growCrops);
      this._growSaplings = builder
          .comment(
              "Set to false to prevent the watercan from growing saplings.",
              "Default: " + growSaplings
          )
          .define("growSaplings", growSaplings);
      this._spreadGrass = builder
          .comment(
              "Set to false to prevent the watercan from spreading grass.",
              "Default: " + spreadGrass
          )
          .define("spreadGrass", spreadGrass);
      this._spreadMycelium = builder
          .comment(
              "Set to false to prevent the watercan from spreading mycelium.",
              "Default: " + spreadMycelium
          )
          .define("spreadMycelium", spreadMycelium);
      builder.pop();
    }
  }
}
