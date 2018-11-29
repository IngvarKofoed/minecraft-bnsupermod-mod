package bn.supermod.world.biomes;

import bn.supermod.init.BlockInit;
import net.minecraft.world.biome.Biome;

public class DeamonBiome extends Biome  {
	
	public DeamonBiome() 
	{
		super(new BiomeProperties("Deamon").setBaseHeight(1.0F).setHeightVariation(1.0F).setRainDisabled().setTemperature(1.0F));
		
		topBlock = BlockInit.DEAMON_DIRT.getDefaultState();
		fillerBlock = BlockInit.DEAMON_ORE.getDefaultState();
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
		// this.spawnableCreatureList.add(new SpawnListEntry(EntityCentaur.class, 5, 1, 5));
	}
}
