package bn.supermod.rainbow.items;

import bn.supermod.rainbow.EnumRainbowColor;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class RainbowDirtItemBlock extends ItemBlock 
{
	public RainbowDirtItemBlock(Block block)
	{
		super(block);
	    this.setMaxDamage(0);
	    this.setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int metadata)
	{
		return metadata;
	}


	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		EnumRainbowColor colour = EnumRainbowColor.byMetadata(stack.getMetadata());
		return super.getUnlocalizedName() + "." + colour.toString();
	}
}
