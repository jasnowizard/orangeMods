package com.github.jasnowizard;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;


public class EbonyIngot_Item extends Item {

    public EbonyIngot_Item(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.BLOCK_COPPER_BREAK, 1.0F, 1.0F);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {

        int currentDay = 22;
        int currentMonth = 12;
        String blow = "Ebony man";
        tooltip.add(new TranslatableText("item.orangemods.ebonyingot_item.tooltip_1", currentDay, currentMonth, blow));

        // default white text
        tooltip.add( new TranslatableText("item.orangemods.ebonyingot_item.tooltip_2") );

        // formatted red text
        tooltip.add( new TranslatableText("item.orangemods.ebonyingot_item.tooltip_2").formatted(Formatting.RED) );

        // formatted red text
        tooltip.add( new TranslatableText("item.orangemods.ebonyingot_item.tooltip_2").formatted(Formatting.GREEN) );
    }

}
