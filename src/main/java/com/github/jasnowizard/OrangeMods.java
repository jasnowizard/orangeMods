package com.github.jasnowizard;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OrangeMods implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger("orangemods");

	// an instance of our new item not requiring a class
	//public static final Item FABRIC_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MISC));

	// An instance of our new item, where the maximum stack size is 16
	public static final FabricItem FABRIC_ITEM = new FabricItem(new FabricItemSettings().group(OrangeMods.ORANGE_ITEM_GROUP).maxCount(16));

	public static final EbonyIngot_Item EBONYINGOT_ITEM = new EbonyIngot_Item(new FabricItemSettings().group(OrangeMods.ORANGE_ITEM_GROUP).maxCount(16));

	public static final ItemGroup ORANGE_ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier("orangemods", "orangesgroup"),
			() -> new ItemStack(Blocks.COBBLESTONE));


	public static final ItemGroup PURPLE_ITEM_GROUP = FabricItemGroupBuilder.create(
					new Identifier("orangemods", "purplesgroup"))
			.icon(() -> new ItemStack(Items.BOWL))
			.appendItems(stacks -> {
				stacks.add(new ItemStack(Blocks.BONE_BLOCK));
				stacks.add(new ItemStack(Items.APPLE));
				stacks.add(new ItemStack(FABRIC_ITEM));
				stacks.add(new ItemStack(EBONYINGOT_ITEM));
				stacks.add(PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER));
				stacks.add(ItemStack.EMPTY);
				stacks.add(new ItemStack(Items.IRON_SHOVEL));
			})
			.build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world! designer Jvalve Design");

		Registry.register(Registry.ITEM, new Identifier("orangemods", "fabric_item"), FABRIC_ITEM);
		Registry.register(Registry.ITEM, new Identifier( "orangemods", "ebonyingot_item"), EBONYINGOT_ITEM);
	}
}
