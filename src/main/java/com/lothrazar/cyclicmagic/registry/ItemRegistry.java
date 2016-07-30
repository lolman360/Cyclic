package com.lothrazar.cyclicmagic.registry;
import java.util.HashMap;
import java.util.Map;
import com.lothrazar.cyclicmagic.IHasConfig;
import com.lothrazar.cyclicmagic.ModMain;
import com.lothrazar.cyclicmagic.item.ItemAppleEmerald;
import com.lothrazar.cyclicmagic.item.ItemChestSack;
import com.lothrazar.cyclicmagic.item.ItemChestSackEmpty;
import com.lothrazar.cyclicmagic.item.ItemCyclicWand;
import com.lothrazar.cyclicmagic.item.ItemEnderBook;
import com.lothrazar.cyclicmagic.item.ItemToolPearlReuse;
import com.lothrazar.cyclicmagic.item.ItemFoodCorruptedChorus;
import com.lothrazar.cyclicmagic.item.ItemFoodCrafting;
import com.lothrazar.cyclicmagic.item.ItemFoodHeart;
import com.lothrazar.cyclicmagic.item.ItemFoodInventory;
import com.lothrazar.cyclicmagic.item.ItemInventoryStorage;
import com.lothrazar.cyclicmagic.item.ItemPaperCarbon;
import com.lothrazar.cyclicmagic.item.ItemSleepingBag;
import com.lothrazar.cyclicmagic.item.ItemSproutSeeds;
import com.lothrazar.cyclicmagic.item.ItemToolHarvest;
import com.lothrazar.cyclicmagic.item.ItemToolSpawnInspect;
import com.lothrazar.cyclicmagic.item.projectile.*;
import com.lothrazar.cyclicmagic.util.Const;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {
  public static Map<String, Item> itemMap = new HashMap<String, Item>();
  public static ItemCyclicWand cyclic_wand_build;
  public static ItemPaperCarbon carbon_paper;
  public static ItemProjectileTNT ender_tnt_1;
  public static ItemProjectileTNT ender_tnt_2;
  public static ItemProjectileTNT ender_tnt_3;
  public static ItemProjectileTNT ender_tnt_4;
  public static ItemProjectileTNT ender_tnt_5;
  public static ItemProjectileTNT ender_tnt_6;
  public static Item tool_push;
  public static ItemAppleEmerald apple_emerald;
  public static ItemToolHarvest tool_harvest_weeds;
  public static ItemToolHarvest tool_harvest_crops;
  public static ItemToolHarvest tool_harvest_leaves;
  public static ItemChestSackEmpty chest_sack_empty;
  public static ItemChestSack chest_sack;
  public static ItemEnderBook book_ender;
  public static ItemInventoryStorage storage_bag;
  public static ItemToolSpawnInspect tool_spawn_inspect;
  public static ItemSleepingBag sleeping_mat;
  public static ItemToolPearlReuse ender_pearl_reuse;
  public static ItemProjectileBlaze ender_blaze;
  public static ItemProjectileDungeon ender_dungeon;
  public static ItemProjectileFishing ender_fishing;
  public static ItemProjectileWool ender_wool;
  public static ItemProjectileTorch ender_torch;
  public static ItemProjectileWater ender_water;
  public static ItemProjectileSnow ender_snow;
  public static ItemProjectileLightning ender_lightning;
  public static ItemSproutSeeds sprout_seed;
  public static ItemFoodCrafting crafting_food;
  public static ItemFoodInventory inventory_food;
  public static ItemFoodHeart heart_food;
  public static ItemFoodCorruptedChorus corrupted_chorus;
  public static Item addItem(Item i, String key) {
    i.setUnlocalizedName(key);
    itemMap.put(key, i);
    return i;
  }
  public static void syncConfig(Configuration config) {
    Item item;
    for (String key : itemMap.keySet()) {
      item = itemMap.get(key);
      if (item instanceof IHasConfig) {
        ((IHasConfig) item).syncConfig(config);
      }
    }
  }
  public static void registerItem(Item item, String name) {
    registerItem(item, name, false);// default is not hidden
  }
  public static void registerItem(Item item, String name, boolean isHidden) {
    GameRegistry.register(item, new ResourceLocation(Const.MODID, name));
    if (isHidden == false) {
      item.setCreativeTab(ModMain.TAB);
    }
  }
}
