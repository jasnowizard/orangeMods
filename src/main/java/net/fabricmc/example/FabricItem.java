package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.registry.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.registry.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.util.Hand;
//import net.minecraft.util.TypedActionResult;
import net.minecraft.util.*;
import net.minecraft.sound.SoundEvents;




public class FabricItem extends Item {
     
	public FabricItem(Settings settings) {
		super(settings);
	}
 
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
		playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
		return TypedActionResult.success(playerEntity.getStackInHand(hand));
	}
}