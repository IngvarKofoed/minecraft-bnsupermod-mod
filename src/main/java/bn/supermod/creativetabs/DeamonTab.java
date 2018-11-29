package bn.supermod.creativetabs;

import bn.supermod.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class DeamonTab extends CreativeTabs {
	public DeamonTab() 
	{
		super("deamon");
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ItemInit.DEAMON_HELMET);
		//return new ItemStack(Items.APPLE);//ItemInit.COPPER_INGOT);
	}
}
