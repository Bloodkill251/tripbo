package net.mcreator.tripwired.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.tripwired.potion.AcidImmunityPotion;
import net.mcreator.tripwired.TripwiredModElements;

import java.util.Map;
import java.util.Collection;

@TripwiredModElements.ModElement.Tag
public class AcidMobplayerCollidesBlockProcedure extends TripwiredModElements.ModElement {
	public AcidMobplayerCollidesBlockProcedure(TripwiredModElements instance) {
		super(instance, 19);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure AcidMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!(new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == AcidImmunityPotion.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity)))) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("acid").setDamageBypassesArmor(), (float) 2.65);
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 140, (int) 0, (false), (false)));
		}
	}
}
