
package net.mcreator.tripwired.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.tripwired.block.DeathPlankBlock;
import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class DeathPlankFuelFuel extends TripwiredModElements.ModElement {
	public DeathPlankFuelFuel(TripwiredModElements instance) {
		super(instance, 79);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(DeathPlankBlock.block, (int) (1)).getItem())
			event.setBurnTime(3200);
	}
}
