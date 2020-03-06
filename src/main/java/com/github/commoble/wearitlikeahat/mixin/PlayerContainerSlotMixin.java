package com.github.commoble.wearitlikeahat.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.github.commoble.wearitlikeahat.MixinHelpers;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

@Mixin(targets= {"net/minecraft/inventory/container/PlayerContainer$1"})
public abstract class PlayerContainerSlotMixin
{
	@Shadow
	EquipmentSlotType val$equipmentslottype;

	@Inject(method = "isItemValid", at = @At("HEAD"), cancellable = true)
	public void onIsItemValid(ItemStack stack, CallbackInfoReturnable<Boolean> info)
	{
		MixinHelpers.onIsItemValid(stack, info, this.val$equipmentslottype);
	}
}
