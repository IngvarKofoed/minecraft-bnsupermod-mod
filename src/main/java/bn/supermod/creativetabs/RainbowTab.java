package bn.supermod.creativetabs;

import bn.supermod.init.BlockInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RainbowTab extends CreativeTabs {
	public RainbowTab() 
	{
		super("rainbow");
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(BlockInit.RAINBOW_ORE);
	}
}
