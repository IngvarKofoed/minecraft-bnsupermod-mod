package bn.supermod.ghost.init;

import java.util.ArrayList;
import java.util.List;

import bn.supermod.Main;
import bn.supermod.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GhostBlockInit 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block GHOST_ORE = new BlockBase("ghost_ore", Material.ROCK, Main.GHOST_TAB, BLOCKS, GhostItemInit.ITEMS);
}
