package bn.supermod.util.handlers;

import bn.supermod.Main;
import bn.supermod.commands.CommandTeleportDimension;
import bn.supermod.ghost.init.GhostBlockInit;
import bn.supermod.ghost.init.GhostItemInit;
import bn.supermod.ghost.init.GhostRecipeInit;
import bn.supermod.init.BiomeInit;
import bn.supermod.init.BlockInit;
import bn.supermod.init.DimensionInit;
import bn.supermod.init.ItemInit;
import bn.supermod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@EventBusSubscriber
public class RegistryHandler {
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
		event.getRegistry().registerAll(GhostItemInit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
		event.getRegistry().registerAll(GhostBlockInit.BLOCKS.toArray(new Block[0]));
		TileEntityHandler.registerTileEntities();
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCopperChest.class, new RenderCopperChest());
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{		
		// Main.proxy.registerModel(Item.getItemFromBlock(BlockInit.COPPER_CHEST), 0);
		
		for(Item item : ItemInit.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				Main.logger.info(item.getRegistryName());
				((IHasModel)item).registerModels();
			}
		}
		
		for(Item item : GhostItemInit.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				Main.logger.info(item.getRegistryName());
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : BlockInit.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				Main.logger.info(block);
				((IHasModel)block).registerModels();
			}
		}
		
		for(Block block : GhostBlockInit.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				Main.logger.info(block);
				((IHasModel)block).registerModels();
			}
		}
	}
	
	public static void preInitRegistries(FMLPreInitializationEvent event)
	{
		// FluidInit.registerFluids();
		
		//GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
		//GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
		//GameRegistry.registerWorldGenerator(new WorldGenCustomTrees(), 0);
		
		BiomeInit.registerBiomes();
		DimensionInit.registerDimensions();
		//EntityInit.registerEntities();
		//RenderHandler.registerEntityRenders();
		//RenderHandler.registerCustomMeshesAndStates();
		//ModConfiguration.registerConfig(event);
	}
	
	public static void initRegistries(FMLInitializationEvent event)
	{
		GhostRecipeInit.init();
		// NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
		// SoundsHandler.registerSounds();		
	}
	
	public static void postInitRegistries(FMLPostInitializationEvent event)
	{
		// WorldType COPPER = new WorldTypeCopper();
	}
	
	public static void serverRegistries(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandTeleportDimension());
	}
}
