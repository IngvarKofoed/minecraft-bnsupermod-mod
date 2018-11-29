package bn.supermod;
 
import org.apache.logging.log4j.Logger;

import bn.supermod.creativetabs.DeamonTab;
import bn.supermod.proxy.CommonProxy;
import bn.supermod.util.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION) 
public class Main {
	public static Logger logger;
	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = "bn.supermod.proxy.ClientProxy", serverSide = "bn.supermod.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	public static final CreativeTabs CREATIVE_TAB = new DeamonTab();
	

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) 
	{	
		logger = event.getModLog();
		RegistryHandler.preInitRegistries(event);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		RegistryHandler.initRegistries(event);
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) 
	{
		RegistryHandler.postInitRegistries(event);
	}
	
	@EventHandler
	public static void serverInit(FMLServerStartingEvent event)
	{
		RegistryHandler.serverRegistries(event);
	}}
