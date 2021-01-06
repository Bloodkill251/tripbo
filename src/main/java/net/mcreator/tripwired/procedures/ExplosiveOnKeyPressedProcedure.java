package net.mcreator.tripwired.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.tripwired.potion.AllowedExplosivePotion;
import net.mcreator.tripwired.TripwiredModElements;

import java.util.Map;
import java.util.Collection;

@TripwiredModElements.ModElement.Tag
public class ExplosiveOnKeyPressedProcedure extends TripwiredModElements.ModElement {
	public ExplosiveOnKeyPressedProcedure(TripwiredModElements instance) {
		super(instance, 34);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ExplosiveOnKeyPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ExplosiveOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((new Object() {
			boolean check(Entity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == AllowedExplosivePotion.potion)
							return true;
					}
				}
				return false;
			}
		}.check(entity))) {
			if (world instanceof World && !world.getWorld().isRemote) {
				world.getWorld().createExplosion(null,
						(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100, entity.getLook(1f).z * 100),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
						(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100, entity.getLook(1f).z * 100),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
						(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100, entity.getLook(1f).z * 100),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()),
						(float) 2, Explosion.Mode.BREAK);
			}
		}
	}
}
