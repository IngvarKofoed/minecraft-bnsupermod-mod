package bn.supermod.init;

import java.util.ArrayList;
import java.util.List;

import bn.supermod.Main;
import bn.supermod.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Copper
	public static final Block DEAMON_BLOCK = new BlockBase("deamon_block", Material.IRON, Main.CREATIVE_TAB);
	public static final Block DEAMON_DIRT = new BlockBase("deamon_dirt", Material.GROUND, Main.CREATIVE_TAB);
	public static final Block DEAMON_STONE = new BlockBase("deamon_stone", Material.ROCK, Main.CREATIVE_TAB);
	//public static final Block DEAMON_DIRT = new BlockDirtBase("copper_dirt", Main.CREATIVE_TAB);
	//public static final Block COPPER_LEAVES = new BlockLeavesBase("copper_leaves");
	//public static final Block COPPER_LOG = new BlockLogBase("copper_log");
	public static final Block DEAMON_ORE = new BlockBase("deamon_ore", Material.ROCK, Main.CREATIVE_TAB);
}
