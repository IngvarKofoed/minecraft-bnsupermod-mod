package bn.supermod.util.handlers;

import bn.supermod.Reference;
import bn.supermod.deamon.tileentities.DeamonDimensionTeleporterTileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(DeamonDimensionTeleporterTileEntity.class, new ResourceLocation(Reference.MODID + ":deamon_teleporter"));
		//GameRegistry.registerTileEntity(TileEntitySinteringFurnace.class, new ResourceLocation(Reference.MODID + ":sintering_furnace"));
		//GameRegistry.registerTileEntity(TileEntityGlowstoneGenerator.class, new ResourceLocation(Reference.MODID + ":glowstone_generator"));
		//GameRegistry.registerTileEntity(TileEntityElectricSinteringFurnace.class, new ResourceLocation(Reference.MODID + ":electric_sintering_furnace"));
		//GameRegistry.registerTileEntity(TileEntityEnergyStorage.class, new ResourceLocation(Reference.MODID + ":energy_storage"));
	}
}
