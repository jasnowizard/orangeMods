package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class ExampleMod implements ModInitializer {

	//adding custom item groups
	//Once FabricItemGroupBuilder#build is called, your group will be added to the list of item groups in the creative menu.
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier("tutorial", "general"),
			() -> new ItemStack(Blocks.COBBLESTONE));

	public static final ItemGroup MYITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier("tutorial", "my-general"),
			() -> new ItemStack(ExampleMod.FABRIC_ITEM));


	public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(
			new Identifier("tutorial", "other"))
			.icon(() -> new ItemStack(Items.BOWL))
			.build();

    // an instance of our new item, out of the box
    //public static final Item FABRIC_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	//
	//using my custom item class, max stack of 16, including item in my custom itemgroup ExampleMod.ITEM_GROUP
	public static final FabricItem FABRIC_ITEM = new FabricItem(new FabricItemSettings().group(ExampleMod.MYITEM_GROUP).maxCount(16));


 

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");

        Registry.register(Registry.ITEM, new Identifier("tutorial", "fabric_item"), FABRIC_ITEM);
 
	}
}


