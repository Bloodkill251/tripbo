
package net.mcreator.tripwired.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class SapphireaHoeItem extends TripwiredModElements.ModElement {
	@ObjectHolder("tripwired:sapphirea_hoe")
	public static final Item block = null;
	public SapphireaHoeItem(TripwiredModElements instance) {
		super(instance, 101);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 2561;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 0f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SapphireItem.block, (int) (1)));
			}
		}, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("sapphirea_hoe"));
	}
}
