package bn.supermod.init;

import java.util.ArrayList;
import java.util.List;

import bn.supermod.Main;
import bn.supermod.blocks.BlockBase;
import bn.supermod.rainbow.blocks.RainbowDirtBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInit {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	// Deamon
	public static final Block DEAMON_BLOCK = new BlockBase("deamon_block", Material.IRON, Main.DEAMON_TAB);
	public static final Block DEAMON_DIRT = new BlockBase("deamon_dirt", Material.GROUND, Main.DEAMON_TAB);
	public static final Block DEAMON_STONE = new BlockBase("deamon_stone", Material.ROCK, Main.DEAMON_TAB);
	public static final Block DEAMON_ORE = new BlockBase("deamon_ore", Material.ROCK, Main.DEAMON_TAB);

	// Ghost
	// public static final Block GHOST_BLOCK = new BlockBase("ghost_block", Material.IRON, Main.GHOST_TAB);
	// public static final Block GHOST_DIRT = new BlockBase("ghost_dirt", Material.GROUND, Main.GHOST_TAB);
	// public static final Block GHOST_STONE = new BlockBase("ghost_stone", Material.ROCK, Main.GHOST_TAB);
	// public static final Block GHOST_ORE = new BlockBase("ghost_ore", Material.ROCK, Main.GHOST_TAB);
	
	// Rainbow
	public static final Block RAINBOW_DIRT = new RainbowDirtBlock("rainbow_dirt", Material.GROUND, Main.RAINBOW_TAB);
	public static final Block RAINBOW_STONE = new BlockBase("rainbow_stone", Material.ROCK, Main.RAINBOW_TAB);
	public static final Block RAINBOW_ORE = new BlockBase("rainbow_ore", Material.ROCK, Main.RAINBOW_TAB);
	
	//public static final Block DEAMON_DIRT = new BlockDirtBase("copper_dirt", Main.CREATIVE_TAB);
	//public static final Block COPPER_LEAVES = new BlockLeavesBase("copper_leaves");
	//public static final Block COPPER_LOG = new BlockLogBase("copper_log");
}
