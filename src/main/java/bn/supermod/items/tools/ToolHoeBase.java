package bn.supermod.items.tools;

import java.util.List;

import bn.supermod.Main;
import bn.supermod.init.ItemInit;
import bn.supermod.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item.ToolMaterial;

public class ToolHoeBase extends ItemHoe implements IHasModel 
{
	public ToolHoeBase(String name, ToolMaterial material, CreativeTabs tab) 
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		
		ItemInit.ITEMS.add(this);
	}
	
	public ToolHoeBase(String name, ToolMaterial material, CreativeTabs tab, List<Item> items)
    {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
        
        items.add(this);
    }

	@Override
	public void registerModels() 
	{
		Main.proxy.registerModel(this, 0);
	}
}
