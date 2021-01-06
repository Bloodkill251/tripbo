package net.mcreator.tripwired.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.tripwired.potion.AcidImmunityPotion;
import net.mcreator.tripwired.TripwiredModElements;

import java.util.Map;

@TripwiredModElements.ModElement.Tag
public class NetheriteAppleFoodEatenProcedure extends TripwiredModElements.ModElement {
	public NetheriteAppleFoodEatenProcedure(TripwiredModElements instance) {
		super(instance, 32);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure NetheriteAppleFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double a = 0;
		boolean b = false;
		String c = "";
		ItemStack d = ItemStack.EMPTY;
		{
			Map<Enchantment, Integer> _enchantments = EnchantmentHelper
					.getEnchantments(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY));
			if (_enchantments.containsKey(Enchantments.SHARPNESS)) {
				_enchantments.remove(Enchantments.SHARPNESS);
				EnchantmentHelper.setEnchantments(_enchantments,
						((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY));
			}
		}
		(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).addEnchantment(Enchantments.SHARPNESS,
				(int) 6);
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1200, (int) 2, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 1200, (int) 9, (false), (false)));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(AcidImmunityPotion.potion, (int) 300, (int) 0, (false), (false)));
	}
}
