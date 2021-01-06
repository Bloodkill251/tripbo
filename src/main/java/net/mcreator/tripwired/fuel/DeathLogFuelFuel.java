
package net.mcreator.tripwired.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.tripwired.block.DeathLogBlock;
import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class DeathLogFuelFuel extends TripwiredModElements.ModElement {
	public DeathLogFuelFuel(TripwiredModElements instance) {
		super(instance, 80);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(DeathLogBlock.block, (int) (1)).getItem())
			event.setBurnTime(3200);
	}
}
