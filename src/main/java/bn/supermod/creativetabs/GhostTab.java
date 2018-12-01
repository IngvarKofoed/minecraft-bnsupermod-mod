package bn.supermod.creativetabs;

import bn.supermod.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class GhostTab extends CreativeTabs {
	public GhostTab() 
	{
		super("ghost");
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ItemInit.GHOST_SWORD);
	}
}
