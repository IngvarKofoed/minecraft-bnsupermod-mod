package bn.supermod.init;

import bn.supermod.Main;
import bn.supermod.util.ModConfiguration;
import bn.supermod.world.dimensions.DimensionLibrary;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionInit {

	public static final DimensionType DEAMON = DimensionType.register("Deamon World", "_deamon", ModConfiguration.DIMENSION_DEAMON_ID, DimensionLibrary.class, false);
	
	public static void registerDimensions()
	{
		Main.logger.warn(DEAMON);
		DimensionManager.registerDimension(ModConfiguration.DIMENSION_DEAMON_ID, DEAMON);
	}
}
