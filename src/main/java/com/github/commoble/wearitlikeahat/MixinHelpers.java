package com.github.commoble.wearitlikeahat;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.MobEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class MixinHelpers
{
	public static void onIsItemValid(ItemStack stack, CallbackInfoReturnable<Boolean> info, EquipmentSlotType slotType)
	{
		if (slotType == EquipmentSlotType.HEAD && MobEntity.getSlotForItemStack(stack) == EquipmentSlotType.MAINHAND)
		{
			info.setReturnValue(true);
		}
	}
}
