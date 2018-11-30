package bn.supermod.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerModel(Item item, int metadata) 
	{
		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	@Override
	public void registerModel(Item item, int metadata, String registryName) {
		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(registryName, "inventory"));
	}
}
