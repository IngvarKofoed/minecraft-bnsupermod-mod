package bn.supermod.creativetabs;

import bn.supermod.init.BlockInit;
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
		return new ItemStack(BlockInit.GHOST_BLOCK);
	}
}
