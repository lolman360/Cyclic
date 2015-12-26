package com.lothrazar.cyclicmagic;

import java.util.ArrayList;
import com.lothrazar.cyclicmagic.item.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {
	public static ArrayList<Item> items = new ArrayList<Item>();

	public static ItemRespawnEggAnimal respawn_egg;
	public static ItemChestSack chest_sack;
	public static MasterWand master_wand;
	public static ItemPaperCarbon carbon_paper;
	public static ItemWaypointPortal waypoint_portal;
	
	//convention: runes turn on and off
	public static ItemRuneCollector rune_collector;
	public static ItemRuneSlowfall rune_slowfall;
	public static ItemRuneProtection rune_protection;
	public static ItemRuneHaste rune_haste;

	public static void register() {
		chest_sack = new ItemChestSack();
		ItemRegistry.registerItem(chest_sack, "chest_sack");

		respawn_egg = new ItemRespawnEggAnimal();
		ItemRegistry.registerItem(respawn_egg, "respawn_egg");

		carbon_paper = new ItemPaperCarbon();
		ItemRegistry.registerItem(carbon_paper, "carbon_paper");

		waypoint_portal = new ItemWaypointPortal();
		ItemRegistry.registerItem(waypoint_portal, "waypoint_portal");

		rune_haste = new ItemRuneHaste();
		ItemRegistry.registerItem(rune_haste, "rune_haste");

		rune_collector = new ItemRuneCollector();
		ItemRegistry.registerItem(rune_collector, "rune_collector");

		rune_protection = new ItemRuneProtection();
		ItemRegistry.registerItem(rune_protection, "rune_protection");

		rune_slowfall = new ItemRuneSlowfall();
		ItemRegistry.registerItem(rune_slowfall, "rune_slowfall");

		master_wand = new MasterWand();
		ItemRegistry.registerItem(master_wand, "master_wand");

		GameRegistry.addRecipe(new ItemStack(master_wand), //placeholder rec
				"sds",
				" s ",
				"qoq",
				'd',Blocks.diamond_block,
				'q',Blocks.quartz_block,
				'o',Blocks.obsidian,
				's',Items.nether_star);
		
		master_wand.setContainerItem(master_wand);//so it is not consumed on crafting
		
		GameRegistry.addShapelessRecipe(new ItemStack(rune_slowfall)
				,master_wand
				,Blocks.gold_block
				,Items.nether_star);

		GameRegistry.addShapelessRecipe(new ItemStack(rune_collector)
				,master_wand
				,Blocks.lapis_block
				,Items.nether_star);

		GameRegistry.addShapelessRecipe(new ItemStack(rune_haste)
				,master_wand
				,Blocks.redstone_block
				,Items.nether_star);

		GameRegistry.addShapelessRecipe(new ItemStack(rune_protection)
				,master_wand
				,Blocks.emerald_block
				,Items.nether_star);
	}

	public static void registerItem(Item item, String name) {
		item.setUnlocalizedName(name);
		GameRegistry.registerItem(item, name);
		items.add(item);
	}
}
