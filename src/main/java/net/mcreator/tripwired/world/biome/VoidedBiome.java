
package net.mcreator.tripwired.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.Biome;

import net.mcreator.tripwired.block.VoidBlockBlock;
import net.mcreator.tripwired.TripwiredModElements;

@TripwiredModElements.ModElement.Tag
public class VoidedBiome extends TripwiredModElements.ModElement {
	@ObjectHolder("tripwired:voided")
	public static final CustomBiome biome = null;
	public VoidedBiome(TripwiredModElements instance) {
		super(instance, 109);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0f).depth(10f).scale(2f).temperature(2f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE).waterColor(-16777216).waterFogColor(-16777216)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(VoidBlockBlock.block.getDefaultState(),
							VoidBlockBlock.block.getDefaultState(), VoidBlockBlock.block.getDefaultState())));
			setRegistryName("voided");
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getGrassColor(double posX, double posZ) {
			return -16777216;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getFoliageColor() {
			return -16777216;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getSkyColor() {
			return -16777216;
		}
	}
}
